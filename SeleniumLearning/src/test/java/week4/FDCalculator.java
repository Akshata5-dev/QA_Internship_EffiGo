package week4;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		 driver.manage().window().maximize();
		 
		 //paas file path
		 String filePath=System.getProperty("user.dir")+"\\TestData\\caldata.xlsx";
		 
		 int rows=ExcelUtils.getRowCount(filePath,"Sheet1");
		 
		 for(int i=1;i<=rows;i++) {
			 //1.read data from excel
			 
			String pric= ExcelUtils.getCellData(filePath, "Sheet1", i,0);//i=rowno
			String rateofInterest= ExcelUtils.getCellData(filePath, "Sheet1", i,1);//i=rowno
			String per1= ExcelUtils.getCellData(filePath, "Sheet1", i,2);//i=rowno
			String per2= ExcelUtils.getCellData(filePath, "Sheet1", i,3);//i=rowno
			String fre= ExcelUtils.getCellData(filePath, "Sheet1", i,4);//i=rowno
			String exp_mvalue=ExcelUtils.getCellData(filePath, "Sheet1",i,5);
			
			 //2.pass above data into application
			 driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(pric);
			 driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateofInterest);
			 driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);
			 
			 
			Select perdrp= new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			// Print available options
			for (WebElement option : perdrp.getOptions()) {
			    System.out.println(option.getText());
			}
			
			if (per2.equalsIgnoreCase("days(s)")) {
			    per2 = "day(s)";
			} else if (per2.equalsIgnoreCase("months(s)")) {
			    per2 = "month(s)";
			} else if (per2.equalsIgnoreCase("years(s)")) {
			    per2 = "year(s)";
			}
			for (WebElement option : perdrp.getOptions()) {
			    System.out.println("Dropdown Option: " + option.getText());
			}

			perdrp.selectByVisibleText(per2.trim());

			
			Select fredrp=new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			fredrp.selectByVisibleText(fre);
			
			// Remove overlay using JavaScript to prevent blockage
			try {
			    JavascriptExecutor js = (JavascriptExecutor) driver;
			    js.executeScript("document.querySelector('.wzrk-overlay').remove();");
			    Thread.sleep(2000); // Allow time for the change to take effect
			    System.out.println("Overlay removed using JavaScript.");
			} catch (Exception e) {
			    System.out.println("No overlay found or already removed.");
			}

			// Click the calculate button using JavaScript to avoid interception
			WebElement calculateButton = driver.findElement(By.xpath("//div[@class='cal_div']//a[1]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(calculateButton).click().build().perform();


			 //validation
			 String act_mvalue=driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			 
			 //all are in string format convert to double  & compare
			 if(Double.parseDouble(exp_mvalue)==Double.parseDouble(act_mvalue)) {
				 System.out.println("Test passed");
				 ExcelUtils.setCellData(filePath,"Sheet1",i,7,"Passed");
				 ExcelUtils.fillGreenColor(filePath,"Sheet1",i,7);
				}
			 else {
				 System.out.println("Test Failed");
				 ExcelUtils.setCellData(filePath,"Sheet1",i,7,"Failed");
				 ExcelUtils.fillRedColor(filePath,"Sheet1",i,7);
			 }
			
			 Thread.sleep(3000);
			 //Clear existing data
			 driver.findElement(By.xpath("//div[@class='cal_div']//a[2]")).click();	 
		 }
		 //ending of for loop
		// driver.quit();
		 }

}
