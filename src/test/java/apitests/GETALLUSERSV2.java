package apitests;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class GETALLUSERSV2 {

    @BeforeClass
    public static void setUp(){
        baseURI="https://reqres.in/api";

    }
    @Test
    public void validateData(){
        given().get("/users?page=2").
        then().
                statusCode(200).
                and().
                body("page",equalTo(2)).
                body("per_page",equalTo(6)).
                body("total",equalTo(12)).
                and().body("total_pages",equalTo(2));




    }

}
