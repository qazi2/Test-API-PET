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

import java.io.IOException;
import misc.petDojo;

public class UpdatePet {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    private static final String BASE_PATH = "/pet";
    private static Response response;

    // Update existing pet
    @Test(priority = 1)
    @Given("I want to execute update existing pet")
    public void execute(){
        RestAssured.baseURI = BASE_URL;

    }

    @When("I submit the PUT request of update an existing pet")
    public void submit() throws IOException {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.body(petDojo.body).put(BASE_PATH);

    }

    @Then("I should get 200 status")
    public void status(){
        ResponseBody body = response.getBody();
        int statuscode = response.getStatusCode();
        System.out.println(statuscode);
        System.out.println("Response body is: " + body.asString());
        Assert.assertEquals(statuscode, 200);

    }

}

