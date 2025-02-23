package week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver(); //1
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 Thread.sleep(5000);
		 driver.manage().window().maximize();
		 
		 driver.findElement(By.linkText("OrangeHRM, Inc")).click();//opens in new window
		 
		 Thread.sleep(5000);
		 //driver.close();
		 driver.quit();
		 
	}

}
