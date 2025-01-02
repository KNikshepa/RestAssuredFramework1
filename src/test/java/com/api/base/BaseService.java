package com.api.base;

import com.api.models.requests.LoginRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

	private static final String BASE_URL="http://64.227.160.186:8080";
	private RequestSpecification requestSpec;
	
	public BaseService()
	{
		requestSpec=RestAssured.given()
				.baseUri(BASE_URL);
	}
	
	protected Response postRequest(Object loginRequest,String endpoint)
	{
		return requestSpec.contentType(ContentType.JSON).body(loginRequest).post(endpoint);
	}
}