package auth;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Oauth2 {

	@Test
	public void createRepo() {
	
		Response resp=RestAssured.given()
		.formParam("client_id", "ninza-client")
		.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		.formParam("grant_type", "client_credentials")
		.when().post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		
		String accessToken=resp.jsonPath().getString("access_token");
		
		RestAssured.given().auth().oauth2(accessToken)
		.when().get("http://49.249.28.218:8091/projects")
		.then().log().all();
	}
}
