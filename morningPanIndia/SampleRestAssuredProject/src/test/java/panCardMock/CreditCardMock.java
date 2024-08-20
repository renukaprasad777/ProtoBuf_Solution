package panCardMock;

import spark.Spark;

public class CreditCardMock {
	public static void main(String[] args) {

		Spark.port(8887);
		Spark.post("/creditCard", (req,res)->{
			String response="";
			String card= com.jayway.jsonpath.JsonPath.read(req.body().toString(), "$.creditCard");
			if(org.apache.commons.lang3.StringUtils.equalsAny(card, "123456781234","123456781233")) {
				response = "{\r\n"
						+ "	\"Status\":\"Payment success\"\r\n"
						+ "}";
				res.status(200);
			}else {
				response = "{\r\n"
						+ "	\"Status\":\"Payment failed\"\r\n"
						+ "}";
				res.status(404);
			}
			res.type("application/json");
			return response;
		});
		System.out.println("=========Running=========");	
	}
	
}
