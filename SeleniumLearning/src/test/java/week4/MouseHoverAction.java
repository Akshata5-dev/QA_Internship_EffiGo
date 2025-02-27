package week4;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get("https://demo.opencart.com/");
		 driver.manage().window().maximize();
		 
		 WebElement desktops=driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		 WebElement mac=driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		 
		 //mouse related actions done by Action class
		 
	      Actions act=new Actions(driver);
	      
	      //a.mouse hover two elements desktop,mac
	      
	      //act.moveToElement(desktops).moveToElement(mac).click().build().perform();
	       act.moveToElement(desktops).moveToElement(mac).perform();
	      
            //build-->create action,perform-->perform action immediately 
		 
	}

}
