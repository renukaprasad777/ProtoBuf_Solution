import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.io.FileReader;
import java.io.IOException;

public class CsvRead {

	@Test
	public void readCsv() throws IOException, CsvException{
		RestAssured.baseURI="https://api.restful-api.dev";
			
        CSVReader reader = new CSVReader(new FileReader("src/test/resources/userData.csv"));
        java.util.List<String[]> records = reader.readAll();
        reader.close();
        
        for (int i = 1; i < records.size(); i++) {
            String[] row = records.get(i);
            String name = row[0];
            String data = row[1];
            
		 Response response = given().contentType(ContentType.JSON).body("{\"name\": \""+ name +"\",\"data\": \""+data+"\"}").log().all()
		.when().post("/objects")
		.then().assertThat().statusCode(200).extract().response();
		
		String csvResp = response.getBody().asString();
		System.out.println(csvResp);
        }
	}
}
