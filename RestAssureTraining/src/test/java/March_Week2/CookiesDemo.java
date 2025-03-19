package March_Week2;
import static io.restassured.RestAssured.*;
import java.util.Map;
import io.restassured.response.Response;  // Correct import
import org.testng.annotations.Test;

public class CookiesDemo {

    @Test(priority = 1)
    void testCookies() {
        given()
        .when()
            .get("https://www.google.com")
        .then()
            .log().all();
    }

    @Test(priority = 2)
    void getCookiesInfo() {
    	
        Response res = given()
        .when()
            .get("https://www.google.com");  //  Capture response before validation
        
        // single cookie-Retrieve a specific cookie
        String cookieValue = res.getCookie("AEC");
        System.out.println("AEC Cookie Value: " +cookieValue);
        
        //get all cookies
        Map<String,String> cookies_values= res.getCookies();
        
        for(String k:cookies_values.keySet()) {
        	String cookie_value=res.getCookie(k);
        	System.out.println(k+" "+cookie_value);
        }
   
        

    }
}
