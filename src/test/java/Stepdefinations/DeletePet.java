package Stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import misc.petDojo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletePet {
    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    private static final String BASE_PATH = "/pet/";
    private static Response response;

    // Deleting pet
    @Test(priority = 1)
    @Given("I want to execute delete a pet endpoint")
    public void execute(){
        RestAssured.baseURI = BASE_URL;

    }

    @When("I submit the DELETE request")
    public void submit() {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.delete(BASE_PATH + petDojo.id);

    }

    @Then("I should get 200 status delete")
    public void  status(){
        ResponseBody body = response.getBody();
        int statuscode = response.getStatusCode();
        Assert.assertEquals(statuscode, 200);

    }

    // Negative test case Delete a pet which is already deleted
    @Test(priority = 2)
    @Given("I want to execute delete a pet already deleted")
    public void execute_invalid(){
        RestAssured.baseURI = BASE_URL;

    }

    @When("I submit the DELETE request for deleted pet")
    public void submit_invalid() {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.delete(BASE_PATH + petDojo.id);

    }

    @Then("I should get 404 status Pet not found")
    public void  status_invalid(){
        ResponseBody body = response.getBody();
        int statuscode = response.getStatusCode();
        Assert.assertEquals(statuscode, 404);

    }

}
