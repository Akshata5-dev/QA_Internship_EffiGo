package week4;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class OpenLinkInNewTab {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 
		 driver.get("https://demo.nopcommerce.com/");
		 driver.manage().window().maximize();
		 
		 
		 WebElement regLink= driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		 
		 Actions act=new Actions(driver);
		 
		 //1.Control+RegLink -->switch register window with keyboard
		 act.keyDown(Keys.CONTROL).click(regLink).keyUp(Keys.CONTROL).perform();
		 Thread.sleep(2000); 
		 
		 //2.switching to register page to perform action on 2nd(child)window
		 //getchild id convert set to list for(index)
		 List<String> ids=new ArrayList<>(driver.getWindowHandles());
		 
		 //Registration
		 driver.switchTo().window(ids.get(1));//id=1 -->id of 2nd window
		 
		// Wait until the FirstName field is visible
         //Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='FirstName']")));
		 driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("John");
		 
		 //2.Home page-switch back to home page
		 driver.switchTo().window(ids.get(0));
		 
		 driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("TShirts");
		 
	}

}
