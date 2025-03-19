package March_Week2;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// Pojo ->JSON obj  
// JSON obj-> Pojo
public class SerilizationDeserilization {
	
//a.Pojo ->Json
//@Test
void convertPojo2Json() throws JsonProcessingException {
	
	//create java object using pojo class
	Pojo_Student data=new Pojo_Student(); //pojo
    
    data.setName("Scott");
    data.setLocation("France");
    data.setPhone("123456");
    
    String courseArr[]= {"C","C++"};
    data.setCourses(courseArr);
    
    //convert java object -->json object(serilization)
    ObjectMapper objMapper=new ObjectMapper();
    
    String jsondata=objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
    
    System.out.println(jsondata);
    
}

//b.Deserilization

//copy output data of serialization 
@Test
  void convertJson2Pojo() throws JsonMappingException, JsonProcessingException {
	  String jsondata="{\r\n"
	  		+ "  \"name\" : \"Scott\",\r\n"
	  		+ "  \"location\" : \"France\",\r\n"
	  		+ "  \"phone\" : \"123456\",\r\n"
	  		+ "  \"courses\" : [ \"C\", \"C++\" ]\r\n"
	  		+ "}";
	  
	  //convert json data -->Pojo object
	  ObjectMapper objMapper=new ObjectMapper();
	  
	  //specify formate of pojo cls-->Pojo_Student
	  Pojo_Student stupo=objMapper.readValue(jsondata,Pojo_Student.class); //convert json to pojo 
	  //return objects of pojo_student cls 
	  
	  System.out.println("Name:"+stupo.getName());
	  System.out.println("location:"+stupo.getLocation());
	  System.out.println("Phone:"+ stupo.getPhone());
	  System.out.println("Course 1:"+stupo.getCourses()[0]);
	  System.out.println("Course 2:"+stupo.getCourses()[1]);			
  }
}
