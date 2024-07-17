package differentWaysToPassPayload;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class JsonObject {

	@Test
	public void createUser() {
		JSONObject cb=new JSONObject();
		cb.put("name", "Virat");
		cb.put("job", "cricketer");		
		
		RestAssured.given().body(cb).contentType(ContentType.JSON)
		.when().post("https://reqres.in/api/users")
		.then().log().all().assertThat().statusCode(201);
	}
}
