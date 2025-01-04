package com.api.base;

import com.api.filters.LoggingFilter;
import com.api.models.requests.LoginRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

	private static final String BASE_URL="http://64.227.160.186:8080";
	private RequestSpecification requestSpec;
	
	static {
		RestAssured.filters(new LoggingFilter());
	}
	
	public BaseService()
	{
		requestSpec=RestAssured.given()
				.baseUri(BASE_URL);
	}
	
	protected void setAuthToken(String token)
	{
		requestSpec.header("Authorization","Bearer "+token);
	}
	
	protected Response postRequest(Object loginRequest,String endPoint)
	{
		return requestSpec.contentType(ContentType.JSON).body(loginRequest).post(endPoint);
	}
	
	protected Response putRequest(Object updateRequest,String endPoint)
	{
		return requestSpec.contentType(ContentType.JSON).body(updateRequest).put(endPoint);
	}
	
	protected Response getRequest(String endPoint)
	{
		return requestSpec.get(endPoint);
		
	}
}
