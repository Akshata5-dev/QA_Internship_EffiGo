package March_Week1;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {
@Test
	void testTitle() {
		String exp_title="Opencart";
		String act_title="Openshop";
		//1.without assertion
		/*if(exp_title.equals(act_title)) {
			 System.out.println("test passed");
			
		}
		 else {
			 System.out.println("test failed");
		 }*/
		
		//1.Assertion with single statement
		//Assert.assertEquals(exp_title, act_title);
		
		//2.Assertion with Conditional statement
		 if(exp_title.equals(act_title)) {
		 System.out.println("test passed");
		 Assert.assertTrue(true);
	     }
	     else {
		 System.out.println("test failed");
		 Assert.assertTrue(false);
	 }
	}
}
