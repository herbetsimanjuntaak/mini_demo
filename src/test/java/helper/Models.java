package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Models {
    //semua hit akan dijalankan dari sini
    //komunikasi dengan restassured untuk hit apapun yang ingin dilakukan

    private static RequestSpecification requestSpecification;

    public static void setUpHeaders(){
        requestSpecification = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer 2259048ef8b50ff36a730b1d6dcd5962cd3c9aa5210a7b4ca68b92c36d8abfc9");
    }

    public static Response getListUsers(String endpoint){
        System.out.println("Endpoint yang dilempar : "+endpoint);
        setUpHeaders();
        return requestSpecification.when().get(endpoint);
    }

}
