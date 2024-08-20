package differentWaysToPassBody;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import pojo.CreateUser;


public class pojo {

	@Test
	public void createUser() {
		CreateUser cu=new CreateUser();
		cu.setName("Morpheus");
		cu.setJob("leader");
		
			RestAssured.given().body(cu).contentType(ContentType.JSON)
			.when().post("https://reqres.in/api/users")
			.then().assertThat().statusCode(201).log().all();
	}
}
