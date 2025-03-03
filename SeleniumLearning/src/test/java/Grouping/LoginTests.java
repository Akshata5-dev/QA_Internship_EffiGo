package Grouping;
import org.testng.annotations.Test;

public class LoginTests {
    @Test(priority=1,groups= {"sanity"})
	void loginByEmail() {
		System.out.println("This is by Email..");
	}
    @Test(priority=2,groups= {"sanity"})
	void loginByFacebook() {
    	System.out.println("This is by Facebook..");
	}
    @Test(priority=3,groups= {"sanity"})
	void loginBytwitter() {
    	System.out.println("This is by Twitter..");
	}
}
