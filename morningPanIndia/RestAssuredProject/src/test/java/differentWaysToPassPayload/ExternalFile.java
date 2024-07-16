package differentWaysToPassPayload;

import java.io.File;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ExternalFile {

	@Test
	public void createUser() {
		
		
		File f=new File("./src/test/resources/body.json");
		
		RestAssured.given().body(f).contentType(ContentType.JSON)
		.when().post("https://reqres.in/api/users")
		.then().log().all().assertThat().statusCode(201);
	}
}
