package Tests;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetandPostExamples {
	
	//@Test
	public void testGet() {
		baseURI = "https://reqres.in/api";
		baseURI = "https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200).body("data[4].first_name", equalTo("George")).body("data.first_name",hasItems("Rachel","George"));
			}
	@Test
	public void testPost() {
		Map<String, Object> map = new HashMap<String, Object>();
		baseURI = "https://reqres.in/api";
		//map.put("name", "AKhil");
	//	map.put("job", "QA Analyst");
	//	System.out.println(map);
		JSONObject request = new JSONObject();
		request.put("name", "AKhil");
		request.put("job", "QA Analyst");
		System.out.println(request.toJSONString());
		
		given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when().post("/users").then().statusCode(201).log();
	}

}
