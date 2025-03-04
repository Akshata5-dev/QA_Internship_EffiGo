package ListenersDemo;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(ListenersDemo.MyListener.class)
public class OrangeHRM {

    WebDriver driver;
	@BeforeClass
	void setup() throws InterruptedException { 
		
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); 
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	@Test(priority=1)
	void testlogo() throws InterruptedException {
		Thread.sleep(3000);
		boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		//boolean value
		Assert.assertEquals(status, true);
	}
	@Test(priority=2)
	void testAppurl() {
		Assert.assertEquals(driver.getCurrentUrl(),"https://google.com");
	}
	@Test(priority=3 ,dependsOnMethods= {"testAppurl"})
	void testHomePageTitle() {
		//comparing 2 string values
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");
	}
	@AfterClass
	void tearDown() {
		//driver.quit();
	}
}

