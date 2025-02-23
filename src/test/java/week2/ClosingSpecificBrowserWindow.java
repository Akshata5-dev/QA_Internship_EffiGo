package week2;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClosingSpecificBrowserWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver(); 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 driver.manage().window().maximize();
		 
		 driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();//capture the id 's for switching
		 //capture n store in set
		 Set<String> windowIDs=driver.getWindowHandles(); //contains both parent n child id's
		 
		 for(String winid:windowIDs) { //switch particular
			 //captures all windows title
			 String title=driver.switchTo().window(winid).getTitle();
			 System.out.println(title);
			 
			 //1.Close condition for specific browser
			 if(title.equals("Human Resources Management Software | OrangeHRM") || title.equals("some other title" )) {
				 driver.close(); //close parent bt child still opened
				 //break; //don't put if using multiple windows
			 }
			 
			 
		 }
		
		
		
	}

}
