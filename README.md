# REST Assured with Java and Cucumber BDD API Test Automation Framework
## By Allen Almario - SDET

This is an API Test Automation Framework using REST Assured with Java and Cucumber BDD. It uses Cucumber/TestNG runner files to run the tests
and uses Extent Report to generate test result reports. It also utilizes GitHub actions for an easy "push of a button"
mechanism to run the automated tests and publish the test report on GitHub. Cucumber BDD allows for feature files that
have test cases written in a plain English (Given, When, Then) syntax called Gherkin Syntax. This allows for easy collaboration
with business stakeholders in the test automation process.

## Dependencies needed
- REST Assured
- Cucumber Java
- Cucumber TestNG
- Jackson Databind
- extentreports-cucumber7-adapter
- lombok
- Java Faker

## How to run this project

### GitHub Actions
- Go to Actions
- Click on the "REST Assured with Cucumber BDD Test Automation Run"
- Select Run workflow
- Ensure branch is set to "main"
- Click Run workflow

### Locally on Terminal/Command Prompt
Run the following:

```
mvn clean test
```

## Where are reports saved

### GitHub Page
https://allenalmario.github.io/RestAssuredCucumberFramework/

### Locally
After tests are executed, an Extent Report with test results should be saved in the directory
./target/cucumber-reports/extent.html

*This project was built with the guidance of the Udemy course "Rest API Testing (Automation) from Scratch-Rest Assured Java". [CLICK HERE](https://www.udemy.com/course/rest-api-automation-testing-rest-assured/) to check out the course.*