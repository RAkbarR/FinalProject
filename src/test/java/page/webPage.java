package page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import static helper.Utility.driver;

public class webPage {
    //Login page
    By input_username = By.name("username");
    By input_password = By.name("password");
    By btn_login = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
    By sidenav_my_indo = By.xpath("//*[text() = 'My Info']");

    //Homepage
    By admin_toogle = By.xpath(("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a"));

    //Admin Page
    By insert_admin_username = By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]");
    By btn_admin_search = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");
    By show_record_found = By.xpath("//*[text()=\"(1) Record Found\"]");
    By show_record_not_found = By.xpath("//*[text()=\"No Records Found\"]");

    //Admin Update
    By admin_update = By.xpath("//button[@class=\"oxd-icon-button oxd-table-cell-action-space\"][2]");
    By admin_update_name = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input");
    By btn_save_admin_update = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]");

    public void goToLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        //WebDriverManager.chromedriver().create();
    }

    public void inputUserName(String username) {
        driver.findElement(input_username).sendKeys(username);
    }

    public void inputPassword(String password) {
        driver.findElement(input_password).sendKeys(password);
    }

    public void btnLoginClick() {
        driver.findElement(btn_login).click();
    }

    public void assert_show_sidebar_info() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(sidenav_my_indo).isDisplayed();
    }

    public void adminToogleClick() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement((admin_toogle)).click();
    }

    public void insertAdminUsername(String adminusername) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(insert_admin_username).sendKeys(adminusername);
    }

    public void btnAdminSearch() {
        driver.findElement(btn_admin_search).click();
    }

    public void showAdminRecord() {
        driver.findElement(show_record_found).isDisplayed();
    }

    public void showAdminRecordNotFound() {
        driver.findElement(show_record_not_found).isDisplayed();
    }

    public void errTextShow(String errText) {
        driver.findElement(By.xpath("//*[text() = '" + errText + "']")).isDisplayed();
    }

    public void btnAdminUpdate(){
        driver.findElement(admin_update).click();
    }

    public void adminChangeName(String name){
        driver.findElement(admin_update_name).sendKeys(name);
    }

    public void saveAdminUpdate(){
        driver.findElement(btn_save_admin_update).click();
    }

}