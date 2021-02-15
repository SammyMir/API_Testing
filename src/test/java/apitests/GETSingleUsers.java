package apitests;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

public class GETSingleUsers {

    @BeforeClass
    public static void  setUp(){

        RestAssured.baseURI="https://reqres.in/api";
    }
    @Test
    public void validateSingleData(){
        given().get("/users/2").prettyPrint();
    }

}

