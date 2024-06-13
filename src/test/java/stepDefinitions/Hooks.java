package stepDefinitions;

import io.cucumber.java.Before;

import java.io.IOException;

import static stepDefinitions.UserStepDefinitions.userName;

public class Hooks {

    @Before("@DeleteUser or @GetUser or @UpdateUser")
    public void beforeScenario() throws IOException {
        UserStepDefinitions userStepDefinitions = new UserStepDefinitions();
        if(userName==null) {
            userStepDefinitions.add_user_payload();
            userStepDefinitions.user_calls_with_http_request("AddUserAPI", "POST");
        }
    }
}
