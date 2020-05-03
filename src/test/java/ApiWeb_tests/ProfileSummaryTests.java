package ApiWeb_tests;

import BaseTests.ApiWeb_BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class ProfileSummaryTests extends ApiWeb_BaseTest.BaseTest_WebAPI {


    /*
    Keremchyk, I need your help with how should I create a POST request for this payload. I don't understand what data structure should I pick.
    Below in the test you can see how I did a payload with a small request load.

   I need to send this payload to /profile-summary endpoint
    { "choices": [
   {"choiceId": 15,
     "choiceValue": 1.00
   },  {
     "choiceId": 72,
     "choiceValue": 72
   },
    {
     "choiceId": 78,
     "choiceValue": 78
   },
    {
     "choiceId": 6,
     "choiceValue": 100
   },
   {
     "choiceId": 56,
     "choiceValue": 1.0
   },
   {
     "choiceId": 1,
     "choiceValue": 18
   },
     {
     "choiceId": 11,
     "choiceValue": 5
   },
   {
     "choiceId": 2,
     "choiceValue": 180
   },
   {
     "choiceId": 5,
     "choiceValue": 110
   },
   {
     "choiceId": 36,
     "choiceValue": 36
   },
   {
     "choiceId": 42,
     "choiceValue": 42
   },
   {
     "choiceId": 51,
     "choiceValue": 51
   },
   {
      "choiceId": 52,
     "choiceValue": 52
   },
     {
      "choiceId": 45,
     "choiceValue": 45
   },
     {
      "choiceId": 40,
     "choiceValue": 40
   },
     {
      "choiceId": 57,
     "choiceValue": 57
   }
 ],
  "email": "tetiana.kharyna@gmail.com",
  "genderChoiceType": 5,
  "measureUnit": 1,
  "quizStepGroupId": 1
}
     */
    @Test
    public void createUser() {

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
    public void createProfile() {

    }
}
