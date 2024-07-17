package differentWaysToPassPayload;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UsingPojo {

	@Test
	public void createUser() {
		
		User data=new User();
		data.setName("Rohit");
		data.setJob("Batsmen");

		RestAssured.given().body(data).contentType(ContentType.JSON)
		.when().post("https://reqres.in/api/users")
		.then().log().all().assertThat().statusCode(201);
	}
}
