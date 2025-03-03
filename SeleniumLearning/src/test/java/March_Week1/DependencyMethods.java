package March_Week1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethods {
   @Test(priority=1)
	void openapp() {
	   Assert.assertTrue(true);
	}
   @Test(priority=2, dependsOnMethods={"openapp"})
	void login() {
		Assert.assertTrue(true);
	}
   @Test(priority=3,dependsOnMethods={"login"}) //it depends on login
	void search() {
	   Assert.assertTrue(false);
	}
   @Test(priority=4,dependsOnMethods={"login","search"}) //depend on two methods
   void advsearch() {
	   Assert.assertTrue(true);
   }
   @Test(priority=5,dependsOnMethods={"login"})
   void logout() {
	   Assert.assertTrue(true);           
   }
   //5, Passes: 0, Failures: 1, Skips: 4
   //5, Passes: 3, Failures: 1, Skips: 1
	
}
