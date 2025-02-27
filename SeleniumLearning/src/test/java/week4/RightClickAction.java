package week4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		 driver.manage().window().maximize();
		 
		 //a.
		 WebElement button=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		 //click action is not work here bcz if we right click we can't get inspect in context-click we need to perform below action
		 
		 
		 Actions act=new Actions(driver);
		 //Right click action
		 act.contextClick(button).perform();
		 
		 //b.click on copy
		 driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();
		 Thread.sleep(5000);
		 
		 //close alert box
		 driver.switchTo().alert().accept();
		 
		 
	}

}
