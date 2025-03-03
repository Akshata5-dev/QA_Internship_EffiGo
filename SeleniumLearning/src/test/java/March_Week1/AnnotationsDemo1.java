package March_Week1;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*1.Login -- @BeforeMethod -- only once creation
 *2.search -- @Test
 *3.Logout --@AfterMethod
 *4.Login
 *5.Advance Search --@Test
 *6.Logout                 -- only once creation
 */
public class AnnotationsDemo1 {
//not consider as actual testcase --not participate in Results,only in execution
@BeforeMethod
void login() {
	System.out.println("This is login..");
}
//actual testcase -bcz comtains @test
@Test(priority=1)
void search() {
	System.out.println("This is search..");
}
//actual testcase -bcz comtains @test
@Test
void advancedsearch() {
	System.out.println("This is advance search..");
}
//not consider as actual testcase
@AfterMethod
void logout() {
	System.out.println("This is logout..");
}
}
