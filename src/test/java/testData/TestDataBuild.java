package testData;

import com.github.javafaker.Faker;
import pojo.User;

/*
This class creates the body of json from the pojo classes
and injects data
 */
public class TestDataBuild {

    // using faker class to inject dummy data to payload
    Faker faker = new Faker();

    // this method creates a json body for add user pojo with dummy data
    public User addUserPayload() {

        User addUser = new User();

        addUser.setId(faker.idNumber().hashCode());
        addUser.setUsername(faker.name().username());
        addUser.setFirstName(faker.name().firstName());
        addUser.setLastName(faker.name().lastName());
        addUser.setEmail(faker.internet().emailAddress());
        addUser.setPassword(faker.internet().password());
        addUser.setPhone(faker.phoneNumber().cellPhone());

        return addUser;

    }

}
