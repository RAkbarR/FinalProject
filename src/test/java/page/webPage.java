package page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import static helper.Utility.driver;

public class webPage {

    By input_username = By.name("username");
    By input_password = By.name("password");
    By btn_login = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
    By sidenav_my_indo = By.xpath("//*[text() = 'My Info']");
    By admin_toogle = By.xpath(("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a"));
    By insert_admin_username = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");
    By btn_admin_search = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");
    By show_record = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span");


    public void goToLoginPage(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
        //WebDriverManager.chromedriver().create();
    }

    public void inputUserName(String username){
        driver.findElement(input_username).sendKeys(username);
    }

    public void inputPassword(String password){
        driver.findElement(input_password).sendKeys(password);
    }

    public void btnLoginClick(){
        driver.findElement(btn_login).click();
    }

    public void assert_show_sidebar_info(){
        driver.findElement(sidenav_my_indo).isDisplayed();
    }
    public void adminToogleClick(){
        driver.findElement((admin_toogle)).click();
    }
    public void insertAdminUsername(String adminusername){
        driver.findElement(insert_admin_username).sendKeys(adminusername);
    }
    public void btnAdminSearch(){
        driver.findElement(btn_admin_search).click();
    }

    public void showAdminRecord(){
        driver.findElement(show_record).isDisplayed();
    }



}
