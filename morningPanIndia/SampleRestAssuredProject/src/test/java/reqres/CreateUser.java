package reqres;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateUser {

	@Test
	public void createUser() {
		
		//given() - Inputs(header, auth, payload/body)
		//when() - type of HTTP method alond with URI
		//then() - Validation/assertion
		
		RestAssured.given().body("{\r\n"
				+ "    \"name\": \"abc\",\r\n"
				+ "    \"job\": \"engg\"\r\n"
				+ "}").contentType(ContentType.JSON)
		.when().post("https://reqres.in/api/users")
		.then().log().all().assertThat().statusCode(201);
	}
}
