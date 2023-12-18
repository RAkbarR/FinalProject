package page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import static helper.Utility.driver;

public class webPage {

    By input_username = By.name("username");
    By input_password = By.name("password");
    By btn_login = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
    By sidenav_my_indo = By.xpath("//*[text() = 'My Info']");

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
}
