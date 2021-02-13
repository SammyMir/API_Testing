package apitests;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static       org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLOutput;

public class GETALLUSERSTEST {

    @BeforeClass
    public static void setUp(){

        RestAssured.baseURI="https://reqres.in/api";
    }

    @Test
    public void  getallusers() {



          //https://reqres.in/api/users?page=2

//        RestAssured.baseURI="https://reqres.in/api";
//        given().get( "https://reqres.in/api/users?page=2")
//        .then()
//        .statusCode(200);
       }

        @Test
        public void checkStatusCode(){

        Response response= RestAssured.get("https://reqres.in/api/users?page=2");
        //response.prettyPrint();
        String resString=response.asString();
        System.out.println(resString);
        //System.out.println(resString.contains("page"));

        int statusCode=response.statusCode();
        Assert.assertEquals(statusCode, 200);

    }

    @Test
    public void headerTest(){
        Response res=RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(res.headers());
        String conType=res.header("Content-Type");
        //String age=res.header("Age");
        Assert.assertEquals("application/json; charset=utf-8", conType);
        //Assert.assertEquals("4285", age);

    }
    @Test
    public void statusLane() {

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        String statusLine = response.statusLine();
        System.out.println(statusLine);
        //Assert.assertEquals("");

        Assert.assertEquals("HTTP/1.1 200 OK", statusLine);

    }

    @Test
    public void testPage(){
        Response response=RestAssured.get("/users?page=2");
        response.prettyPrint();
        String page=response.getBody().asString();
        Assert.assertTrue(page.contains("page"));

    }


    }

