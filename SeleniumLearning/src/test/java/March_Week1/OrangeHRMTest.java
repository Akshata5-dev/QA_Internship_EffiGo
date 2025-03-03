package March_Week1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
/* 1.open app
 * 2.test logo
 * 3.login
 * 4.close
 
 */
public class OrangeHRMTest {
	
WebDriver driver; //make class level variable -->to access in all methods(instance variable)

@Test(priority=1)
void openapp() {
	//driver will access within this method->local
    driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.manage().window().maximize();
}
@Test(priority=2)
void testlogo() throws InterruptedException {
	Thread.sleep(5000);
	boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
	System.out.println("logo displayed..."+status);
}
@Test(priority=3)
void testLogin() {
	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
	driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
}
@Test(priority=4)
void CloseApp() {
	//driver.quit();
}
}
