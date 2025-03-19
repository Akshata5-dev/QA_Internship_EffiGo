package RestAssureChaining;
import static io.restassured.RestAssured.given;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {
	@Test
	void test_updateUser(ITestContext context) {
	Faker faker=new Faker();
	
	JSONObject data=new JSONObject();
	
	data.put("name",faker.name().fullName());
	data.put("gender","Male");
	data.put("email",faker.internet().emailAddress());
	data.put("status","active");
	
	String bearerToken="3649911ff47ea4429f4632a8b96a0e17303ded536dca1c70ff99f94b93ba4b2b";
	
	//int id=(int) context.getAttribute("user_id");//cm from user req
	int id=(int) context.getSuite().getAttribute("user_id");
       given()
	      .headers("Authorization","Bearer "+bearerToken)
	      .contentType("application/json")
	      .pathParam("id",id)
	      .body(data.toString())

	      .when()
	      .put("https://gorest.co.in/public/v2/users/{id}")
	      
	      .then()
	      .statusCode(200)
	      .log().all();
}
}
