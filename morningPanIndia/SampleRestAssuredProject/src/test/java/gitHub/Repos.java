package gitHub;

import java.util.HashMap;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class Repos {
	
	String base_url="https://api.github.com";
	String token="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";
	@Test(priority = 1)
	public void createRepo() {
		HashMap cb=new HashMap(); 
		cb.put("name", "YuvrajSingh");
		cb.put("description", "Batsmen");
		cb.put("private", true);
		
		given().contentType(ContentType.JSON).body(cb)
		.header("Authorization", "Bearer "+token)
		.when().post(base_url+"/user/repos")
		.then().assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(3500l))
		.body("name", Matchers.equalTo("YuvrajSingh"))
		.body("description", Matchers.equalTo("Batsmen"))
		.body("private", Matchers.equalTo(true));
	}
	
	@Test(priority = 2)
	public void getRepo() {
		given().header("Authorization", "Bearer "+token)
		.pathParam("owner", "renukaprasad777")
		.pathParam("repo", "YuvrajSingh")
		.when().get(base_url+"/repos/{owner}/{repo}")
		.then().assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(3500l))
		.body("name", Matchers.equalTo("YuvrajSingh"))
		.body("description", Matchers.equalTo("Batsmen"))
		.body("private", Matchers.equalTo(true));
	}
	
	@Test(priority = 3)
	public void updateRepo() {
		HashMap cb=new HashMap(); 
		cb.put("description", "All rounder");
		cb.put("private", false);
		
		given().contentType(ContentType.JSON).body(cb)
		.header("Authorization", "Bearer "+token)
		.pathParam("owner", "renukaprasad777")
		.pathParam("repo", "YuvrajSingh")
		.when().patch(base_url+"/repos/{owner}/{repo}")
		.then().assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(3500l))
		.body("name", Matchers.equalTo("YuvrajSingh"))
		.body("description", Matchers.equalTo("All rounder"))
		.body("private", Matchers.equalTo(false));
	}
	
	@Test(priority = 4)
	public void deleteRepo() {
		given().header("Authorization", "Bearer "+token)
		.pathParam("owner", "renukaprasad777")
		.pathParam("repo", "YuvrajSingh")
		.when().delete(base_url+"/repos/{owner}/{repo}")
		.then().assertThat().statusCode(204);
	}

}
