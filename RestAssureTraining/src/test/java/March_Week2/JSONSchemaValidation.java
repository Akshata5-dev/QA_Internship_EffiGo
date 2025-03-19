package March_Week2;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JSONSchemaValidation {

	@Test
	void jsonschemavalidation() {
		given()
		.when()
		      .get("http://localhost:3000/store")
		.then()
		      .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeJSONSchema.json"));
		
	}
}
//http://restapi.adequateshop.com/api/Traveler
