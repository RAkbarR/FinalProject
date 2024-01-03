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
@And("hit API to get list data") //Method when hit API, will get data list
    public void HitApiToGetListData(){
    apiPage.HitApi();
}
    @Then("verification status code must be {int}") // Method to get status code from each step
    public void VerificationStatus200(int status_code){
        apiPage.VerifStatus(status_code);
    }


    @Then("verification data should not be null") //To verify that the data is not null
    public void DataNotNull(){
        apiPage.DataNotNull();
    }

   // @Then("verification data for specific user should not be null")
    //public void verificationDataForSpecificUserShouldNotBeNull() {
      //  apiPage.DataNotNullSpecific();
    //}

    @Then("validate response JSON with JSONSchema {string}") //To get JSON data using JSONSchema
    public void validateResponseJSONWithJSONSchema(String filename) {
        apiPage.ValidateJsonWithJsonSchema(filename);
    }

    @And("hit API to post create user") //Method when hit API, will create a new user on the list
    public void hitAPIToPostCreateUser() {
        apiPage.hitApiPostCreateUser();
    }

    @Then("validate response body to post new user")
    public void validateResponseBodyToPostNewUser() {
    apiPage.validateResponseBodyToCreateNewUser();
    }

    @And("hit API to delete user") //Method when hit API, will delete a user data from the list
    public void hitAPIToDeleteUser() {
    apiPage.hitApiDeleteUser();
    }

    @And("hit API to update data") //Method when hit API, will update user data
    public void hitAPIToUpdateData() {
    apiPage.hitApiUpdateUser();
    }

    @Then("validate response body to update user")
    public void validateResponseBodyToUpdateUser() {
        apiPage.validationResponseBodyUpdateUser();
    }

    @And("input bearer token") //Remind user to use bearer token
    public void inputBearerToken() {
    apiPage.inputBearerToken();
    }

    @And("select RAW on menu body")
    public void selectRAWOnMenuBody() {
        apiPage.selectBodyRaw();
    }
    @And("select JSON")
    public void selectJSON() {
        apiPage.selectJSON();
    }
}

