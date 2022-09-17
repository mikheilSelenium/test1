package Nugios.Kazunion.common.pages;

import Nugios.Kazunion.common.RunChrome;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AuthorisationPage extends RunChrome {

    WebDriverWait wait = new WebDriverWait(driver, 60);

    //Constructor
    public AuthorisationPage(WebDriver driver) {
        this.driver = driver;

        //Initialise Elements
        //PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(this.driver, this);
    }

    //Locators
    @FindBy(id = "CurrentEndpoint_I")
    WebElement country;

    @FindBy(id = "UserName_I")
    WebElement username;

    @FindBy(id = "Password_I")
    WebElement password;

    @FindBy(id = "btnLogin_CD")
    WebElement btnLogin;

    @FindBy(id = "pnlMain_RPC")
    WebElement mainDashboard;


    //Methods

    public void set_country() {
        wait.until(ExpectedConditions.visibilityOf(country));
        country.click();
        country.sendKeys("KAZUNION");
        country.sendKeys(Keys.TAB);
    }

    public String get_selectedCountry() {
        wait.until(ExpectedConditions.visibilityOf(country));
        return country.getAttribute("value");
    }

    public void set_username(String Username) {
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(Username);
    }

    public void set_password(String Password) {
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(Password);
    }

    public void clickOn_LoginButton() {
        wait.until(ExpectedConditions.visibilityOf(btnLogin));
        btnLogin.click();
        wait.until(ExpectedConditions.elementToBeClickable(mainDashboard));
    }
}
