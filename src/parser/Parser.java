package parser;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.function.Consumer;

public class Parser {
    private final File templateFile;

    public Parser(File templateFile) {
        this.templateFile = templateFile;
    }

    public void convert(File outputFile, Consumer<Workbook> workbookComposer) throws IOException {
        Files.copy(templateFile.toPath(), outputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(outputFile))) {
            workbookComposer.accept(workbook);
            try (OutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(outputFile.toPath()))) {
                workbook.write(outputStream);
            }
        }
    }
}
