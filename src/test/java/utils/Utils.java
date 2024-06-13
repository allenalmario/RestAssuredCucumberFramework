package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {

    public static RequestSpecification req;

    /*
    This method returns a request specification object will all necessary given criteria for
    Swagger User API
    if one already exists, it will just pass the current object
     */
    public RequestSpecification requestSpecification() throws IOException {

        if (req==null) {
            // this will create a file called logging.txt with all the test run information
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
                req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUri"))
                        .addFilter(RequestLoggingFilter.logRequestTo(log))
                        .addFilter(ResponseLoggingFilter.logResponseTo(log))
                        .setContentType(ContentType.JSON).build();

            return req;
        }
        return req;
    }

    /*
    This method returns a value from the global.properties file
    Parameter: name of key of the value wanted in the properties file
    Return value: the value of the passed key name
    */
    public String getGlobalValue(String key) throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/global.properties");
        prop.load(fis);
        return prop.getProperty(key);

    }

    /*
    This method takes a response object and key
    it extracts information from a json body response using the key provided and
    returns the value found from that key
     */
    public String getJsonPath(Response response, String key) {

        String resp = response.asString();
        JsonPath jsonPath = new JsonPath(resp);
        return jsonPath.get(key).toString();

    }

}
