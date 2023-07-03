        import org.testng.Assert;
		import static io.restassured.RestAssured.given;
		import io.restassured.RestAssured;
		import io.restassured.path.json.JsonPath;
	      public class Rest_Patch_Reference {
		  private static String expecteddate;
		  public static void main(String[] args){
			  //Declare the Base URL
			  RestAssured.baseURI = "https://reqres.in/";
			  //Declare the request body String Variable
			  String requestBody = "{\r\n"
			  		+ "    \"name\": \"monika\",\r\n"
			  		+ "    \"job\": \"testing\"\r\n"
			  		+ "}";
			  //declare the expected results
			   JsonPath jspRequest = new JsonPath(requestBody);
			  String req_name = jspRequest.getString("name");
			  String req_job = jspRequest.getString("job");
			  //Declare Given When Then Method
			     String responseBody = given().header("Content-Type","Application/json").
			     body(requestBody).when().patch("api/users/2").
			     then().extract().response().asString();
			     //Create an Object of Json Path to parse the ResponseBody
			  JsonPath jspResponse = new JsonPath(responseBody);
			  String res_name = jspResponse.getString("name");
			  String res_job = jspResponse.getString("job");
			  String res_createdAt = jspResponse.getString("createdAt");
			  res_createdAt = res_createdAt.substring(0,11);
			     System.out.println(res_createdAt);
			     System.out.println(res_name);
			     System.out.println(res_job);
			  //Validate ResponseBody
			  Assert.assertEquals(res_name,req_name);
			  Assert.assertEquals(res_job,req_job);
			  Assert.assertEquals(res_createdAt,expecteddate);
			  
		  }
		}
