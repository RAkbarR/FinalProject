package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import page.apiPage;

public class apiStep {
    page.apiPage apiPage;


    public apiStep(){
        this.apiPage = new apiPage();
    }

@Given("prepare valid url {string}")
    public void PrepareUrlGetValidData(String url){
    apiPage.prepareURL(url);
}
@And("hit API to get list data")
    public void HitApiToGetListData(){
    apiPage.HitApi();
}
    @Then("verification status code must be {int}")
    public void VerificationStatus200(int status_code){
        apiPage.VerifStatus(status_code);
    }


    @Then("verification data should not be null")
    public void DataNotNull(){
        apiPage.DataNotNull();
    }

    @Then("validate response JSON with JSONSchema {string}")
    public void validateResponseJSONWithJSONSchema(String filename) {
        apiPage.ValidateJsonWithJsonSchema(filename);
    }

    @And("hit API to post create user")
    public void hitAPIToPostCreateUser() {
        apiPage.hitApiPostCreateUser();
    }

    @Then("validate response body to post new user")
    public void validateResponseBodyToPostNewUser() {
    apiPage.validateResponseBodyToCreateNewUser();
    }

    @And("hit API to delete user")
    public void hitAPIToDeleteUser() {
    apiPage.hitApiDeleteUser();
    }

    @And("hit API to update data")
    public void hitAPIToUpdateData() {
    apiPage.hitApiUpdateUser();
    }

    @Then("validate response body to update user")
    public void validateResponseBodyToUpdateUser() {
        apiPage.validationResponseBodyUpdateUser();
    }
}

