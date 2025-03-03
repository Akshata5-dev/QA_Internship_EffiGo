package March_Week1;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*1.Login -- @BeforeClass-- only once creation
 *2.search -- @Test
 *3.Advance Search --@Test
 *4.Logout  --@AfterClass -- only once creation
 */

public class AnnotationsDemo2 {	
	@BeforeClass
	void login() {
		System.out.println("This is login..");
	}
	@Test(priority=1)
	void search() {
		System.out.println("This is search..");
	}
	
	@Test(priority=2)
	void advancedsearch() {
		System.out.println("This is advance search..");
	}
	
	@AfterClass
	void logout() {
		System.out.println("This is logout..");
	}
	}


