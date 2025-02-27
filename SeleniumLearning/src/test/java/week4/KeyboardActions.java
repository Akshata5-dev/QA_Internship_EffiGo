package week4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get("https://text-compare.com/");
		 driver.manage().window().maximize();
		 
		 //1.locate only 1box 
		 driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("Welcome");
		 
		 Actions act=new Actions(driver);
		 //a.Ctrl+A 
		  act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		 
		 //b.Ctrl+C
		  act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		  
		 //c.TAB -shift to 2nd Box
		  act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		 
		 //d.Ctrl+V
		  act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
	}

}
