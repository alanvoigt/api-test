package br.ce.wcaquino.apitest;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class APiTest {
	@Test	
	public void setup() {
		RestAssured.baseURI = "http://localhost:8001/tasks/-backend";
	}
	
	@Test
	public void deveRetornarTarefas() {
		RestAssured.given()
		.when()
			.get("/todo")
		.then()
			.statusCode(200)
		;
	}
	

	@Test
	public void deveAdicionarTarefaComSucessos() {
		RestAssured.given()
			.body("{\"tasks\" \"Teste via API\", \"dueDate\": \"2020-12-01")
			.contentType(ContentType.JSON)
		.when()
			.get("/todo")
		.then()
			.statusCode(201)
		;
	}
}	
