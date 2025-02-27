package week4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		 driver.manage().window().maximize();
		 
		 //first switch to frame bcz fields are inside in frame
		 driver.switchTo().frame("iframeResult");
		 
		 //3.
		 WebElement box1=driver.findElement(By.xpath("//input[@id='field1']"));
		 WebElement box2=driver.findElement(By.xpath("//input[@id='field2']"));
		 WebElement button=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		 
		 //a.clear field-1 before passing text
		 box1.clear();
		 box1.sendKeys("Welcome");//b.pass value
		 
		 //c.double click action on button
		 Actions act=new Actions(driver);
		 
		 act.doubleClick(button).perform();
		 
		 //d.validation:box2 should contains 
		 String text=box2.getAttribute("value");
		 System.out.println("Captured value is:"+text);
		 
		 if(text.equals("Welcome")) {
			 System.out.println("Text copied");
		 }
		 else {
			 System.out.println("Text not copied");
		 }	 
	}

}
