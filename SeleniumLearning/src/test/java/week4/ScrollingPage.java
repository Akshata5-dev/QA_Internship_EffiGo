package week4;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {
 //Vertical scroll bar
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
	     driver.get("https://demo.nopcommerce.com/");
	     driver.manage().window().maximize();
	
	     JavascriptExecutor js=(JavascriptExecutor)driver;
	     
       //1)scroll down page by pixel  number
	    /* js.executeScript("window.scrollBy(0,1500)",""); 
	     System.out.println(js.executeScript("return window.pageYOffset;")); //y-axis-->return where bar stop
	     */
	     
	 /*  //2)scroll down page till element is visible
	     WebElement ele=driver.findElement(By.xpath("//strong[normalize-space()='News']"));
	     js.executeScript("arguments[0].scrollIntoView()",ele); 
	     System.out.println(js.executeScript("return window.pageYOffset;")); //1911.199951171875 -->scroll the page till element appears useful
	     */
	     
	     //3)scroll down till end of page
		     js.executeScript("window.scrollBy(0,document.body.scrollHeight)"); 
		     System.out.println(js.executeScript("return window.pageYOffset;")); //2451.199951171875
		     
		     
		     Thread.sleep(5000);
		//4)scrolling up to initial position
		     js.executeScript("window.scrollBy(0,-document.body.scrollHeight)"); // '-' to cm back initial point
	     //1968.800048828125
	     
	}

}
