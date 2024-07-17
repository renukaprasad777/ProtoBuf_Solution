package reqres;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetUsers {

	@Test
	public void GetListOfUsers() {
		
		//given() - Inputs(header, auth, payload/body)
		//when() - type of HTTP method alond with URI
		//then() - Validation/assertion
		
		RestAssured.
			
			when().get("https://reqres.in/api/users?page=2")
			.then().log().all().assertThat().statusCode(200);
	}
}
