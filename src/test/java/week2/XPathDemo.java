package week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver(); //1
		
		 driver.get("https://demo.opencart.com/");//2
		 driver.manage().window().maximize();
		 
		 //1.XPath with single attribute
		 //driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("TShirts");
		 
		 //2.XPath with multiple attributes
		 
		//driver.findElement(By.xpath("//input[@name='search'][@placeholder='Search']")).sendKeys("TShirts");
		 
	    //3.Xpath with 'and'  'or' operators
		 
		//driver.findElement(By.xpath("//input[@name='search' and @placeholder='Search']")).sendKeys("Tshirts");
		
		// driver.findElement(By.xpath("//input[@name='search' or @placeholder='abc']")).sendKeys("Tshirts");
		 
		 //4.with text()-inner text
		 //driver.findElement(By.xpath("//*[text()='MacBook']")).click();
		
		 boolean displaystatus=driver.findElement(By.xpath("//h3[text()='Featured']")).isDisplayed();
		 System.out.println(displaystatus);
		 
		 String value=driver.findElement(By.xpath("//h3[text()='Featured']")).getText();
		 System.out.println(value);
		 
		 //5.xpath with contains()
		 //driver.findElement(By.xpath("//input[contains(@placeholder,'Sea')]")).sendKeys("Tshirts");
		 
		 //6.xpath with start-with
		 driver.findElement(By.xpath("//input[starts-with(@placeholder,'Sea')]")).sendKeys("Tshirts");
		 
		 //7.chained xpath
		 boolean status=driver.findElement(By.xpath("//div[@id='logo']/a/img")).isDisplayed();
		 System.out.println(status);
		 
	}

}
