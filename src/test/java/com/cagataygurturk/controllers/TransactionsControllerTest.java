package com.cagataygurturk.controllers;

import com.cagataygurturk.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port=12347")
public class TransactionsControllerTest {

	protected static String BASE_STRING = "http://localhost:12347/agodaservice";

	protected static String oldPassword="AgodaService2!@1TestData";

	@Test
	public void givenValidPasswordsWhenCallChangePasswordApiThenReturnTrue() throws Exception {
		Map<String, String> request = new HashMap<>();
		request.put("old_password", oldPassword);
		request.put("new_password", "AgodaService2!@132ghtyuyu");
		String returnResult = given().contentType("application/json").body(request).when()
				.put(BASE_STRING.concat("/changepassword")).then().statusCode(200).extract().response().asString();
		assertEquals(returnResult, "true");
	}

	@Test
	public void givenLessThan18CharPasswordsWhenCallChangePasswordApiThenReturnFalse() throws Exception {
		Map<String, String> request = new HashMap<>();
		request.put("old_password", oldPassword);
		request.put("new_password", "AgodaDef2!Service");
		String returnResult = given().contentType("application/json").body(request).when()
				.put(BASE_STRING.concat("/changepassword")).then().statusCode(200).extract().response().asString();
		assertEquals(returnResult, "false");
	}
	
	@Test
	public void givenNonLowerCasePasswordsWhenCallChangePasswordApiThenReturnFalse() throws Exception {
		Map<String, String> request = new HashMap<>();
		request.put("old_password", oldPassword);
		request.put("new_password", "AGODASERVICE@123TEST");
		String returnResult = given().contentType("application/json").body(request).when()
				.put(BASE_STRING.concat("/changepassword")).then().statusCode(200).extract().response().asString();
		assertEquals(returnResult, "false");
	}
	
	@Test
	public void givenNonUpperCasePasswordsWhenCallChangePasswordApiThenReturnFalse() throws Exception {
		Map<String, String> request = new HashMap<>();
		request.put("old_password", oldPassword);
		request.put("new_password", "agodaservice@123test");
		String returnResult = given().contentType("application/json").body(request).when()
				.put(BASE_STRING.concat("/changepassword")).then().statusCode(200).extract().response().asString();
		assertEquals(returnResult, "false");
	}
	
	@Test
	public void givenNoNumericCharPasswordsWhenCallChangePasswordApiThenReturnFalse() throws Exception {
		Map<String, String> request = new HashMap<>();
		request.put("old_password", oldPassword);
		request.put("new_password", "AgodaService@TestVV");
		String returnResult = given().contentType("application/json").body(request).when()
				.put(BASE_STRING.concat("/changepassword")).then().statusCode(200).extract().response().asString();
		assertEquals(returnResult, "false");
	}
	
	@Test
	public void givenNoSpecialCharPasswordsWhenCallChangePasswordApiThenReturnFalse() throws Exception {
		Map<String, String> request = new HashMap<>();
		request.put("old_password", oldPassword);
		request.put("new_password", "AgodaService12TestVV");
		String returnResult = given().contentType("application/json").body(request).when()
				.put(BASE_STRING.concat("/changepassword")).then().statusCode(200).extract().response().asString();
		assertEquals(returnResult, "false");
	}
	
	@Test
	public void givenFourDuplicatedCharPasswordsWhenCallChangePasswordApiThenReturnFalse() throws Exception {
		Map<String, String> request = new HashMap<>();
		request.put("old_password", oldPassword);
		request.put("new_password", "AgodaService2!@132VVVVV");
		String returnResult = given().contentType("application/json").body(request).when()
				.put(BASE_STRING.concat("/changepassword")).then().statusCode(200).extract().response().asString();
		assertEquals(returnResult, "false");
	}
	
	@Test
	public void given50PercentNumberPasswordsWhenCallChangePasswordApiThenReturnFalse() throws Exception {
		Map<String, String> request = new HashMap<>();
		request.put("old_password", oldPassword);
		request.put("new_password", "AgodaService!@13245678298980");
		String returnResult = given().contentType("application/json").body(request).when()
				.put(BASE_STRING.concat("/changepassword")).then().statusCode(200).extract().response().asString();
		assertEquals(returnResult, "false");
	}

	@Test
	public void givenInvalidSimilarityPasswordsWhenCallChangePasswordApiThenReturnFalse() throws Exception {
		Map<String, String> request = new HashMap<>();
		request.put("old_password", oldPassword);
		request.put("new_password", "AgodaService2!@1TestData12");
		String returnResult = given().contentType("application/json").body(request).when()
				.put(BASE_STRING.concat("/changepassword")).then().statusCode(200).extract().response().asString();
		assertEquals(returnResult, "false");
	}
}