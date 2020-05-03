package ApiWeb_tests;

import BaseTests.ApiWeb_BaseTest;
import dataentyties.UserData;
import gherkin.lexer.Sr_cyrl;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.net.http.HttpResponse;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserTests extends ApiWeb_BaseTest.BaseTest_WebAPI {


    @Test
    public void getAllEnums() {
        given().
            spec(requestSpec).
        when().
            get("/enums").
        then().
            assertThat().body("quizStepTypes[0].'label'", equalTo("GENDER"));
    }

    @Test
    public void shouldCreateNewUser() {

        HashMap<String,String> myLinkedHashMap = new HashMap<>();
        myLinkedHashMap.put("email","test123@gmail.com");

        given().
                spec(requestSpec).
                contentType(ContentType.JSON).with().body(myLinkedHashMap).
        when().
                post("/user").
                then().assertThat().
                body("email", equalTo("test123@gmail.com")).
                body("$", hasKey("uuid")).log().all();
    }

    @Test
    public void getExistingUser() {
        given().
                spec(requestSpec).
        when().
                get("/user/order/896d07ec-dd4c-4c09-8d78-d6d8c0b065a7").
        then().
                assertThat().
                statusCode(HttpStatus.SC_OK).
                body("$", hasKey("uuid")).
                body("email", equalTo("kharynairyna@gmail.com"));
    }


    /*
    @Test (dataProvider = "userPaidMealPlan")
    public void shouldGetUserWithDataProvider(String email, String order_uuid){
        given().
                spec(requestSpec).
                pathParam("email", email).
                when().
                get("/user/order/{order_uuid}").
                then().
                assertThat().body("email'", equalTo(email)).
                body("uuid", equalTo(order_uuid));
    }
/*
    @Test (dataProvider = "user", dataProviderClass = UserData.class)
    public void trywithData(String email, String order_uuid){
        given().
                spec(requestSpec).
                pathParam(String order_uuid).
        when().
                get("/user/order/{order_uuid}").
        then().
                assertThat().body("email'", equalTo(String email)).
                body("uuid", equalTo(String order_uuid));
    }
    */
}