package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.Utility.generateRandomEmail;

public class Models {
    private static RequestSpecification request;
    public static void setupHeaders(){
        request = RestAssured.given()
                .header("Content-Type","application/json")
                .header("Accept", "application/json")
                .header("Authorization", " Bearer 10eeef75ac2df855613fb58b310d2a1dded38fb9a7a260cc15ef87e52930c767");
    }
    public static Response getListUser(String endpoint){
        System.out.println(" endpoint yang di lempar : " + endpoint);
        setupHeaders();
        return request.when().get(endpoint);
    }

    public static Response postCreateUser (String endpoint){
        String name = "Rizky Ramadhan";
        String gender = "male";
        String email = generateRandomEmail();
        String status = "active";
        JSONObject payLoad = new JSONObject();
        payLoad.put("name", name);
        payLoad.put("gender", gender);
        payLoad.put("email", email);
        payLoad.put("status", status);

        setupHeaders();
        return request.body(payLoad.toString()).when().post(endpoint);
    }
}
