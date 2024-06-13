package stepDefinitions;

import com.github.javafaker.Faker;
import endpoints.APIResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pojo.User;
import testData.TestDataBuild;
import utils.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

/*
This class houses the java code that glues to the steps in the feature file
 */
public class UserStepDefinitions extends Utils {

    RequestSpecification res;
    TestDataBuild testDataBuild = new TestDataBuild();
    Response response;
    static String userName;
    static User addUserPayload;

    @Given("Add User Payload")
    public void add_user_payload() throws IOException {
        addUserPayload = testDataBuild.addUserPayload();
        res = given().spec(requestSpecification()).body(addUserPayload);
        userName = addUserPayload.getUsername();
    }

    @Given("Get User Payload")
    @Given("Delete User Payload")
    public void get_user_payload() throws IOException {
        res = given().spec(requestSpecification()).pathParam("username", userName);
    }

    @Given("Update User Payload")
    public void update_user_payload() throws IOException {
        addUserPayload.setFirstName(Faker.instance().name().firstName());
        res = given().spec(requestSpecification()).pathParam("username", userName).body(addUserPayload);
    }

    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) {
        APIResources resourceAPI = APIResources.valueOf(resource);

        if(method.equalsIgnoreCase("POST")) {
            response = res.when().post(resourceAPI.getResource());
        }
        else if(method.equalsIgnoreCase("GET")) {
            response = res.when().get(resourceAPI.getResource());
        }
        else if(method.equalsIgnoreCase("PUT")) {
            response = res.when().put(resourceAPI.getResource());
        }
        else if(method.equalsIgnoreCase("DELETE")) {
            response = res.when().delete(resourceAPI.getResource());
        }

    }
    @Then("the API call is successful with status code {int}")
    public void the_api_call_is_successful_with_status_code(Integer statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }
}
