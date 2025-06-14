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
			
		//to read a CSV file
        CSVReader reader = new CSVReader(new FileReader("src/test/resources/userData.csv"));
        java.util.List<String[]> records = reader.readAll();
        reader.close();
        
        for(int i = 1; i < records.size(); i++) {
            String[] row = records.get(i);
            String name = row[0];
            String data = row[1];
            
		 String csvResponse = given().contentType(ContentType.JSON)
				 .body("{\"name\": \""+ name +"\",\"data\": \""+data+"\"}") //concatenating the values with the title specified in the CSV file
		.when().post("/objects")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(csvResponse);
        }
	}
}
