package panCardMock;

import static org.mockito.ArgumentMatchers.contains;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PaymentTest {

	@Test
	public void sampleTest() {
		HashMap body=new HashMap();
		body.put("creditCard", "123456781233");
		body.put("cvv",123);
		body.put("cardName","Renuka Prasad");
		
		given().contentType(ContentType.JSON).log().all()
		.body(body)
		.when().post("http://localhost:8887/creditCard")
		.then().log().all().assertThat().statusCode(200);
	}
}
