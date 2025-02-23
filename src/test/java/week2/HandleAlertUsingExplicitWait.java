package week2;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlertUsingExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
       //handle alert without using switch 
       WebDriver driver=new ChromeDriver();
	    //1.declaration of explicit wait
        WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
        
        
	    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	    driver.manage().window().maximize();
	    
	   driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
	   Thread.sleep(5000);
	   
	   //2.when alert is open this condn is true
	    Alert myalert=mywait.until(ExpectedConditions.alertIsPresent());//another way to capture alert
	   
	   System.out.println(myalert.getText());
	   myalert.accept(); 
	}

}
