package March_Week2;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;  // Import equalTo matcher
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class DiffWaysToCreatePostRequestBody {
//1.Post request body using-HashMap --suitalbe for small amt of data
	//@Test(priority=1)
	void testPostusingHashMap() {
	    HashMap<String, Object> data = new HashMap<>();
	    data.put("id",4);
	    data.put("name", "Scott");
	    data.put("location", "France");
	    data.put("phone", "123456");

	    String courseArr[] = {"C", "C++"};
	    data.put("courses", courseArr);

	    given()
	          .contentType("application/json")
	          .body(data)
	    .when()
	          .post("http://localhost:3000/students")
	    .then()
	          .statusCode(201)
	          .body("name", equalTo("Scott"))
	          .body("location", equalTo("France"))
	          .body("phone", equalTo("123456"))
	          .body("courses[0]", equalTo("C"))
	          .body("courses[1]", equalTo("C++"))
	          .header("Content-Type", containsString("application/json")) // Fixed assertion
	          .log().all();
	}

	//deleting record
	//@Test(priority=2)
	void testDelete() {
		given()
		.header("Content-Type", "application/json")
		.when()
		      .delete("http://localhost:3000/students/3")
		
		.then()
		      .statusCode(200);
	}
	
	//2.using JSON
	//@Test(priority=1)
	void testPostusingJsonLibrary() {
		
	    JSONObject data=new JSONObject();
	    
	    data.put("name", "Scott");
	    data.put("location", "France");
	    data.put("phone", "123456");
	    String courseArr[] = {"C", "C++"};
	    data.put("courses", courseArr);

	    given()
	          .contentType("application/json")
	          .body(data.toString())//use toString
	          
	    .when()
	          .post("http://localhost:3000/students")
	    .then()
	          .statusCode(201)
	          .body("name", equalTo("Scott"))
	          .body("location", equalTo("France"))
	          .body("phone", equalTo("123456"))
	          .body("courses[0]", equalTo("C"))
	          .body("courses[1]", equalTo("C++"))
	          .header("Content-Type", containsString("application/json")) // Fixed assertion
	          .log().all();
	}
	//3.using POJO(plain old java Object
	//@Test(priority=3)
		void testPostusingPOJO() {
			
		   Pojo_PostRequest data=new Pojo_PostRequest();
		    
		    data.setName("Scott");
		    data.setLocation("France");
		    data.setPhone("123456");
		    
		    String courseArr[]= {"C","C++"};
		    data.setCourses(courseArr);

		    given()
		          .contentType("application/json")
		          .body(data)
		          
		    .when()
		          .post("http://localhost:3000/students")
		    .then()
		          .statusCode(201)
		          .body("name", equalTo("Scott"))
		          .body("location", equalTo("France"))
		          .body("phone", equalTo("123456"))
		          .body("courses[0]", equalTo("C"))
		          .body("courses[1]", equalTo("C++"))
		          .header("Content-Type", containsString("application/json")) // Fixed assertion
		          .log().all();
		}
	//4.External json file
	@Test(priority=4)
	void testPostusingExternalJsonFile() throws FileNotFoundException {
    //a.open file
		File f=new File(".\\Body.json");
		FileReader fr=new FileReader(f);
		
		JSONTokener jt=new JSONTokener(fr);
		JSONObject data=new JSONObject(jt);
		
		
	    given()
	          .contentType("application/json")
	          .body(data.toString())
	          
	    .when()
	          .post("http://localhost:3000/students")
	    .then()
	          .statusCode(201)
	          .body("name", equalTo("Scott"))
	          .body("location", equalTo("France"))
	          .body("phone", equalTo("123456"))
	          .body("courses[0]", equalTo("C"))
	          .body("courses[1]", equalTo("C++"))
	          .header("Content-Type", containsString("application/json")) // Fixed assertion
	          .log().all();
	}

}
