package BaseTests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

public final class ApiWeb_BaseTest {

   // public static final String enams = "/users/{id}";

    public static class BaseTest_WebAPI {

        public static RequestSpecification requestSpec;
        public static ResponseSpecification responseSpec;


        @BeforeClass
        public static void createRequestSpecification() {
            requestSpec = new RequestSpecBuilder().
                    setBaseUri("https://bodyfit2.loc/api/v1.0/").
                    addHeader("Authorization", "Bearer PUNu5kfJmLmgwnCfhViqMq7megTYoWNFtYe05OTJsd7GbqhBOw").
                    setRelaxedHTTPSValidation().
                    build();
        }

        @BeforeClass
        public static void createResponseSpecification() {

            responseSpec = new ResponseSpecBuilder().
                    expectStatusCode(200).
                    expectContentType(ContentType.JSON).
                    build();
        }
    }
}
