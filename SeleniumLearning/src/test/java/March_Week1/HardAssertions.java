package March_Week1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {
@Test
void test() {
	//Assert.assertEquals("xyz", "xyz");
	//Assert.assertEquals(123, 146);
	//Assert.assertEquals("xyz", 123);
	//Assert.assertEquals(123, "123");
	
	//Assert.assertNotEquals(123, 133);
	
	//Assert.assertTrue(true); //pass
	//Assert.assertTrue(false); //fail
	
	//Assert.assertTrue(1==2); //fail
	//Assert.assertTrue(2==2);
	
	Assert.assertFalse(1==2);
	
	Assert.fail();  //without make fail without any
	
	
}
}
