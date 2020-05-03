package dataentyties;

import org.testng.annotations.DataProvider;

import java.util.HashMap;

public class UserData {

   /*
   Keremchyk, I also really need your help with data parametrisation of my tests. My idea was to create different types of users with important data like age, curent_weight, target_weight, height, meal_plan_id, order_id
   So I could write easy smoke tests to make sure that GET endpoints gives back consistent data. I know that people user DataProvider annotations for this in Java. But I couldn't access saved data in test. You can see commented tests in UserTests.class
   */


    @DataProvider (name = "userPaidMealPlan")
     public Object[][] getUserWithPaidMealPlan() {
         HashMap<String, String> userWithPaidMealPlan = new HashMap<>();
         userWithPaidMealPlan.put("email", "kharynairyna@gmail.com");
         userWithPaidMealPlan.put("order_uuid", "896d07ec-dd4c-4c09-8d78-d6d8c0b065a7");
         userWithPaidMealPlan.put("order_id", "4281");
         userWithPaidMealPlan.put("age", "24 years" );
         userWithPaidMealPlan.put("gender", "FEMALE");
         userWithPaidMealPlan.put("user_uuid", "61090001-26df-468d-8c10-ae9dbe9beea4");
        return new Object[][]{
                {getUserWithPaidMealPlan()}
        };
     }

     @DataProvider(name = "user")
     public Object[][] getData(){
        Object[][] data = { {"kharynairyna@gmail.com","896d07ec-dd4c-4c09-8d78-d6d8c0b065a7" },{"blablabla@gmail.com", "de922533-0481-451c-990f-d0ab70938006"} };
        return data;
    }
}
