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
import java.io.File;
import java.io.IOException;
import misc.petDojo;


public class Uploadimage {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    private static final String BASE_PATH = "/pet/";
    private static Response response;

    // Uploading pet image
    @Test (priority = 1)
    @Given("I want to execute uploadImage endpoint")
    public void execute(){
        RestAssured.baseURI = BASE_URL;

    }

    @When("I submit the POST request with pet image")
    public void submit() throws IOException {
        File image = new File("src/test/java/model/pet_1.jpeg");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json", "multipart/form-data");
        response = request.multiPart(image).post(BASE_PATH + petDojo.id + "/uploadImage");

    }

    @Then("I should get 200 success status code successful operation")
    public void  status(){
        ResponseBody body = response.getBody();
        int statuscode = response.getStatusCode();
        System.out.println(statuscode);
        System.out.println("Response body for image is: " + body.asString());
        Assert.assertEquals(statuscode, 200);

    }


}
