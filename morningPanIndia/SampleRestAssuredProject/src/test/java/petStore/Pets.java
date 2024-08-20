package petStore;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojo.Category;
import pojo.CreatePet;
import pojo.Tags;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class Pets {

	@Test(priority = 1)
	public void createPet() {
		
		/*{
			   "category": {
			    "id": 0,
			    "name": "string"
			  },
			  "name": "doggie",
			   "tags": [
			    {
			      "id": 0,
			      "name": "string"
			    }
			  ],
			  "status": "available"
			}*/
		
		
		Category cat=new Category();
		cat.setId(1);
		cat.setName("Dog");
		
		Tags tag1=new Tags();
		tag1.setId(0);
		tag1.setName("newTag");
		
		ArrayList<Tags> tags=new ArrayList<Tags>();
		tags.add(tag1);
		
		CreatePet cp = new CreatePet(0, cat, "Ruby", tags, "available");
		
		
		
		given().contentType(ContentType.JSON)
		.body(cp)
		.when().post("https://petstore.swagger.io/v2/pet")
		.then().log().all().assertThat().statusCode(200);
	}
}
