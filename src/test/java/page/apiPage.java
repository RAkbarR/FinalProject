package page;

import helper.Utility;
import helper.endpoint;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import com.google.common.collect.Lists;
import com.google.common.base.Functions;

import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;


public class apiPage {

    String setURL, global_id;
    Response res;
    public void prepareURL(String url){
        switch (url){
            case "GET_LIST_USER" :
                setURL = endpoint.GET_LIST_USER;
                break;
            case "GET_LIST_USER_SPECIFIC" :
                setURL = endpoint.GET_LIST_USER_SPECIFIC;
                break;
            case "CREATE_NEW_USER" :
                setURL = endpoint.CREATE_NEW_USER;
                break;
            case "DELETE_USER" :
                setURL = endpoint.DELETE_USER;
                break;
            default:
                System.out.println("input right url");
        }
        System.out.println("endpoint yang digunakan " + setURL);
    }
    public void HitApi(){
        res = getListUser(setURL);
        System.out.println(res.getBody().asString());
    }
    public void VerifStatus(int status_code){
    assertThat(res.statusCode()).isEqualTo(status_code);
        System.out.println("Status code : " + status_code);
    }

    public void DataNotNull(){
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("female", "male");
        assertThat(status.get(0)).isIn("active", "inactive");
    }

    public void DataNotNullSpecific(){
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("female", "male");
        assertThat(status.get(0)).isIn("active", "inactive");

        List<Object> strings = Lists.transform(id, Functions.toStringFunction());
    }

    public void ValidateJsonWithJsonSchema(String filename){
        File JSONfile = Utility.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONfile));
    }

    public void hitApiPostCreateUser(){
        //Hit Post Button
        res = postCreateUser(setURL);
        System.out.println(res.getBody().asString());
    }

    public void validateResponseBodyToCreateNewUser(){
        JsonPath JsonPathEvaluator = res.jsonPath();
        Integer id = JsonPathEvaluator.get("id");
        String name = JsonPathEvaluator.get("name");
        String email = JsonPathEvaluator.get("email");
        String gender = JsonPathEvaluator.get("gender");
        String status = JsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");

        global_id = Integer.toString(id) ;

    }

    public void hitApiDeleteUser(){
        res = deleteUser(setURL, global_id);
    }

    public void hitApiUpdateUser(){
        res = updateUser(setURL, global_id);
    }

    public void validationResponseBodyUpdateUser(){
        JsonPath JsonPathEvaluator = res.jsonPath();
        Integer id = JsonPathEvaluator.get("id");
        String name = JsonPathEvaluator.get("name");
        String email = JsonPathEvaluator.get("email");
        String gender = JsonPathEvaluator.get("gender");
        String status = JsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");

    }

    public void inputBearerToken() {
        System.out.println("bearer token : 10eeef75ac2df855613fb58b310d2a1dded38fb9a7a260cc15ef87e52930c767");
    }

    public void selectBodyRaw (){
        System.out.println("Please select RAW on body menu");
    }

    public void selectJSON (){
        System.out.println("Please select JSON");
    }
}
