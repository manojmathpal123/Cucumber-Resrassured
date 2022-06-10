
import io.restassured.RestAssured;


import java.io.IOException;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Demo {

    @Test
    public static void main(String args[]) throws IOException {

        RestAssured.baseURI= "https://rahulshettyacademy.com";
        String response = given().log().all().queryParam("key","qaclick123").headers("Content-Type","application/json")
                .body(new String(Files.readAllBytes(Paths.get("/home/manoj/Documents/AddPlace.json")))).when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope", equalTo("APP"))
                .header("Server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();


        //System.out.println(response);
        JsonPath js = new JsonPath(response); //for parsing json
        String placeid = js.getString("place_id");
        System.out.println(placeid);


        //update place
        String address = "70 winter walk, USA";
        given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
                .body("{\n"
                        + "\"place_id\":\""+placeid+"\",\n"
                        + "\"address\":\""+address+"\",\n"
                        + "\"key\":\"qaclick123\"\n"
                        + "}\n"
                        + " ").when().put("/maps/api/place/update/json").then().assertThat().log().all().statusCode(200)
                .body("msg", equalTo("Address successfully updated"));


        //get details

        given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
                .when().get("/maps/api/place/get/json").then().assertThat().log().all().statusCode(200)
                .body("address", equalTo(address));

        //otherway to get details

        String Getplace = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
                .when().get("/maps/api/place/get/json").then().assertThat().log().all().statusCode(200)
                .extract().response().asString();
        JsonPath js1 = new JsonPath(Getplace);
        String getaddress = js1.getString("address");
        System.out.println(getaddress);
        Assert.assertEquals(getaddress, address);

        // delete api data

        given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
                .body("{\n"
                        + "\"place_id\":\""+placeid+"\",\n"
                        + "}\n"
                        + " ").when().post("/maps/api/place/delete/json").then().assertThat().log().all().statusCode(200);







    }
}
