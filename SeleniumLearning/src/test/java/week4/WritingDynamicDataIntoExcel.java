package week4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDynamicDataIntoExcel {
    //Dynamically writing-input from user
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//everything  create newly
		
				//1.create new file 
				FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\myfile_dynamic.xlsx");
				
				//2.create workbook
				XSSFWorkbook workbook=new XSSFWorkbook();
				
				//3.create sheet
				XSSFSheet sheet=workbook.createSheet("Data");
				
				//input from user
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter how many rows?");
				int noOfrows=sc.nextInt();
				
				System.out.println("Enter how many cells?");
				int noOfcells=sc.nextInt();
				
				
				for(int r=0;r<noOfrows;r++) {
					XSSFRow currentRow=sheet.createRow(r);
					
					for(int c=0;c<noOfcells;c++) { 
						XSSFCell cell=currentRow.createCell(c);
						cell.setCellValue(sc.next());
					}
				}
				workbook.write(file); //attach workbook to the file
				workbook.close();
				file.close();
				System.out.println("file created ...");
	}

}
