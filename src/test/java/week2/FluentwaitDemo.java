package week2;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentwaitDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver(); //1
		
		 //declaration of Fluent wait
		 Wait<WebDriver> mywait=new FluentWait<WebDriver>(driver)
		      .withTimeout(Duration.ofSeconds(30))//max time out 
		      .pollingEvery(Duration.ofSeconds(5))//differentiate from explicit to fluent wait
		      .ignoring(NoSuchElementException.class);
		 
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 driver.manage().window().maximize();
		 
		 //no need to write this-->(driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");)
		 
		 WebElement txtUsername = mywait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.xpath("//input[@placeholder='Username']"));
		     }
		   });
		 
		 txtUsername.sendKeys("Admin");
		 //driver.close();
	}

}
