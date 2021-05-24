package Stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import misc.petDojo;

public class GetpetbyID {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    private static final String BASE_PATH = "/pet/";
    private static final String WRONG_ID = "/pet/92231275161222211090";
    private static Response response;

    // Finding pet by id
    @Test(priority = 1)
    @Given("I want to execute find pet by ID endpoint")
    public void execute(){
        RestAssured.baseURI = BASE_URL;

    }

    @When("I submit the GET request with pet ID")
    public void submit() {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.get(BASE_PATH + petDojo.id);

    }

    @Then("I should get 200 success status code with pet details")
    public void  status(){
        ResponseBody body = response.getBody();
        int statuscode = response.getStatusCode();
        System.out.println(statuscode);
        System.out.println("Pet details: " + body.asString());
        Assert.assertEquals(statuscode, 200);

    }

// Negative test case
    @Test(priority = 2)
    @Given("I want to execute find pet by wrong ID")
    public void execute_invalid(){
        RestAssured.baseURI = BASE_URL;

    }

    @When("I submit the GET request with wrong pet ID")
    public void submit_invalid() {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.get(WRONG_ID);

    }

    @Then("I should get 404 status code pet not found")
    public void  status_invalid(){
        ResponseBody body = response.getBody();
        int statuscode = response.getStatusCode();
        System.out.println(statuscode);
        System.out.println("Response: " + body.asString());
        Assert.assertEquals(statuscode, 404);

    }


}
