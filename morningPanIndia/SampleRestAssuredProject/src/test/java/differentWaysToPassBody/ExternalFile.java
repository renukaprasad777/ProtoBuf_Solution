package differentWaysToPassBody;

import java.io.File;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ExternalFile {

	@Test
	public void createUser() {
		
		File f=new File("./src/test/resources/body.json");
		
		RestAssured.given().contentType(ContentType.JSON).body(f)
		.when().post("https://reqres.in/api/users")
		.then().log().all().statusCode(201);
		
	}
}
