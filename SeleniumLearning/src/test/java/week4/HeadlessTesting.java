package week4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTesting {

	//everything happens in back-end side
	public static void main(String[] args) {
		    // ChromeDriver driver=new ChromeDriver();
		       ChromeOptions options=new ChromeOptions();
		       options.addArguments("--headless=new");//setting for headless mode of execution
				//before driver 
		       
				WebDriver driver=new ChromeDriver(options); 
				
				driver.get("https://demo.opencart.com/");
				
				String act_title=driver.getTitle(); 
				
				if(act_title.equals("Your Store"))
				{
					System.out.println("Test Passed");
					
				}
				else {
					System.out.println("Test Failed");
				}
	}
	}

