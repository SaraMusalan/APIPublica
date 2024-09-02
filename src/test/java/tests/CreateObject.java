package tests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class CreateObject {

    @Test
            public void createObject(){

        File postBody = new File("src/main/resources/createObject.json");  // lee la ifo de este path

        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .header("Content-Type", "application/json")   // Pide el tipo de contenido que vamos a enviar en la peticion, en la primera llave va el nombre del header y en la segunda el valor
                .body(postBody);   //incluir el archivo donde esta el cuerpo del registro

        Response response =request
                .when()
                .post();

        response.prettyPrint();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        //id creado ff80818190966d7f01909d52838b1527
    }
}
