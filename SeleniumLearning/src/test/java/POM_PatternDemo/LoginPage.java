package POM_PatternDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//approach1:without PageFactory
public class LoginPage {
   WebDriver driver;
	//1.constructor -to initiate driver
	LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	//2.locators - xpath
	By txt_username_loc=By.xpath("//input[@placeholder='Username']");
	By txt_password_loc=By.xpath("//input[@placeholder='Password']");
	By txt_login_loc=By.xpath("//button[normalize-space()='Login']");
	
	//3.Action methods-
	public void setUserName(String user) {
		driver.findElement(txt_username_loc).sendKeys(user);
	}
	public void setPassword(String pwd) {
		driver.findElement(txt_password_loc).sendKeys(pwd);
	}
	public void clickLogin() {
		driver.findElement(txt_login_loc).click();
	}
}
