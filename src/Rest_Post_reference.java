import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class Rest_Post_reference {

	    public static void main(String[] args) {
		//Declare the base URL
		RestAssured.baseURI = "https://reqres.in/";
			
		//Declare the request body string variable 
		String requestBody="{\r\n"
				+ "    \"name\": \"monika\",\r\n"
				+ "    \"job\": \"tester\"\r\n"
				+ "}";
		
		JsonPath JspRequest = new JsonPath(requestBody);
		String Req_name = JspRequest.getString("name");
	    String Req_job = JspRequest.getString("job");
	    
	  //Declare the given,when and then method
	    String responseBody = given().header("Content-Type","application/json").body(requestBody).
				post("api/users").then().extract().response().asString();
	    
	  //create an object of JSON path to parse the responseBody
		JsonPath Jspresponse = new JsonPath(responseBody);
		String res_name = Jspresponse.getString("name");
	    String res_job = Jspresponse.getString("job");
	    System.out.println(res_name);
	    System.out.println(res_job);
	  //validate the ResponseBody parameters
	    Assert.assertEquals(res_name,Req_name);
	    Assert.assertEquals(res_job,Req_job);
	    
	}

}
