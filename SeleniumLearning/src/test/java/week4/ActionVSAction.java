package week4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionVSAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		 driver.manage().window().maximize();
		 
		 //a.
		 WebElement button=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		 //click action is not work here bcz if we right click we can't get inspect in context-click we need to perform below action
		 
		 Actions act=new Actions(driver);
		 
		 //a.building or creating action & storing into a variable
         Action myaction=act.contextClick(button).build();
         
         //b.performing/cmplting  action
         myaction.perform();
         
         
	}

}
