package parser;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class Parser {
    public static String parse(String filename) {
        String result = "";
        InputStream inputStream = null;
        XSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(filename);
            workBook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet sheet = workBook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (it.hasNext()) {
                Cell cell = cells.next();
                CellType cellType = cell.getCellType();
                switch (cellType) {
                    case STRING:
                        result += cell.getStringCellValue() + " = ";
                        break;
                    case NUMERIC:
                        result += " [" + cell.getNumericCellValue() + "] ";
                        break;
                    case FORMULA:
                        result += " [" + cell.getCellFormula() + "] ";
                    default:
                        result += " | ";
                        break;
                }
            }
            result += "\n";
        }

        return result;
    }
}
