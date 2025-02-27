package week4;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPaginationTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get("https://www.ecomdeveloper.com/demo/admin/index.php");
		 driver.manage().window().maximize();
		 
		 WebElement username=driver.findElement(By.xpath("//input[@id='input-username']"));
		 username.clear(); //before pass value clear existing value
		 username.sendKeys("demoadmin");
		 
		 WebElement userpass=driver.findElement(By.xpath("//input[@id='input-password']"));
		 userpass.clear();
		 userpass.sendKeys("demopass");
		 
		 driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		 
	/*	 //close window if  it is available
		 if(driver.findElement(By.xpath("//button[@class='btn-close']")).isDisplayed()){
			 driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		 }  */
		 
		 //click customer main menu
		driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();	
		driver.findElement(By.xpath("//ul[@id='collapse9']//a[contains(text(),'Customers')]")).click();//sub menu
		
		//1.capture total no.of pages
		
		//Showing 1 to 10 of 19081(1909 pages)
		String text=driver.findElement(By.xpath("//div[contains(text(),'Pages')]")).getText();
		
		int total_pages=Integer.parseInt(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1));
		
		//2.repeating pages  total_pages take as=5
		for(int p=1;p<=5;p++) {
			//no need to click 1page its already opened
			if(p>1) {
				//page no. we have to pass dynamically "q"
				WebElement active_page=driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+p+"]"));
				active_page.click(); 
				
			}
			
			//reading data from the page
			//a.we need to find total no.of rows first
			int noOfRows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
            for(int r=1;r<=noOfRows;r++) {//r keep inc col remail same-2
            String customerName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
            String email=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[3]")).getText();
            String status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[5]")).getText();
            //repeat until reach all pages
            System.out.println(customerName+"\t"+email+"\t"+status);
            }
		}
	}

}
