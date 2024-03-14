package pages;

import helper.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;


public class ApiPage {

    //logic semuanya dilakukan disini dan helper. tidak boleh di step , karena PMO

    String setURL;

    Response res;

    public void prepareURLpercobaan() {
        System.out.println("hello prepare URL");
    }

    public void prepareUrlFor(String url) {
        switch (url) {
            case "GET_LIST_USERS":
                setURL = Endpoint.GET_LIST_USERS;
                break;
            case "CREATE_NEW_USERS":
                setURL = Endpoint.CREATE_NEW_USERS;
                break;
            case "DELETE_USERS":
                setURL = Endpoint.DELETE_USERS;
                break;
            case "POST_USERS":
                setURL = Endpoint.POST_USERS;
                break;
            case "PATCH_USERS":
                setURL = Endpoint.PATCH_USERS;
                break;
            case "PUT_USERS":
                setURL = Endpoint.PUT_USERS;
                break;
            default:
                System.out.println("Input right URL");
        }
//        System.out.println("endpoint yang di pakai adalah = " + setURL);
    }


    public void hitGetAPIGetListUser() {
        res = Models.getListUsers(setURL);
        System.out.println(res.getBody().asString());
    }


    public void validationStatusCodeIsEquals(int statusCode) {
        assertThat(res.statusCode()).isEqualTo(statusCode);
    }


    public void validationResponseBodyGetListUsers() {
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("female","male");
        assertThat(status.get(0)).isIn("active","inactive");

    }


    public void validationResponseJsonWithJSONSchema(String fileName) {
        File JSONFile = Utility.getJSONSchemaFile(fileName);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }
}
