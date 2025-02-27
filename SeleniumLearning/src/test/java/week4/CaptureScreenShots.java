package week4;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenShots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	     driver.get("https://demo.nopcommerce.com/");
	     driver.manage().window().maximize();//max before capturing
	     
	 /*    //1.full page screenshot
	     TakesScreenshot ts=(TakesScreenshot)driver; //typecasting requires 
	     //Captured the ss-saved some-where in memory (don't kn location)
	     File sourcefile=ts.getScreenshotAs(OutputType.FILE);
	     //capture particular location-own path
	     File targetfile=new File(System.getProperty("user.dir")+"\\ScreenShotFolder\\fullpage.png"); 
	     //copy source-file to target file
	     sourcefile.renameTo(targetfile);
	     */
	     
	     //2.Capture ss of specific area/section-->ss from webElement
	  /*   WebElement featuredProducts=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
	     File sourcefile=featuredProducts.getScreenshotAs(OutputType.FILE);
	     File targetfile=new File(System.getProperty("user.dir")+"\\ScreenShotFolder\\featuredproducts.png");    
	     sourcefile.renameTo(targetfile);
	     driver.quit();
	     */
	     
	     
	     //3.Capture ss of webElemet
	     WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
	     File sourcefile=logo.getScreenshotAs(OutputType.FILE);
	     File targetfile=new File(System.getProperty("user.dir")+"\\ScreenShotFolder\\logo.png");    
	     sourcefile.renameTo(targetfile);
	     driver.quit();
	     
	}

}
