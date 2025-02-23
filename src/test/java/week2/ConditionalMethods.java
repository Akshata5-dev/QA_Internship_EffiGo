package week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     WebDriver driver=new ChromeDriver(); //1
		
	 driver.get("https://demo.nopcommerce.com/register");
	 driver.manage().window().maximize();
	 
	 //a.isDisplayed
	WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));//capture element
	System.out.println("Display status of logo:"+logo.isDisplayed());//print element
	
	//boolean with isDiplayed --correct
	
	//b.isEnabled--input,checkbox,buttons
	boolean status=driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled();
	System.out.println("Enable status:"+status);
	
	//c.isSelected for radio button
	WebElement male_rd=driver.findElement(By.xpath("//input[@id='gender-male']"));
	WebElement female_rd=driver.findElement(By.xpath("//input[@id='gender-female']"));
	
	System.out.println("Before selection.......");
	System.out.println(male_rd.isSelected());//false
	System.out.println(female_rd.isSelected());//false
	
	//after selecting
	System.out.println("after selection.......");
	male_rd.click();//select male radio
	System.out.println(male_rd.isSelected());//true
	System.out.println(female_rd.isSelected());//false
	
	//For check box
	boolean newsletterstatus=driver.findElement(By.xpath("//input[@id='Newsletter']")).isSelected(); //true
	System.out.println("News letter checkbox status:"+newsletterstatus);
	}

}
