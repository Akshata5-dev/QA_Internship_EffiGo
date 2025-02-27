package week4;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//i.static 
		WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get("https://testautomationpractice.blogspot.com");
		 driver.manage().window().maximize();
		 
		 //1.find total no.of rows in table
		 //approach:1 use when single table
		 int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size(); //7
		 
		//approach:2 (using tagName)-->use when single table
		// int rows=driver.findElements(By.tagName("tr")).size();//19 
		 System.out.println("Number of rows:"+rows); 
		 
		 //2.find total no.of table(total no.of th)
		 int cols=driver.findElements(By.xpath("//table[@name='BookTable']//tr[1]/th")).size();//4
		// int cols=driver.findElements(By.tagName("th")).size();
		 System.out.println("Number of cols:"+cols); 
		 
		 //3.read data from specific row,col(ex:5th row,1col)
		/* String bookName=driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]/td[1]")).getText();//Master In Selenium
		 System.out.println(bookName); */
		 
		/* String Subject=driver.findElement(By.xpath("//table[@name='BookTable']//tr[7]/td[3]")).getText();//Master In Selenium
		 System.out.println(Subject); */
		 
		 //4)read all row and cols(using nested for loop)
		/* System.out.println("BookName"+"\t"+"Author"+"\t"+"Subject"+"\t"+"Price");
		 for(int r=2;r<=rows;r++) {
			 for(int c=1;c<=cols;c++) {
				 String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				 System.out.print(value+"\t");
			     }
			     System.out.println();
		 }   */
		 
		 //5)print bookName whose author is Mukesh
		 //1st print author name(changing tr no.)
		/* for(int r=2;r<=rows;r++) {
			 String authorName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[2]")).getText();
			// System.out.println(authorName);
			 if(authorName.equals("Mukesh")) {
				 String bookName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[1]")).getText();
				 System.out.println(bookName+"\t"+authorName);  */
				 
		  //6) find total price
				 //capture all price and change col no.=4
		         int total=0;
				 for(int r=2;r<=rows;r++) {
					 String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[4]")).getText();
					//covert price to int
					 total=total+Integer.parseInt(price);	 		 
			 }
				 System.out.println("Total Price of books:"+total); //7100
		 }
		 
		 
	}   


