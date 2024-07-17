package petStore;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Pets {

	String baseUrl="https://petstore.swagger.io/v2";
	long petId;

	@Test(priority = 1)
	public void createPet() {

		Category cat=new Category();
		cat.setId(1);
		cat.setName("Dog");

		PetCreation data=new PetCreation();
		data.setCategory(cat);
		data.setName("Scooby");
		data.setStatus("available");

		Response resp = given().body(data).contentType(ContentType.JSON) //can capture multiple data
				.when().post(baseUrl+"/pet");

		resp.then().assertThat().statusCode(200);

		petId=resp.jsonPath().get("id");
		String catName=resp.jsonPath().get("category.name");
		String status=resp.jsonPath().get("status");

		System.out.println(petId);
		System.out.println(catName);
		System.out.println(status);
		resp.then().log().all();

		resp.then().assertThat().body("category.name", Matchers.equalTo("Dog"));
		
	}

//	//getPet
//	@Test(priority = 2)
//	public void getPet() {
//
//		given().pathParam("petId", petId)
//		.when().get(baseUrl+"/pet/{petId}")
//		.then().assertThat().statusCode(200);
//
//	}
//
//	//updatePet
//	@Test(priority = 3)
//	public void updatePet() {
//		Category cat=new Category();
//		cat.setId(1);
//		cat.setName("Dog");
//
//		PetUpdation pu=new PetUpdation();
//		pu.setId(petId);
//		pu.setCategory(cat);
//		pu.setName("Jimmy");
//		pu.setStatus("unavailable");
//
//		given().body(pu).contentType(ContentType.JSON).log().all()
//		.when().put(baseUrl+"/pet")
//		.then().log().all().assertThat().statusCode(200);
//
//	}
//
//	//deletePet
//	@Test(priority = 4)
//	public void deletePet() {
//
//		given().pathParam("petId", petId)
//		.when().delete(baseUrl+"/pet/{petId}")
//		.then().assertThat().statusCode(200);
//
//	}
//	//getPet
//	@Test(priority = 5)
//	public void getPet2() {
//
//		given().pathParam("petId", petId)
//		.when().get(baseUrl+"/pet/{petId}")
//		.then().assertThat().statusCode(404);
//
//	}


}
