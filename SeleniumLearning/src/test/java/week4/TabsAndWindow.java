package week4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabsAndWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		//Selenium.x
		//1.two links opens in diff tabs
		//driver.switchTo().newWindow(WindowType.TAB);//opens new tab
		
		//2.two links opens in diff window
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.get("https://orangehrm.com/");
		
	}

}
