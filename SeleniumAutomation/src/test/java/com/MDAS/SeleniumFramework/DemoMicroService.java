//package com.MDAS.SeleniumFramework;
//
//import org.testng.annotations.Test;
//
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//
//public class DemoMicroService{
//
//	@Test
//public void GetWeatherDetails()
// {
// // Specify the base URL to the RESTful web service
// RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
// 
// // Get the RequestSpecification of the request that you want to sent
// // to the server. The server is specified by the BaseURI that we have
// // specified in the above step.
// RequestSpecification httpRequest = RestAssured.given();
// 
// // Make a GET request call directly by using RequestSpecification.get() method.
// // Make sure you specify the resource name.
// Response response = httpRequest.get("/Hyderabad");
// 
// // Response.asString method will directly return the content of the body
// // as String.
// System.out.println("Response Body is =>  " + response.asString());
// System.out.println("Response Body is now =>  " + response.jsonPath().get("City"));
// 
// //JsonPath jsonPathEvaluator = response.jsonPath();
// 
// // Then simply query the JsonPath object to get a String value of the node
// // specified by JsonPath: City (Note: You should not put $. in the Java code)
// //String city = jsonPathEvaluator.get("City");
// 
// //Assert.assertEquals(bodyAsString.toLowerCase().contains("hyderabad")
////return response;
// 
// 
// }
//}