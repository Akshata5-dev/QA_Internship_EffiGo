package week4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RunTestIncognitoMode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ChromeOptions options=new ChromeOptions();
	       options.addArguments("--incognito");
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
