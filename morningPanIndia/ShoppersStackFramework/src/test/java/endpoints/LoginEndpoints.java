package endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginEndpoints {

	public static Response Login(payload.Login payload) {
		Response resp = RestAssured.given().body(payload)
				.contentType(ContentType.JSON)	
		.when().post(Routes.LoginUrl);
		
		return resp;
		
	
	}
}
