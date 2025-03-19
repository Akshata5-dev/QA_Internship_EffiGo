package RestAssureChaining;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;
public class DeleteUser {
@Test
	void  test_deleteUser(ITestContext context) {
		String bearerToken="3649911ff47ea4429f4632a8b96a0e17303ded536dca1c70ff99f94b93ba4b2b";
		
		//int id=(int) context.getAttribute("user_id"); //this cm from create user
		int id=(int) context.getSuite().getAttribute("user_id");
		given()
		  .headers("Authorization","Bearer "+bearerToken)
	      .pathParam("id",id)
	     
		.when()
		.delete("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		      .statusCode(204)
		      .log().all();
		
				
	}
}
