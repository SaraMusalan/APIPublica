package tests;

import com.sun.net.httpserver.Request;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class UpdatePartiallyObject {

    @Test
    public void updatePartiallyObject(){
        File patchBody = new File("src/main/resources/patchObject.json");

        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .header("Content-Type", "application/json")
                .body(patchBody);

        Response response =request
                .when()
                .patch("ff80818190966d7f01909d52838b1527");

        response.prettyPrint();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);


    }
}
