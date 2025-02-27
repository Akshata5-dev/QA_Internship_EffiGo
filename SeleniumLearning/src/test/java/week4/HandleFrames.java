package week4;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get("https://ui.vision/demo/webtest/frames/");
		 driver.manage().window().maximize();
		 
		 //get frame as webElement first bcz id is not available
		 //frame1
		 WebElement frame1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		 driver.switchTo().frame(frame1);//switch to frame 1
		 driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("welcome");//perform action
		 driver.switchTo().defaultContent(); //switch back to main page
		 
		//frame2
		 WebElement frame2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		 driver.switchTo().frame(frame2); //switch to frame 2
		 driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("welcome");
		 driver.switchTo().defaultContent(); //switch back to main page
		 
		 //frame3
		 WebElement frame3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		 driver.switchTo().frame(frame3);//switch to frame 3
		 driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("welcome");
		 
		 //in frame3 inter-acting with iframe
		// use index bcz only 1iframe frame -3 had
		 driver.switchTo().frame(0);//switching to frame using index
		 //driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']")).click();
		 
		// driver.switchTo().defaultContent();
		 
		 //if something is not working or element exception use --->java-script alternate way
		 WebElement rdbutton=driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']"));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();", rdbutton);
		 driver.switchTo().defaultContent();
		 
		 
	}

}
