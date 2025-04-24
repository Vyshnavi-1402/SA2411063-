package com.APItests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class  add_user extends BaseTest {

  @Test
  public void addUser() {
	  test = extent.createTest("Add User API Test");

	  Response res = given()
			  .header("Content-Type", "application/json")
			  .body("{\n"
	  		+ "\"firstName\": \"Test\",\n"
	  		+ "\"lastName\": \"User\",\n"
	  		+ "\"email\": \"smitha12223456@gmail.com\",\n"
	  		+ "\"password\": \"mypassword\"\n"
	  		+ "}")
			 .when().post("https://thinking-tester-contact-list.herokuapp.com/users");
		   System.out.println("Response Body: " + res.getBody().asString());
		  //validate the status code
		  Assert.assertEquals(res.getStatusCode(), 201);
		  System.out.println("status code " +res.getStatusCode());
     
		
  }
}
