package March_Week1;
import org.testng.annotations.Test;

/*
 1.open app
 2.Login
 3.Logout
 */
public class FirstTestCase {
  @Test(priority=1)
	  void logout() {
		  System.out.println("Logout from application..");
	  }
  @Test(priority=-1)
  void openapp() {
	  System.out.println("opening application..");
  }
  @Test(priority=0)
  void login() {
	  System.out.println("Login to application..");
  }
  
}
