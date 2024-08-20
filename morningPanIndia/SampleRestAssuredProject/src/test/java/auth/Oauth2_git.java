package auth;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Oauth2_git {

	@Test
	public void createRepo() {
	
		
		
		RestAssured.given()
		.queryParam("client_id", "Ov23liaZ0HAaQXfIV9Fo")
		.queryParam("redirect_uri", "https://github.com")
		.log().all()		
		
		.when().get("https://github.com/login/oauth/authorize")
		.then().log().all();
		
		
		
//		RestAssured.given()
//		.formParam("client_id", "Ov23liaZ0HAaQXfIV9Fo")
//		.formParam("client_secret", "8ae9cc8cc0518131b512a7f11f3596d9bb16a6c9")
//		.formParam("grant_type", "client_credentials")
//		.when().post("https://github.com/login/oauth/access_token")
//		.then().log().all();
		
//		String accessToken=resp.jsonPath().getString("access_token");
//		
//		RestAssured.given().auth().oauth2(accessToken)
//		.when().get("http://49.249.28.218:8091/projects")
//		.then().log().all();
	}
}
