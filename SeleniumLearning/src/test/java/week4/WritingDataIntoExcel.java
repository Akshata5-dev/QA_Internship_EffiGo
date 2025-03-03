package week4;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {

	//static data
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//everything  create newly
		
		//1.create new file 
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\myfile.xlsx");
		
		//2.create workbook
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		//3.create sheet
		XSSFSheet sheet=workbook.createSheet("Data");
		
		//4.creating cells in row1
		XSSFRow row1=sheet.createRow(0);
		row1.createCell(0).setCellValue("Java");
		row1.createCell(1).setCellValue(19);
		row1.createCell(2).setCellValue("Automation");
		
		XSSFRow row2=sheet.createRow(1);
		row2.createCell(0).setCellValue("Python");
		row2.createCell(1).setCellValue(4);
		row2.createCell(2).setCellValue("Automation");
		
		XSSFRow row3=sheet.createRow(2);
		row3.createCell(0).setCellValue("C#");
		row3.createCell(1).setCellValue(9);
		row3.createCell(2).setCellValue("Automation");
		
		//5.attach workbook to file
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("file created ...");
	}

}
