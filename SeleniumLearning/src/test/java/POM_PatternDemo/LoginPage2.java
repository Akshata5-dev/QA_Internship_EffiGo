package POM_PatternDemo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//approach2:with Page Factory -more flexible

public class LoginPage2 {
	WebDriver driver;
//1.constructor -to initiate driver
	LoginPage2(WebDriver driver){
			this.driver=driver;
			PageFactory.initElements(driver, this);//mandatory--assign driver for all
	}
		
	   //2.locators + xpath
	/*
		By txt_username_loc=By.xpath("//input[@placeholder='Username']");
		By txt_password_loc=By.xpath("//input[@placeholder='Password']");
		By txt_login_loc=By.xpath("//button[normalize-space()='Login']");
	
		*/
	
	
	//directly specify locator it finds the element  and  stored  in variable
	/*
	@FindBy(xpath="//input[@placeholder='Username']") */
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Username']")
	WebElement txt_username;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement txt_password;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement btn_Login;
	
	//loacate grp of elements
	@FindBy(tagName="a")
	List<WebElement> links;
	
	//3.Action Methods
	public void setUserName(String user) {
		txt_username.sendKeys(user);
	}
	public void setPassword(String pwd) {
		txt_password.sendKeys(pwd);
	}
	public void clickLogin() {
		btn_Login.click();
	}

	
}
