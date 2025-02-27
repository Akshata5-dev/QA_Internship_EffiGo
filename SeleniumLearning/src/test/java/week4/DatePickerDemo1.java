package week4;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo1 {
	//use for multiple date pickers in page
	//1.User defined method for future date
	static void selectFutureDate(WebDriver driver,String year,String month,String date) {
		//a.select month & year
		 while(true) {
			 //actual data
			 String currentMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			 String CurrentYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			 
			 if(currentMonth.equals(month)&&CurrentYear.equals(year)) {
				 break; 
			 }
			 driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); //next
			 //driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //prev
		 }
		//b.slect the date
		 List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td//a"));
		 
		 //repeat until expected date
		 for(WebElement dt:allDates) {
			 if(dt.getText().equals(date)) {
				 dt.click();
				 break;
			 }
		 }	
		 
	}
	
	//2.user define method for previous date
	static void selectPreviousDate(WebDriver driver,String year,String month,String date) {
		//a.select month & year
		 while(true) {
			 //actual data
			 String currentMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			 String CurrentYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			 
			 if(currentMonth.equals(month)&&CurrentYear.equals(year)) {
				 break; 
			 }
			 //driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); //next
			 driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //prev
		 }
		//b.slect the date
		 List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td//a"));
		 
		 //repeat until expected date
		 for(WebElement dt:allDates) {
			 if(dt.getText().equals(date)) {
				 dt.click();
				 break;
			 }
		 }	
		 
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get("https://jqueryui.com/datepicker/");
		 driver.manage().window().maximize();
		 
		 //switch to frame
		 driver.switchTo().frame(0);
		 
		 //Method1:using senKeys()
		 //driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("02/25/2025");//   mm/dd/yyyy
		 
		 
		 //Method2:using date picker
		 //expected data
		 String year="2025";  //everything is in string format 
		 String month="April";
		 String date="10";
	
		 driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		 
		 //call user defined methods
		 selectFutureDate(driver,year,month,date);//1
		 //selectPreviousDate(driver,year,month,date);//2
		  
	}
}
