package week2;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver(); 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 driver.manage().window().maximize();
		 
		 driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();//capture the id 's for switching
		 //capture n store in set
		 Set<String> windowIDs=driver.getWindowHandles(); //contains both parent n child id's
		 
		/* //Approch1 :get individual id
		 List<String> windowList=new ArrayList(windowIDs);
		 
		 String parentID=windowList.get(0);
		 String childID=windowList.get(1);
		 
		 System.out.println(driver.getTitle());//driver still focus on parent window(OrangeHRM)
		 
		 //switch to child window
		 driver.switchTo().window(childID);
		 System.out.println(driver.getTitle());//Human Resources Management Software | OrangeHRM
		 
		//again switch to parent window
		 driver.switchTo().window(parentID);
		 System.out.println(driver.getTitle());  */
		 
		 //Approch2:(for multiple browsers)
		 for(String winId:windowIDs)
		 {
			 String title=driver.switchTo().window(winId).getTitle();
			 
			 if(title.equals("OrangeHRM")) { //we can apply actions for particular window by specifying title
				 System.out.println(driver.getCurrentUrl());
			 }		 		 
		 }		 
	}
}
