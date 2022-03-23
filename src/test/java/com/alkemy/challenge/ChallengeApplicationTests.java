package com.alkemy.challenge;

import java.io.File;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@SpringBootTest
class ChallengeApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void bearerTokenAuth() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8081;
		RequestSpecification request = RestAssured.given();

		String payload = "{" + "username" + ":" + "TestUser" + "," + "password" + ":" + "1234567" + "}";

		request.header("Content-Type", ContentType.JSON);

		Response responseFromGeneratedToken = request.body(payload).post("/auth/login");
		responseFromGeneratedToken.prettyPrint();

		String jsonString = responseFromGeneratedToken.getBody().asString();
		String generatedToken = JsonPath.from(jsonString).get("accessToken");

		String postCharacter = "{" + "name" + ":" + "Test Character" + "," + "age: 666" + "," + "weight: 40.3" + ","
				+ "history:" + "Test history" + "}";

		Response addCharacterResponse = request
				.header("Authorization", "Bearer " + generatedToken)
				.contentType("multipart/form-data")
				.multiPart("character", postCharacter)
				.multiPart("img", new File("../image/test-img.jpg"))
				.when()
				.post("/characters");

		Assertions.assertEquals(200, addCharacterResponse.getStatusCode());

		addCharacterResponse.prettyPrint();

	}

}
