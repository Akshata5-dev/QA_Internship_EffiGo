package week2;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class FirstTestCase {

/*
 * Test case
 1.launch browser
 2.open URL:
 3.validate title should be "Your Store"
 4.close browser
  */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    // ChromeDriver driver=new ChromeDriver();
		
		WebDriver driver=new ChromeDriver(); //1
		
		driver.get("https://demo.opencart.com/");//2
		
		String act_title=driver.getTitle(); //3
		
		if(act_title.equals("Your Store"))
		{
			System.out.println("Test Passed");
			
		}
		else {
			System.out.println("Test Failed");
		}
		
		driver.close(); //4
		//driver.quit();
		}

}
