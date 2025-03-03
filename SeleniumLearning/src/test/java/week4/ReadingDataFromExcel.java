package week4;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
    //Heirarchy: Excel->workbook->sheets->Rows->Cells
		
		//1.Reading data
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\TestData\\TestData.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet sheet=workbook.getSheet("sheet1");
		//XSSFSheet sheet=workbook.getSheetAt(0);
		
		//last row no=no. of rows
		int totalRows=sheet.getLastRowNum();
		
		int totalCells=sheet.getRow(0).getLastCellNum();
		
		System.out.println("Number of rows:"+totalRows);//5
		System.out.println("Number of cells:"+totalCells);//4
		
		for(int r=0;r<=totalRows;r++) {
			XSSFRow currentRow=sheet.getRow(r);
			
			//read cells
			for(int c=0;c<totalCells;c++) {
				XSSFCell cell=currentRow.getCell(c);
				System.out.print(cell.toString()+"\t"); //toString add decimal to 
			}
			System.out.println();
		}
		workbook.close();
		file.close();

	}
}
