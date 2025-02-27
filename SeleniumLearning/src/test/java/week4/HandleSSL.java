package week4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleSSL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options=new ChromeOptions();
		//1.to make error-less:accept SSL certificates
		options.setAcceptInsecureCerts(true); //by default it is false we hv change to true
	     //we will get actual title :expired.badssl.com
		
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		
		System.out.println("title of the page:"+driver.getTitle());//Privacy error
		
	}

}
