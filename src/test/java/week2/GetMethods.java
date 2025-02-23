package week2;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver(); //1
		
		//1.get() method-opens url on browser
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");//2
		 Thread.sleep(5000);
		 //2.getTitle()
	     //System.out.println(driver.getTitle());
	     //3.getCurrentUrl()
	     //System.out.println(driver.getCurrentUrl());
	     //4.getpagesource()
	    // System.out.println(driver.getPageSource());
	     
	     //5.getWindow handle()-return ID
	     //String windowid=driver.getWindowHandle();
	     
	    // System.out.println("window ID:"+windowid); //ID:F421B29553546FCAEACD0F24208B4DEB
	     //6.getwindow handles() -multi ID's
		 driver.findElement(By.linkText("OrangeHRM, Inc")).click();//opens new window
		 Set<String> windowids=driver.getWindowHandles(); //id's are unique and strings
		 System.out.println(windowids);
	     
	     
	     
	}

}
