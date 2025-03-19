package March_Week2;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

/*given()  --keep all pre-requisites
 content type,set cookies,add auth,add params,set headers info etc..
 */

/*when()  -- all request URLs
  get,post,put,delete
 */

/*then() -- all validations
  validate status code,extract response,extract headers cookies & response body..
 */

public class HttpRequests {
	int id;
@Test(priority=1)
 void getUsers() {  //add 3-static packages
	  given()
	 
	 .when()
	       .get("https://reqres.in/api/users?page=2")
	        
	 .then()
	       .statusCode(200)          //status code
	       .body("page",equalTo(2))  //extract response
	       .log().all();
 }

@Test(priority=2)
void createUser() {
	//generate data using hashMap
	HashMap data=new HashMap();
	data.put("name","akshata");
	data.put("job","tester");
	
	id=given()
	 .contentType("application/json")
	 .body(data)
	
	.when()
	     .post("https://reqres.in/api/users")
	     .jsonPath().getInt("id"); //capture id from res and use to update in next req
	
	/*.then()
	      .statusCode(201)
      .log().all(); */
	
}

@Test(priority=3,dependsOnMethods= {"createUser"})
void updateUser() {
	HashMap data=new HashMap();
	data.put("name","anitha");
	data.put("job","teacher");
	
	given()
			 .contentType("application/json")
			 .body(data)
			
			.when()
			     .put("https://reqres.in/api/users/"+id) //
			     
	         .then()
             .statusCode(200)
             .log().all(); 
}
@Test(priority=4)
void deleteUser() {
	 given()
	 
	 .when()
	     .delete("https://reqres.in/api/users/"+id)
	     
	 .then()
	 .statusCode(204)
	 .log().all();
}

}
