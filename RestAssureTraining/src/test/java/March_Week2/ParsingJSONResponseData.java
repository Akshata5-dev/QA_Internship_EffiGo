package March_Week2;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ParsingJSONResponseData {
     @Test(priority=1)
    void testJSONResponse() {
    /*	//Approach1:
        given()
              .contentType(ContentType.JSON)
        .when()
              .get("http://localhost:3000/store")
        .then()
              .statusCode(200)
              .header("Content-Type", "application/json")  // Fixed the header assertion
              .body("book[2].title", equalTo("To Kill a Mockingbird"));
      */

	//Approach2:
	Response res=given()
	      .contentType(ContentType.JSON)
	      
	.when()
     .get("http://localhost:3000/store");
	
 	/*  Assert.assertEquals(res.getStatusCode(),200);  //validation1
 	  Assert.assertEquals(res.header("Content-Type"),"application/json");
 	  
 	  String bookname=res.jsonPath().getString("book[2].title").toString();
 	  Assert.assertEquals(bookname,"To Kill a Mockingbird");
 	  */
	
	//3.JSONObject class
	JSONObject jo=new JSONObject(res.asString()); //convert response to json object type
	
	//print all title of books
	/*for(int i=0;i<jo.getJSONArray("book").length();i++) {
		String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString(); //i--> represents 0
		System.out.println(bookTitle);
	}*/
	
	//search for title of book in json - validation 1
	boolean status=false;
	//print specific book title
	for(int i=0;i<jo.getJSONArray("book").length();i++) {
		String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString(); 
		
		//traverse throughout json
		if(bookTitle.equals("To Kill a Mockingbird")) {
			status=true;
			break;
		}
	}
	Assert.assertEquals(status,true);
 	  
 	  
	//validate total price of books -validation 2
	double totalprice=0;
	for(int i=0;i<jo.getJSONArray("book").length();i++) {
		String price=jo.getJSONArray("book").getJSONObject(i).get("price").toString();
		
		//convert string to decimal(double)-->price
		totalprice = totalprice+Double.parseDouble(price);
	}
	
	System.out.println("total price of books is:"+totalprice);
	Assert.assertEquals(totalprice,65.97);
}

}
