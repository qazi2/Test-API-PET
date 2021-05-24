package Stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import misc.petDojo;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class AddPet {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    private static final String BASE_PATH = "/pet";
    private static Response response;
    // reading data from json and send that as a string
    public String generateStringFromFile(String path) throws IOException {

        return new String(Files.readAllBytes(Paths.get(path)));

    }

    // Add a new pet to the store
    @Test (priority = 1)
    @Given("I want to execute pet endpoint")
    public void execute(){
        RestAssured.baseURI = BASE_URL;

    }

    @When("I submit the POST request")
    public void submit() throws IOException {
        String jsonBody = generateStringFromFile("src/test/java/model/pet.json");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.body(jsonBody).post(BASE_PATH);

    }

    @Then("I should get 200 success status code")
    public void  status(){
        ResponseBody body = response.getBody();
        petDojo.body = body.asString();
        petDojo.id = JsonPath.from(body.asString()).get("id").toString();
        int statuscode = response.getStatusCode();
        Assert.assertEquals(statuscode, 200);

    }

    //Verify if the user is able to add a pet with invalid input
    @Test (priority = 1)
    @Given("I want to execute pet endpoint with invalid input")
    public void execute_invalid(){
        RestAssured.baseURI = BASE_URL;

    }

    @When("I submit the POST request with invalid input")
    public void submit_invalid(){
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.body("{}").post(BASE_PATH);

    }

    @Then("I should get 405 invalid input status code")
    public void  status_405(){
        int statuscode = response.getStatusCode();
        Assert.assertEquals(statuscode, 405);

    }

}
