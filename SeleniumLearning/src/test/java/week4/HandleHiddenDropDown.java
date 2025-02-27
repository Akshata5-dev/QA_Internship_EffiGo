package week4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleHiddenDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//iii.hidden drop down -->turn on debbuger option to capture xpath
		 WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
		 driver.manage().window().maximize();
		 
		 //1.Login steps to PIM in orangeHrm
		 driver.findElement(By.name("username")).sendKeys("Admin");
		 driver.findElement(By.name("password")).sendKeys("admin123");
		 driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		 
		 //2.clicking on PIM
		 driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click(); //PIM
		 
		 //3.clicked on dropdown
		 driver.findElement(By.xpath("//div[6]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]")).click();
		 Thread.sleep(5000);
		 
		 //3a.select single option
		// driver.findElement(By.xpath("//span[normalize-space()='Financial Analyst']")).click();
		 
		 //count no.of options--write common xpath
		 List<WebElement> options=driver.findElements(By.xpath("//div[@role='listbox']//span"));
		 System.out.println("Number of options:"+options.size());
		 
		 //printing options
		 for(WebElement op:options) {
			 System.out.println(op.getText());
		 }
	}

}
