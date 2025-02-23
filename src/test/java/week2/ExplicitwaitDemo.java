package week2;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitwaitDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver(); //1
		
		 //declaration of explicit
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));//
		
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 driver.manage().window().maximize();
		 
       //2.apply cond: use until method(element should visible on webpage) execute the stat when true store value in variable
		 //a.for username
		 WebElement txtusername=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		 txtusername.sendKeys("Admin"); //perform visibility action
		 
		 //b.for password
		 WebElement txtpassword=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		 txtpassword.sendKeys("admin123");
		 
		 //c.login button
		 WebElement loginbtn=mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']")));
		 loginbtn.click();
		 
		 //1.identify element cause  exception
		 //(no need to write this method)driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		 //driver.close();
	}

}
