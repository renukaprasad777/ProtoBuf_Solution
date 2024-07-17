package assertions;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class ResponseValidation {

	String baseUrl="https://reqres.in";
	@Test
	public void createUser() {

		HashMap mob= new HashMap<>();
		mob.put("mob1", "9835127635");
		mob.put("mob2", "8889990007");
		
		HashMap cb= new HashMap<>();
		cb.put("name", "morpheus");
		cb.put("job", "leader");
		cb.put("mob", mob);

		Response resp = given().body(cb).contentType(ContentType.JSON)
				.when().post(baseUrl+"/api/users");

		resp.then().log().all();
		//response headers
		resp.then().assertThat().header("Server", "cloudflare"); 							//header validation
		resp.then().assertThat().header("Content-Type", "application/json; charset=utf-8");	//header validation
		resp.then().assertThat().header("Connection", "keep-alive");						//header validation
		resp.then().assertThat().contentType(ContentType.JSON);						//content-type validation
		
		//status code
		resp.then().assertThat().statusCode(201);									//status code validation
		resp.then().assertThat().statusLine("HTTP/1.1 201 Created");				//status line validation

		//response time
		long timeTaken = resp.time();
		long timeInSeconds = resp.timeIn(TimeUnit.SECONDS);
		System.out.println(timeTaken);
		System.out.println(timeInSeconds);

		resp.then().assertThat().time(Matchers.lessThan(1700l));
		resp.then().assertThat().time(Matchers.greaterThan(300l));
		resp.then().assertThat().time(Matchers.both(Matchers.greaterThan(300l)).and(Matchers.lessThan(1700l)));


		//response body validation
		resp.then().assertThat().body("name", Matchers.equalTo("morpheus"));
		resp.then().assertThat().body("job", Matchers.equalTo("leader"));
		resp.then().assertThat().body("mob.mob1", Matchers.equalTo("9835127635"));
		resp.then().assertThat().body("mob.mob2", Matchers.equalTo("8889990007"));
		






	}
}
