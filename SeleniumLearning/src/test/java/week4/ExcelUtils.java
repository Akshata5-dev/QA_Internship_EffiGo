package week4;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {

    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static CellStyle style;

    // Method to get the total number of rows
    public static int getRowCount(String xlfile, String xlsheet) throws IOException {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet); // Fix: Assign ws before using it
        int rowCount = ws.getLastRowNum();
        wb.close();
        fi.close();
        return rowCount;
    }

    // Method to get the total number of cells in a specific row
    public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
        fi = new FileInputStream(xlfile); // Fix: Use xlfile instead of xfile
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rownum);
        int cellCount = (row != null) ? row.getLastCellNum() : 0; // Fix: Handle null row
        wb.close();
        fi.close();
        return cellCount;
    }

    // Method to get the data from a specific cell
    public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rownum);

        String data = "";
        try {
            if (row != null) {
                cell = row.getCell(colnum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK); // Fix: Assign cell properly
                DataFormatter formatter = new DataFormatter();
                data = formatter.formatCellValue(cell);
            }
        } catch (Exception e) {
            data = "";
        }

        wb.close();
        fi.close();
        return data;
    }

    // Method to set data into a cell
    public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data) throws IOException {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rownum);
        if (row == null) {
            row = ws.createRow(rownum);
        }
        cell = row.createCell(colnum);
        cell.setCellValue(data);

        fo = new FileOutputStream(xlfile);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();
    }

    // Method to fill cell with Red color
    public static void fillRedColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rownum);
        if (row == null) {
            row = ws.createRow(rownum);
        }
        cell = row.getCell(colnum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

        style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);

        fo = new FileOutputStream(xlfile);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();
    }

	public static void fillGreenColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		    fi = new FileInputStream(xlfile);
	        wb = new XSSFWorkbook(fi);
	        ws = wb.getSheet(xlsheet);
	        row = ws.getRow(rownum);
	        if (row == null) {
	            row = ws.createRow(rownum);
	        }
	        cell = row.getCell(colnum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

	        style = wb.createCellStyle();
	        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        cell.setCellStyle(style);

	        fo = new FileOutputStream(xlfile);
	        wb.write(fo);
	        wb.close();
	        fi.close();
	        fo.close();
		
	}
}
