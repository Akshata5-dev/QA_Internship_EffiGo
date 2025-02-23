package week2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
	    
	    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	    driver.manage().window().maximize();
	    
	    //1.Normal alert with ok button only
	   /*driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
	   Thread.sleep(5000);
	   
	   //capture the alert window & close
	   Alert myalert=driver.switchTo().alert();//store
	   System.out.println(myalert.getText());//to perform operations ex: text validation
	   myalert.accept(); */
	   
	   //2.confirmation alert -ok&cancel btn
	   //a.to close -ok -->accept method
	   //b.to close -cancel btw use dismiss method
	 /*  driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
	   Thread.sleep(5000); 
	   
	   //driver.swithTo().alert().accept(); //close alert using OK button
	   driver.switchTo().alert().dismiss(); //close alert using Cancel
	   */
	   
	   //3.Prompt alert -Input box
	   driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
	   Thread.sleep(5000);
	   
	   Alert myalert=driver.switchTo().alert();
	   myalert.sendKeys("welcome");
	   myalert.accept();
	   
	   
	}

}
