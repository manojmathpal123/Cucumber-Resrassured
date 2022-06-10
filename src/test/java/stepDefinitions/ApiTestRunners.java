package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ApiTestRunners {

    private final String BASE_URL = "https://rahulshettyacademy.com";
    private Response response;
    static String place_id;


    @Given("post call with the {string} and payload.")
    public void post_call_with_the_and_payload(String url) throws URISyntaxException, IOException {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification requestSpecification = RestAssured.given().queryParam("key", "qaclick123").headers("Content-Type","application/json").body(new String(Files.readAllBytes(Paths.get("/home/manoj/Documents/AddPlace.json"))));
        response = requestSpecification.when().post(new URI(url));
        String res = response.then().extract().asString();
        JsonPath js = new JsonPath(res); //for parsing json
        place_id = js.getString("place_id");
        System.out.println(place_id);
    }

    @Given("put call with the {string} and payload.")
    public void put_call_with_the_and_payload(String url) throws URISyntaxException{
        String address = "70 winter walk, USA";
        RestAssured.baseURI = BASE_URL;
        RequestSpecification requestSpecification = RestAssured.given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
                .body("{\n"
                        + "\"place_id\":\""+place_id+"\",\n"
                        + "\"address\":\""+address+"\",\n"
                        + "\"key\":\"qaclick123\"\n"
                        + "}\n"
                        + " ");
        response = requestSpecification.when().put(new URI(url));
    }

    @Given("get call the {string}")
    public void get_call_the(String url) throws URISyntaxException {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification requestSpecification = RestAssured.given().queryParam("key", "qaclick123").queryParam("place_id", place_id);
        response = requestSpecification.when().get(new URI(url));
    }

    @Given("delete call with the {string}.")
    public void delete_call_with_the(String url) throws URISyntaxException{
        RestAssured.baseURI = BASE_URL;
        RequestSpecification requestSpecification = RestAssured.given().queryParam("key", "qaclick123").header("Content-Type","application/json")
                .body("{\n"
                        + "\"place_id\":\""+place_id+"\",\n"
                        + "}\n"
                        + " ");
        response = requestSpecification.when().post(new URI(url));
    }

    @Then("response is {string}")
    public void response_is(String statuscode) {
        int actulresponsecode = response.then().extract().statusCode();

        Assert.assertEquals(statuscode,actulresponsecode+"");
    }
}
