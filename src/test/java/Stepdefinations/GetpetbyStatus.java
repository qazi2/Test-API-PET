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

public class GetpetbyStatus {
    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    private static final String BASE_PATH_AVAILABLE = "/pet/findByStatus?status=available";
    private static final String BASE_PATH_PENDING = "/pet/findByStatus?status=pending";
    private static final String BASE_PATH_SOLD = "/pet/findByStatus?status=sold";
    private static final String INVALID_STATUS = "/pet/findByStatus?status=notiavailable";
    private static Response response;

    // Get pet by status available
    @Test(priority = 1)
    @Given("I want to execute findByStatus available endpoint")
    public void execute(){
        RestAssured.baseURI = BASE_URL;

    }

    @When("I submit the GET request with status available")
    public void sumbit() {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.get(BASE_PATH_AVAILABLE);

    }

    @Then("I should get 200 status with pet available")
    public void  status(){
        ResponseBody body = response.getBody();
        int statuscode = response.getStatusCode();
        System.out.println(statuscode);
        System.out.println("Pet details: " + body.asString());
        Assert.assertEquals(statuscode, 200);

    }

    // Negative test case invalid status value
    @Test(priority = 2)
    @Given("I want to execute get pets by invalid status")
    public void execute_invalid(){
        RestAssured.baseURI = BASE_URL;


    }

    @When("I submit the GET request with invalid status")
    public void submit_invalid() {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.get(INVALID_STATUS);

    }

    @Then("I should get 400 status with invalid status value")
    public void  status_invalid(){
        ResponseBody body = response.getBody();
        int statuscode = response.getStatusCode();
        System.out.println(statuscode);
        System.out.println("Response: " + body.asString());
        Assert.assertEquals(statuscode, 400);

    }

// Get pets by status pending
    @Test(priority = 1)
    @Given("I want to execute findByStatus by pending")
    public void execute_pending(){
        RestAssured.baseURI = BASE_URL;

    }

    @When("I submit the GET request with status pending")
    public void submit_pending() {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.get(BASE_PATH_PENDING);

    }

    @Then("I should get 200 status with pet in pending status")
    public void  status_pending(){
        ResponseBody body = response.getBody();
        int statuscode = response.getStatusCode();
        System.out.println(statuscode);
        System.out.println("Pet details: " + body.asString());
        Assert.assertEquals(statuscode, 200);

    }

//    Get pets by status sold
    @Test(priority = 1)
    @Given("I want to execute findByStatus by sold")
    public void execute_sold(){
        RestAssured.baseURI = BASE_URL;

    }

    @When("I submit the GET request with status sold")
    public void submit_sold() {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.get(BASE_PATH_SOLD);

    }

    @Then("I should get 200 status with pet in sold status")
    public void  status_sold(){
        ResponseBody body = response.getBody();
        int statuscode = response.getStatusCode();
        System.out.println(statuscode);
        System.out.println("Pet details: " + body.asString());
        Assert.assertEquals(statuscode, 200);

    }


}
