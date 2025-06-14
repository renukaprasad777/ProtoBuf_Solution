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

        // Sending protobuf payload
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

        // De-serialize if response is also in protobuf
        byte[] responseBytes = response.asByteArray();
        System.out.println(responseBytes);;

	}
}
