package stepdefinition;

import static io.restassured.RestAssured.given;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import POJO.AddPlace;
import POJO.Location;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuild;
import resources.utils;

//@RunWith(Cucumber.class)
public class Stepdefinition extends utils {
	
	RequestSpecification res;
	ResponseSpecification re;
	Response response;
	TestDataBuild data = new TestDataBuild();
	
	
   /* @Given("^Add Place Payload$")
    public void add_place_payload() throws Throwable {
       // throw new PendingException();*/
    	
	@Given("^Add Place Payload with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void add_place_payload_with_something_something_something(String name, String language, String address) throws Throwable {
        //throw new PendingException();
    
		
		re = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		res = given().spec(requestSpecificatio()).body(data.addPlacePayload(name,language,address));
    	
    }

    @When("^user calls \"([^\"]*)\" with post http request$")
    public void user_calls_something_with_post_http_request(String strArg1) throws Throwable {
      //  throw new PendingException();
    	
    	
    	response = res.when().post("/maps/api/place/add/json")
    			.then().spec(re).extract().response();
    }

    @Then("^the API call is successfull with status code 200$")
    public void the_api_call_is_successfull_with_status_code_200() throws Throwable {
      //  throw new PendingException();
    	
    	
    	assertEquals(response.statusCode(),200);
    	
    	
    }

    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
    public void something_in_response_body_is_something(String keyValue, String ExpectedValue) throws Throwable {
       // throw new PendingException();
    	
    	String ResponseString = response.asString();
    	JsonPath js = new JsonPath(ResponseString);
    	assertEquals(js.get(keyValue).toString(), ExpectedValue);
    	
    	
    	
    }

}