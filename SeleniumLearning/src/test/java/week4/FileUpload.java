package week4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
	     driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
	     driver.manage().window().maximize();
	  /*   
	     //1.single file upload--ref1.pdf
	     driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:/Users/AKSHTA/Downloads/ref1.pdf");
	     
	    
	      if(driver.findElement(By.xpath("//ul[@id='fileList']/li")).getText().equals("ref1.pdf"))
	       {
	    	 System.out.println("File is successfully uploaded");
	     }
	       else{
	    	   System.out.println("File is successfully uploaded");
	       }
	      */
	     
	     //2.Multiple files uploaded
	     String file1="C:/Users/AKSHTA/Downloads/ref1.pdf";
	     String file2="C:/Users/AKSHTA/Downloads/ref2.pdf";
	     
	     driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);
	     //capture all files using xpath
	     
	     //validation 1-Number of files
	     int noOfFilesUploaded=driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
	     if(noOfFilesUploaded==2) {
	    	 System.out.println("All Files are uploaded");
	     }
	     else {
	    	 System.out.println("Files are Not uploaded or incorrect files uploaded"); 
	     }
	     
	     //validate files name
	     if(driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText().equals("ref1.pdf")
	    	 &&
	     driver.findElement(By.xpath("//ul[@id='fileList']//li[2]")).getText().equals("ref2.pdf"))
	     {
	    	 System.out.println("Files are matching ");
	     }
	     else {
	    	 System.out.println("Files are not matching ");
	     }
	     
	     //isDisplayed can be use bt in-case of web element these are text
	}

}
