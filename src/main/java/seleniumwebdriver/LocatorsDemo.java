package seleniumwebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     WebDriver driver=new ChromeDriver(); //1
		
	 driver.get("https://demo.opencart.com/");//2
	 driver.manage().window().maximize();
	 
	 //name
	 driver.findElement(By.name("search")).sendKeys("Mac");
	 //Logo
	 boolean logoDisplaysstatus=driver.findElement(By.id("logo")).isDisplayed();
     System.out.println(logoDisplaysstatus); 
	 
     //link text & partialLinktext
     //driver.findElement(By.linkText("Tablets")).click();
     driver.findElement(By.partialLinkText("Table")).click();  //
     
	 }

}
