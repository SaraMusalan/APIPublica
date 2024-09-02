package tests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class DeleteObject {

        @Test
        public void deleteObject() {
            File patchBody = new File("src/main/resources/deleteObject.json");

            RequestSpecification request = given()
                    .baseUri("https://api.restful-api.dev")
                    .basePath("/objects")
                    .header("Content-Type", "application/json")
                    .body(patchBody);

            Response response = request
                    .when()
                    .delete("ff80818190966d7f01909d52838b1527");

            response.prettyPrint();
            int statusCode = response.getStatusCode();
            Assert.assertEquals(statusCode, 200);
        }
}
