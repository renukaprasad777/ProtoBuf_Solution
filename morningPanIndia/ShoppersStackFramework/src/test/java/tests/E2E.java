package tests;

import org.testng.annotations.Test;

import endpoints.LoginEndpoints;
import endpoints.ViewProductsEndpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.Login;

public class E2E {
	int shopperId;
	String token;
	int productId;
	

	@Test(priority = 1)
	public void shopperLogin() {
		
		Login sl=new Login();
		sl.setEmail("api.rp21@gmail.com");
		sl.setPassword("Reset@123");
		sl.setRole("SHOPPER");
		
		Response resp = LoginEndpoints.Login(sl);
		resp.then().assertThat().statusCode(200);
		
		shopperId=resp.jsonPath().get("data.userId");
		token=resp.jsonPath().get("data.jwtToken");
		
		System.out.println(shopperId);
		System.out.println(token);
		
	}
	@Test(priority = 2)
	public void viewProducts() {
		Response resp = ViewProductsEndpoints.viewProducts();
		
		productId=resp.jsonPath().get("data[0].productId");
		System.out.println(productId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
