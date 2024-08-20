package Encyption;

import java.util.Base64;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class EncodeAndDecode {

	@Test
	public void data() {
		String encodedData= new String(Base64.getEncoder().encode("ABC".getBytes()));
		System.out.println(encodedData);
		
		String decodedData= new String(Base64.getDecoder().decode("QUJD".getBytes()));
		System.out.println(decodedData);
		
		String encodedData1= new String(Base64.getEncoder().encode("postman:password".getBytes()));
		System.out.println(encodedData1);
		
		String decodedData1= new String(Base64.getDecoder().decode(encodedData1.getBytes()));
		System.out.println(decodedData1);
	}
}
