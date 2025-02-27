package week4;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("http://www.deadlinkcity.com/");
		 driver.manage().window().maximize();
		 
		 //capture all links
		 List<WebElement> links=driver.findElements(By.tagName("a"));
		 System.out.println("Total number of links:"+links.size());
		 
		 int noOfBrokenLinks=0;
		 
		 //1.Link shuld hv href along with value
		 for(WebElement linkElement:links) {
			 String hrefattValue=linkElement.getAttribute("href");
			 if(hrefattValue==null || hrefattValue.isEmpty())
			 {
				 System.out.println("href attribute value is null or empty.So not possibl to check");
				 continue;//skip current value bcz to check further links
			 }
		   //2.hit URL to server
			 try {
			 URL linkURL=new URL(hrefattValue); //convert href string to url
			 HttpURLConnection conn=(HttpURLConnection) linkURL.openConnection();//establish conn
			 conn.connect();//conn to server and sent req to server
			 
			 //3.status code comparison
			 if(conn.getResponseCode()>=400)
			 {
				 System.out.println(hrefattValue+" ====> Broken link");
				 noOfBrokenLinks++;
			 }
			 else {
				 System.out.println(hrefattValue+" ====> Not a broken link");
			 }
		     }
			 catch(Exception e) {
				 
			 }
	}
		System.out.println("Number of broken links:"+ noOfBrokenLinks); 
	}
}
