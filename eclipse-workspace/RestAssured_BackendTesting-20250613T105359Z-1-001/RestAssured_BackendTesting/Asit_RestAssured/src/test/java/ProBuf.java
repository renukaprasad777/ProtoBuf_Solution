import org.testng.annotations.Test;
import com.example.login.LoginRequestOuterClass.LoginRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ProBuf {

	@Test
	public void ProBufTest() {
		
		LoginRequest request = LoginRequest.newBuilder()
                .setUsername("user1")
                .setPassword("pass1")
                .build();

        // Serialize to byte array
        byte[] requestBody = request.toByteArray();
        System.out.println(requestBody);

        // Send protobuf payload via REST Assured
        Response response = RestAssured
                .given()
                    .baseUri("https://example.com")
                    .basePath("/api/login")
                    .contentType("application/x-protobuf")
                    .body(requestBody)
                .when()
                    .post()
                .then()
                    .extract().response();

        // If response is also in protobuf
        byte[] responseBytes = response.asByteArray();
        System.out.println(responseBytes);;

        // Deserialize response (assuming you have a ResponseMessage proto)
        // ResponseMessage responseMessage = ResponseMessage.parseFrom(responseBytes);

        System.out.println("Status: " + response.statusCode());
        // System.out.println("Response ID: " + responseMessage.getId());
	}
}
