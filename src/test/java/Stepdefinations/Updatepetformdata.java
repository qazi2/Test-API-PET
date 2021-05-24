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


public class Updatepetformdata {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    private static final String BASE_PATH = "/pet/";
    private static Response response;

    // Updates a pet in the store with form data
    @Test(priority = 1)
    @Given("I want to execute update a pet with form data")
    public void execute() {
        RestAssured.baseURI = BASE_URL;

    }

    @When("I submit the POST request for update from form data")
    public void submit() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json", "application/x-www-form-urlencoded");
        response = request.body("name=Imdone&status=pending").post(BASE_PATH + petDojo.id);

    }

    @Then("I should get 200 status response")
    public void status() {
        ResponseBody body = response.getBody();
        int statuscode = response.getStatusCode();
        System.out.println(statuscode);
        System.out.println("Response body is: " + body.asString());
        Assert.assertEquals(statuscode, 200);

    }
// update pet with wrong status
    @Test(priority = 2)
    @Given("I want to execute update a pet with wrong status")
    public void execute_invalid() {
        RestAssured.baseURI = BASE_URL;

    }

    @When("I submit the POST request invalid for form")
    public void submit_invalid() {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json", "application/x-www-form-urlencoded");
        response = request.body("name=Imdone&status=nostatusatall").post(BASE_PATH + petDojo.id);

    }

    @Then("I should get 405 status")
    public void status_invalid() {
        ResponseBody body = response.getBody();
        int statuscode = response.getStatusCode();
        System.out.println(statuscode);
        System.out.println("Response body is: " + body.asString());
        Assert.assertEquals(statuscode, 405);

    }

}
