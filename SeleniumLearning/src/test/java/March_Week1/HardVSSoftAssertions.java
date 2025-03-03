package March_Week1;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVSSoftAssertions {
	//SoftAssert sa;-->cls variable
	
  /*  @Test
	void test_hardassertions() {
		System.out.println("testingn...");
		System.out.println("testingn...");
		
		Assert.assertEquals(1,2);
		
		System.out.println("testingn...");
		System.out.println("testingn...");
	} */
    
    @Test
	void test_softassertions() {
    	
		System.out.println("testingn...");
		System.out.println("testingn...");
		
		SoftAssert sa=new SoftAssert(); //object creation bcz contains non-staticmethod
		sa.assertEquals(1,2);
		
		System.out.println("testingn...");
		System.out.println("testingn...");
		
		sa.assertAll(); //mandatory Method
	}
    

}
