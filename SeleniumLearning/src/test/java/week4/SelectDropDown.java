package week4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get("https://testautomationpractice.blogspot.com/");
		 driver.manage().window().maximize();
		 
		 WebElement drpCountryEle=driver.findElement(By.xpath("//select[@id='country']"));//capture dropdown Element
		 Select drpCountry=new Select(drpCountryEle);
		 
		 //1.select option from the drop down
		 /*  drpCountry.selectByContainsVisibleText("Australia");//visible text started from upper case(innerText)
		 drpCountry.selectByValue("japan");//value is attribute of element(if available use)
		 drpCountry.selectByIndex(2);//count manually index from 0  */
		 
		 //find total no.of drop-downs
		 //1.capture all drop-down options
		 List<WebElement>options=drpCountry.getOptions();
		 System.out.println("Number of options in a drop down:"+options.size());//Number of options in a drop down:10
		 
		 //2.printing captured options
         /* for(int i=0;i<options.size();i++) {
			 System.out.println(options.get(i).getText()); //get retrieve the element getText-->retrieveThe Text of element
		 }  */ 
		 
		 //Using enhance for-loop
		 for(WebElement op:options) {
			 System.out.println(op.getText());
		 } 
		 
	}

}
