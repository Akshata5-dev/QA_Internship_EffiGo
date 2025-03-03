package week4;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDatainSpecificRowAndCell {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//1.create new file 
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\myfile_Random.xlsx");
		
		//2.create workbook
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		//3.create sheet
		XSSFSheet sheet=workbook.createSheet("Data");
		
		//Random update
		XSSFRow row=sheet.createRow(3); //count start from -0
		XSSFCell  cell=row.createCell(4);//count start from -0
		
		cell.setCellValue("Welcome");
		
		workbook.write(file); //attach workbook to the file
		workbook.close();
		file.close();
		System.out.println("file created ...");
	}

}
