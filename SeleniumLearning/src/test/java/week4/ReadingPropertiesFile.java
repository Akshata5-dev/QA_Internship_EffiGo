package week4;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;


//to specify common data: in key:value pair 
public class ReadingPropertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	//1.create object of Properties class
    Properties propertiesobj=new Properties();
    
    //2.location of file:get location dynamically
    FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\TestData\\Config.properties");
    
    //3.Loading properties file
    propertiesobj.load(file);
    
    //4.Reading data from properties file
    String url=propertiesobj.getProperty("appurl");
    String email=propertiesobj.getProperty("email");
    String password=propertiesobj.getProperty("password");
    String orderId=propertiesobj.getProperty("orderid");
    String customerId=propertiesobj.getProperty("custumorid");
    
    System.out.println(url+" "+email+" "+password+" "+orderId+" "+customerId);
    
    //5.Reading all keys from properties file
    //a.Only string
    /*
    Set<String> keys=propertiesobj.stringPropertyNames();
    System.out.println(keys);*/
    
    //b:combination of all data types
    Set<Object> keys=propertiesobj.keySet();
    System.out.println(keys);
    
    //5.Reading all values from properties file
    Collection<Object> Values=propertiesobj.values();
    System.out.println(Values);

	}

}
