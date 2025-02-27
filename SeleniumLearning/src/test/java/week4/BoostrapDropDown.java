package week4;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BoostrapDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ii.Bootstrap drop-down-->xpath play imp role ,it don't contain select object 
		WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		 driver.manage().window().maximize();
		 
		 //1.Select single option
		 //a.create own x-path bcz elements keep change
		 driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();//open drop-down options
		 
		 //b.select single option-(get xpath of that option)
		//driver.findElement(By.xpath("//input[@value='Java']")).click();
		
		//2)Capture all options and find out size
		//a.need to write common xpath for all(here we used relative xpath)
		List<WebElement> options=driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
		 System.out.println("Number of Options:"+options.size());//14 total
		 
		 //b.printing all options from dropdown
		/* for(WebElement op:options) {
			 System.out.println(op.getText());
		 } */
		 
		 //c.select multiple options -go with looping 
		 for(WebElement op:options) {
			 String option=op.getText();
			 
			 if(option.equals("Java") || option.equals("Python") || option.equals("MySQL")) {
				 op.click();
			 }
		 }		 
	}

}
