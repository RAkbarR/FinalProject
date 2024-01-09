package StepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import page.webPage;

public class webStep {

    webPage webPage;

    public webStep(){
        this.webPage = new webPage();
    }

    @Given("User is on login page")
    public void userIsOnLoginPage(){
        webPage.goToLoginPage();
    }

    @And("User input username {string}")
    public void userInputUsername(String username) {
        webPage.inputUserName(username);
    }

    @And("User Input Password {string}")
    public void userInputPassword(String password) {
        webPage.inputPassword(password);
    }

    @And("User press button Login")
    public void userPressButtonLogin() {
        webPage.btnLoginClick();
    }


    @Then("user can see validation on side nav")
    public void userCanSeeValidationOnSideNav() throws InterruptedException {
        webPage.assert_show_sidebar_info();
    }

    @And("user click admin toogle menu")
    public void userClickAdminToogleMenu() throws InterruptedException {
        webPage.adminToogleClick();
    }

    @And("user input admin username {string}")
    public void userInputAdminUsername(String adminusername) throws InterruptedException {
        webPage.insertAdminUsername(adminusername);
    }
    @And("user press search button")
    public void userPressSearchButton() {
        webPage.btnAdminSearch();
    }

    @Then("user will see admin records")
    public void userWillSeeAdminRecords() {
        webPage.showAdminRecord();
    }

    @Then("user can see info text err {string}")
    public void userCanSeeInfoTextErr(String texterr) {
        webPage.errTextShow(texterr);
    }

    @Then("user will see no records")
    public void userWillSeeNoRecords() {
        webPage.showAdminRecordNotFound();
    }

    @And("user click icon update admin")
    public void userClickIconUpdateAdmin() {
        webPage.btnAdminUpdate();
    }

    @And("user change admin name {string}")
    public void userChangeAdminName(String name) {
        webPage.adminChangeName(name);
    }

    @Then("user click submit admin update")
    public void userClickSubmitAdminUpdate() {
        webPage.saveAdminUpdate();
    }
}
