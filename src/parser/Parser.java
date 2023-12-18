package parser;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Objects;

public class Parser {
    public static String parse(String filename) {
        StringBuilder result = new StringBuilder();
        try {
            InputStream ExcelFileToRead = new FileInputStream(filename);
            XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

            XSSFSheet sheet = wb.getSheetAt(0);
            XSSFRow row;
            XSSFCell cell;

            Iterator<Row> rows = sheet.rowIterator();

            while (rows.hasNext()) {
                row = (XSSFRow) rows.next();

                for(int i=0; i<row.getLastCellNum(); i++) {
                    cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    if (Objects.equals(cell.toString(), "")){
                        result.append("\t").append("|");
                        continue;
                    }
                    if (cell.toString().contains("Максимум:")){
                        break;
                    }
                    result.append(cell.toString()).append("|");
                }
                result.append("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString().replace("|Упр: ", "|");
    }
}
