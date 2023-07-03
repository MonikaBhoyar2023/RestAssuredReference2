

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class Rest_Get_Refrence {

    public static void main(String[] args) {
	
    RestAssured.baseURI="https://reqres.in/";
    
    //Declare response body
    
    String responseBody = given().header("content-type","application/json").
    		              body("requestBody").when().get("/api/users/2").
    		              then().extract().response().asString();
    
    System.out.println(responseBody);
    
   
   }
    

}
