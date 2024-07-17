package differentWaysToPassPayload;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Raw {

	@Test
	public void createUser() {
		RestAssured.given().body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}").contentType(ContentType.JSON)
		.when().post("https://reqres.in/api/users")
		.then().log().all().assertThat().statusCode(201);
	}
}
