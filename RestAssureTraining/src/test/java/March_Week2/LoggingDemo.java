package March_Week2;
import static io.restassured.RestAssured.*;
import java.util.Map;
import io.restassured.response.Response;  // Correct import
import org.testng.annotations.Test;
public class LoggingDemo {
@Test(priority=1)
	void testlogs() {
		given()
		
		.when()
		      .get("https://reqres.in/api/users?page=2")
		.then()
		     // .log().all(); //it prints all
		        .log().body(); //only body
		     //  .log().headers(); //only headers
	}
}
