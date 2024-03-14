package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPage;

public class ApiStep {

    ApiPage apiPage;

    public ApiStep() {
        this.apiPage = new ApiPage();
    }


    @Given("prepare url for {string}")
    public void prepareUrlFor(String arg0) {
        apiPage.prepareUrlFor(arg0);
    }

    @And("hit get API get list user")
    public void hitGetAPIGetListUser() {
        apiPage.hitGetAPIGetListUser();

    }

    @Then("validation status code is equals {int}")
    public void validationStatusCodeIsEquals(int statusCode) {
        apiPage.validationStatusCodeIsEquals(statusCode);
    }


    @Then("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        apiPage.validationResponseBodyGetListUsers();

    }


    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String filename) {
        apiPage.validationResponseJsonWithJSONSchema(filename);
    }
}
