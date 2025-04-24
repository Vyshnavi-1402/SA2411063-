package com.APItests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class LoginUser extends BaseTest{
  @Test
  public void login_post_req() {
	 test = extent.createTest("Login API Test");
	  Response res = given()
			  .header("Content-Type", "application/json")
			  .body("{\n"
			  		+ "\"email\": \"smith174@gmail.com\",\n"
			  		+ "\"password\": \"mypassword\"\n"
			  		+ "}")
			 .when().post("https://thinking-tester-contact-list.herokuapp.com/users/login");
		   System.out.println("Response Body: " + res.getBody().asString());
		  //validate the status code
		  Assert.assertEquals(res.getStatusCode(), 200);
		  System.out.println("status code " +res.getStatusCode());
  }
}
