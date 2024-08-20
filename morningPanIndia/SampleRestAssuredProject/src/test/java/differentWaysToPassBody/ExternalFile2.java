package differentWaysToPassBody;

import java.io.File;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ExternalFile2 {

	@Test
	public void createUser() {
		
		File f=new File("./src/test/resources/download.jpeg");
		
		RestAssured.given().contentType(ContentType.MULTIPART).multiPart(f)
		.queryParam("shopperId", 5597).log().all()
		.when().post("https://www.shoppersstack.com/shopping/shoppers/upload")
		.then().log().all();
		
	}
}
