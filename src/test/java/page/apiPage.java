package page;

import helper.Utility;
import helper.endpoint;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import static helper.Models.getListUser;
import static helper.Models.postCreateUser;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;


public class apiPage {

    String setURL;
    Response res;
    public void prepareURL(String url){
        switch (url){
            case "GET_LIST_USER" :
                setURL = endpoint.GET_LIST_USER;
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

    public void ValidateJsonWithJsonSchema(String filename){
        File JSONfile = Utility.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONfile));
    }

    public void hitApiPostCreateUser(){
        res = postCreateUser(setURL);
        System.out.println(res.getBody().asString());
    }
}
