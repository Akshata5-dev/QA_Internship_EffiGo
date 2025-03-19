package RestAssureChaining;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {
@Test
	void test_getUser(ITestContext context) {
		//int id=(int) context.getAttribute("user_id");//this should come from createuser request
	int id=(int) context.getSuite().getAttribute("user_id");
	
		String bearerToken="3649911ff47ea4429f4632a8b96a0e17303ded536dca1c70ff99f94b93ba4b2b";
		
		given()
		      .headers("Authorization","Bearer "+bearerToken)
		      .pathParam("id",id)
		.when()
		      .get("https://gorest.co.in/public/v2/users/{id}")
		.then()
		      .statusCode(200)
		      .log().all();
	}
}
