package week4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		 driver.manage().window().maximize();
		 
		 Actions act=new Actions(driver);
		 
		 //1.get source,destination element
		 WebElement rome=driver.findElement(By.xpath("//div[@id='box6']"));
		 WebElement italy=driver.findElement(By.xpath("//div[@id='box106']"));
		 
		 //2drag and drop1
		 act.dragAndDrop(rome,italy).perform(); 
		 
		//1.get source,destination element
		 WebElement Washington=driver.findElement(By.xpath("//div[@id='box3']"));
		 WebElement unitedStates=driver.findElement(By.xpath("//div[@id='box103']"));
		 
		 //2.drag and drop2
		 act.dragAndDrop(Washington,unitedStates).perform(); 
	}

}
