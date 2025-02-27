package week4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		 driver.manage().window().maximize();
		 
		//1.
		  Actions act=new Actions(driver);
		 
		 //i..Min-slider
		 WebElement min_slider=driver.findElement(By.xpath("//div[@class='price-range-block']//span[1]"));
		 System.out.println("Location of the min slider  before movement:"+min_slider.getLocation()); //((59, 250))=(x,y)
		// System.out.println("Location of the min slider :"+min_slider.getLocation().gety()); y-axis getx-->x-axis
		 
		 //a-->inc value of slidr to move
		 act.dragAndDropBy(min_slider,50,0).perform(); //min,x+50,y=0
		 Thread.sleep(2000);
		 System.out.println("Location of the min slider  after movement:"+min_slider.getLocation()); //108, 250
	   
		 
		 //ii.Max-Slider
		 WebElement max_slider=driver.findElement(By.xpath("//span[2]")); 
		 System.out.println("Location of the max slider  before movement:"+max_slider.getLocation()); //(612, 250)=(x,y)
		
		 //a -->dec value of slidr to move backward
		act.dragAndDropBy(max_slider,-50,0).perform(); //max,x-50,y=0 
		Thread.sleep(2000);
		System.out.println("Location of the max slider  after movement:"+max_slider.getLocation()); //(562, 250)
	}

}
