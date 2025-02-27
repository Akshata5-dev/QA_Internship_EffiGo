package week4;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
     WebDriver driver=new ChromeDriver();
	 //ChromeDriver driver=new ChromeDriver();
     driver.get("https://testautomationpractice.blogspot.com/");
     driver.manage().window().maximize();
     
     WebElement inputbox=driver.findElement(By.xpath("//input[@id='name']"));
     
     //assign webdriver variable to jse -->need casting 
     //obj of child cls store into parent cls variable-->upcasting
     
     //1 assign driver 
     JavascriptExecutor js=(JavascriptExecutor)driver;
     // JavascriptExecutor js=driver;
     //2 passing text into inputbox -alternate of sendKeys() if get exception then only we use
     js.executeScript("arguments[0].setAttribute('value','John')", inputbox);
     
     //clicking on element -alternate of click()
     WebElement radiobtn=driver.findElement(By.xpath("//input[@id='male']"));
     js.executeScript("arguments[0].click()", radiobtn);
      
	}

}
