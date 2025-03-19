package March_Week2;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

// https://github.com/DiUS/java-faker
public class FakeDataGenerator {
@Test
	void testGeneratorDummyData() {
		Faker faker=new Faker();
		
		String fullname=faker.name().fullName();
		String firstname=faker.name().firstName();
		String lastname=faker.name().lastName();
		
		String username=faker.name().username();
		String password=faker.internet().password();
		
		String phone=faker.phoneNumber().cellPhone();
		String email=faker.internet().safeEmailAddress();
		
		System.out.println("Fullname: "+fullname);
		System.out.println("Firstname: "+firstname);
		System.out.println("Lastname: "+lastname);
		System.out.println("Username: "+username);
		System.out.println("Password: "+password);
		System.out.println("Phone: "+phone);
		System.out.println("Email: "+email);
		
		
	}
}
