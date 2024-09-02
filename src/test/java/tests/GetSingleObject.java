package tests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetSingleObject {

    @Test
    public void getSingleObject(){
        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects");

        Response response =request
                .when()
                .get("/7");

        response.prettyPrint();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
