package March_Week2;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import java.util.Map;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;  // Correct import
import org.testng.annotations.Test;

public class HeadersDemo {
    //@Test(priority=1)
	//a.verifying inf like content type etc
	void testHeaders() {
		given()
		.when()
		      .get("https://www.google.com")
		 .then()
		       .header("Content-Type","text/html; charset=ISO-8859-1")
		       .and()
		       .header("Content-Encoding","gzip")
		       .and()
		       .header("Server","gws");
		      // .log().headers();//print only headers
	}
    
    //2.Capture inf from headers
    @Test(priority=2)
   	void getHeaders() {
   		Response res =given()
   		.when()
   		      .get("https://www.google.com");
   		      
   		//a.get single header inf
   		String headervalue=res.getHeader("Content-Type");
   		System.out.println("The value of content: "+headervalue);
   		   
   		//b.get all headers inf
   		Headers myheaders=res.getHeaders();
   		
   		for(Header hd:myheaders) {
   			System.out.println(hd.getName()+" "+hd.getValue());
   		}
   	}
    
    
}
