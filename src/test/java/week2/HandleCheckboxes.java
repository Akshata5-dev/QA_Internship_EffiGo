package week2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckboxes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
    WebDriver driver=new ChromeDriver();
    
    driver.get("https://testautomationpractice.blogspot.com/");
    driver.manage().window().maximize();
    
    //1.select specific checkbox
   // driver.findElement(By.xpath("//input[@id='sunday']")).click();
    
    //2.select all check boxes through loop
    //capture webelements(checkboxes) write own locator(xpath) we hv to check common attribute among 7
    List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@class=\"form-check-input\" and @type=\"checkbox\"]"));
    
    //normal for loop
    /*for(int i=0;i<checkboxes.size();i++) {
    	checkboxes.get(i).click();
    }*/
    
    
   /* //enhanced for-loop(use this only)
    for(WebElement checkbox:checkboxes) {
    	checkbox.click();
    }*/
    
 /*   //3.select last 3 checkboxes(use normal for-loop bcz dealing with index
    for(int i=4;i<checkboxes.size();i++) {
    	checkboxes.get(i).click();
    }  */
   //4.select first 3 checkbox
   /* for(int i=0;i<3;i++) {
    	checkboxes.get(i).click();
    }
    */
    //5.unselect the if selected check box
    for(int i=0;i<3;i++) { //select 3 checkboxes
    	checkboxes.get(i).click();
    }
    
    Thread.sleep(5000);
    
    for(int i=0;i<checkboxes.size();i++)
    { 
    	if(checkboxes.get(i).isSelected()) {
    	//unselect above 3selected checkboxes
     	checkboxes.get(i).click();
    }
    }  
	}
}
