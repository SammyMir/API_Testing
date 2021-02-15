package apitests;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

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


    @Test
 public void validateSingleData(){
        given().pathParam("id",3).get("/users/{id}").
                then().
                body("data.id",equalTo(3)).and().
                body("data.email",equalTo("emma.wong@reqres.in")).and().
                body("data.first_name",equalTo("Emma")).and().
                body("data.last_name",equalTo("Wong"));

}

    @Test
    public void createUser(){

        Map<String,Object> data=new HashMap<>();

        data.put("name","Adam");
        data.put("job","truck driver");

        JSONObject resBody= new JSONObject(data);
        given().header("Content-type","application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).body(resBody.toJSONString()).
                when().post("/users").
                then().statusCode(201).log().all();

  }
    @Test
    public void updateUser(){
         JSONObject resData=new JSONObject();
         resData.put("name", "kevin de borne");
         resData.put("job", "football player");
        given().header("Content-type","application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(resData.toJSONString()).
                when().put("/users/7").
                then().statusCode(200).and().
                body("name", equalTo("kevin de borne")).and().body("job",equalTo("football player"));

    }

    @Test
    public void deleteUser(){
        given().delete("/users/7").then().statusCode(204).and().statusLine("HTTP/1.1 204 No Content").and().
                header("Content-Length",equalTo("0")).and().
                header("X-Powered-By",equalTo("Express"));

    }
}
