package RestAssureChaining;
import static io.restassured.RestAssured.given;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Createuser {

	//create req body first-->json
	//generate random data -->use java faker
	@Test
	void test_createUser(ITestContext context) {
		Faker faker=new Faker();
		
		JSONObject data=new JSONObject();
		
		data.put("name",faker.name().fullName());
		data.put("gender","Male");
		data.put("email",faker.internet().emailAddress());
		data.put("status","inactive");
		
		String bearerToken="3649911ff47ea4429f4632a8b96a0e17303ded536dca1c70ff99f94b93ba4b2b";
		
		int id=given()
		      .headers("Authorization","Bearer "+bearerToken)
		      .contentType("application/json")
		      .body(data.toString())

		.when()
		      .post("https://gorest.co.in/public/v2/users")
		      .jsonPath().getInt("id");	      
		System.out.println("Generated id is:"+id);
		
		//available only at test level
	//	context.setAttribute("user_id",id); //Create globle variable 
		
		//available at suite level-->multiple test level
		context.getSuite().setAttribute("user_id",id);
	}
}
