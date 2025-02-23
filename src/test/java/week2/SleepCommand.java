package week2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SleepCommand {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver(); //1
	
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 driver.manage().window().maximize();
 
		 Thread.sleep(3000); //pause execution
		 
		 driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
	}

}
