package com.cagataygurturk.controllers;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cagataygurturk.DemoApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port=12347")
public class TransactionsControllerTest {

	protected static String BASE_STRING = "http://localhost:12347/agodaservice";

	protected static String oldPassword = "AgodaService2!@1TestData";
	protected static String validNewPassword = "AgodaServiceVVVVAgodaServiceTestAgodaServiAaAaA!@#$0123456789012345678901234567890123456789012345678";
	protected static String eighteenAlphanumericAndSpecialCharsPassword = "AgodaService2!@1Te";
	protected static String invalidOldPassword = oldPassword.concat("1");
	protected static String lessThan18AlphanumericAndSpecialCharsPassword = "AgodaDef2!Service";
	protected static String noLowerCasePassword = validNewPassword.toUpperCase();
	protected static String noUpperCasePassword = validNewPassword.toLowerCase();
	protected static String noNumericPassword = "AgodaService@TestVV";
	protected static String noSpecialCharsPassword = "AgodaService12TestVV";
	protected static String invalidSpecialCharsPassword = "AgodaService12%^TestVV";
	protected static String moreThan4DuplicatedCharsPassword = validNewPassword.concat("vvvvv");
	protected static String moreThan4SpecialCharsPassword = "Ago!@daS*ervice2!#13";
	protected static String fiftyPercentNumericCharsPassword = "AgodaService!@13245678298980";
	protected static String similarityPassword = "AgodaService2!@1TestData12";

	@Test
	public void givenValidPasswordsWhenCallChangePasswordApiThenReturnTrue() throws Exception {
		Map<String, String> request = new HashMap<>();
		request.put("old_password", oldPassword);
		request.put("new_password", validNewPassword);
		String returnResult = given().contentType("application/json").body(request).when()
				.put(BASE_STRING.concat("/changepassword")).then().statusCode(200).extract().response().asString();
		assertEquals(returnResult, "true");
	}
	
	@Test
	public void given18AlphanumericAndSpecialCharsPasswordsWhenCallChangePasswordApiThenReturnTrue() throws Exception {
		Map<String, String> request = new HashMap<>();
		request.put("old_password", oldPassword);
		request.put("new_password", eighteenAlphanumericAndSpecialCharsPassword);
		String returnResult = given().contentType("application/json").body(request).when()
				.put(BASE_STRING.concat("/changepassword")).then().statusCode(200).extract().response().asString();
		assertEquals(returnResult, "true");
	}

	@Test
	public void givenInvalidOldPasswordsWhenCallChangePasswordApiThenReturnFalse() throws Exception {
		Map<String, String> request = new HashMap<>();
		request.put("old_password", invalidOldPassword);
		request.put("new_password", validNewPassword);
		String returnResult = given().contentType("application/json").body(request).when()
				.put(BASE_STRING.concat("/changepassword")).then().statusCode(200).extract().response().asString();
		assertEquals(returnResult, "false");
	}

	@Test
	public void givenLessThan18AlphanumericAndSpecialCharsPasswordsWhenCallChangePasswordApiThenReturnFalse()
			throws Exception {
		Map<String, String> request = new HashMap<>();
		request.put("old_password", oldPassword);
		request.put("new_password", lessThan18AlphanumericAndSpecialCharsPassword);
		String returnResult = given().contentType("application/json").body(request).when()
				.put(BASE_STRING.concat("/changepassword")).then().statusCode(200).extract().response().asString();
		assertEquals(returnResult, "false");
	}

	@Test
	public void givenNoLowerCasePasswordsWhenCallChangePasswordApiThenReturnFalse() throws Exception {
		Map<String, String> request = new HashMap<>();
		request.put("old_password", oldPassword);
		request.put("new_password", noLowerCasePassword);
		String returnResult = given().contentType("application/json").body(request).when()
				.put(BASE_STRING.concat("/changepassword")).then().statusCode(200).extract().response().asString();
		assertEquals(returnResult, "false");
	}

	@Test
	public void givenNoUpperCasePasswordsWhenCallChangePasswordApiThenReturnFalse() throws Exception {
		Map<String, String> request = new HashMap<>();
		request.put("old_password", oldPassword);
		request.put("new_password", noUpperCasePassword);
		String returnResult = given().contentType("application/json").body(request).when()
				.put(BASE_STRING.concat("/changepassword")).then().statusCode(200).extract().response().asString();
		assertEquals(returnResult, "false");
	}

	@Test
	public void givenNoNumericCharPasswordsWhenCallChangePasswordApiThenReturnFalse() throws Exception {
		Map<String, String> request = new HashMap<>();
		request.put("old_password", oldPassword);
		request.put("new_password", noNumericPassword);
		String returnResult = given().contentType("application/json").body(request).when()
				.put(BASE_STRING.concat("/changepassword")).then().statusCode(200).extract().response().asString();
		assertEquals(returnResult, "false");
	}

	@Test
	public void givenNoSpecialCharPasswordsWhenCallChangePasswordApiThenReturnFalse() throws Exception {
		Map<String, String> request = new HashMap<>();
		request.put("old_password", oldPassword);
		request.put("new_password", noSpecialCharsPassword);
		String returnResult = given().contentType("application/json").body(request).when()
				.put(BASE_STRING.concat("/changepassword")).then().statusCode(200).extract().response().asString();
		assertEquals(returnResult, "false");
	}

	@Test
	public void givenInvalidSpecialCharsPasswordsWhenCallChangePasswordApiThenReturnFalse() throws Exception {
		Map<String, String> request = new HashMap<>();
		request.put("old_password", oldPassword);
		request.put("new_password", invalidSpecialCharsPassword);
		String returnResult = given().contentType("application/json").body(request).when()
				.put(BASE_STRING.concat("/changepassword")).then().statusCode(200).extract().response().asString();
		assertEquals(returnResult, "false");
	}

	@Test
	public void givenMoreThanFourDuplicatedCharsPasswordsWhenCallChangePasswordApiThenReturnFalse() throws Exception {
		Map<String, String> request = new HashMap<>();
		request.put("old_password", oldPassword);
		request.put("new_password", moreThan4DuplicatedCharsPassword);
		String returnResult = given().contentType("application/json").body(request).when()
				.put(BASE_STRING.concat("/changepassword")).then().statusCode(200).extract().response().asString();
		assertEquals(returnResult, "false");
	}

	@Test
	public void givenMoreThan4SpecialCharsPasswordsWhenCallChangePasswordApiThenReturnFalse() throws Exception {
		Map<String, String> request = new HashMap<>();
		request.put("old_password", oldPassword);
		request.put("new_password", moreThan4SpecialCharsPassword);
		String returnResult = given().contentType("application/json").body(request).when()
				.put(BASE_STRING.concat("/changepassword")).then().statusCode(200).extract().response().asString();
		assertEquals(returnResult, "false");
	}

	@Test
	public void given50PercentNumberPasswordsWhenCallChangePasswordApiThenReturnFalse() throws Exception {
		Map<String, String> request = new HashMap<>();
		request.put("old_password", oldPassword);
		request.put("new_password", fiftyPercentNumericCharsPassword);
		String returnResult = given().contentType("application/json").body(request).when()
				.put(BASE_STRING.concat("/changepassword")).then().statusCode(200).extract().response().asString();
		assertEquals(returnResult, "false");
	}

	@Test
	public void givenInvalidSimilarityPasswordsWhenCallChangePasswordApiThenReturnFalse() throws Exception {
		Map<String, String> request = new HashMap<>();
		request.put("old_password", oldPassword);
		request.put("new_password", similarityPassword);
		String returnResult = given().contentType("application/json").body(request).when()
				.put(BASE_STRING.concat("/changepassword")).then().statusCode(200).extract().response().asString();
		assertEquals(returnResult, "false");
	}
}