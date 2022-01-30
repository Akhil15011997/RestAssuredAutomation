package Tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestsExamples {

	
	@Test
	public void Test1() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		
		response.getStatusCode();
		response.getTime();
		System.out.println(response.getTime() + "\n" +response.getStatusCode() + "\n" +response.getBody().asString()+"\n" +response.getHeader("content-type") +"\n" +response.getStatusLine());
	}
	
	@Test
	public void Test2() {
		baseURI = "https://reqres.in/api";
		
		given().get("/users?page=2").then().statusCode(200).body("data[1].id", equalTo(8)).log().all();
		
	}
}
