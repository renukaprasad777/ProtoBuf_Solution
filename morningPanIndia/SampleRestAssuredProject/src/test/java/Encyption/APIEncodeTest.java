package Encyption;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class APIEncodeTest {

	@Test
	public void sampleTest() {
		RestAssured.given().auth().preemptive().basic("postman", "password").log().all()
		.when().get("https://postman-echo.com/basic-auth")
		.then().log().all();
		
	}
}
