package Nugios.Kazunion.common.pages;

import Nugios.Kazunion.common.RunChrome;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AuthorisationKazPage extends RunChrome {

    WebDriverWait wait = new WebDriverWait(driver, 60);

    //Constructor
    public AuthorisationKazPage(WebDriver driver) {
        this.driver = driver;

        //Initialise Elements
        //PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(this.driver, this);
    }

    //Locators

    @FindBy(id = "Username")
    WebElement username;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnLogin;

    @FindBy(xpath = "//*[@id='rustar_popupbox']/ul/li[1]/a/img")
    WebElement ENG_icon;


    //Methods

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
        wait.until(ExpectedConditions.elementToBeClickable(ENG_icon));
        ENG_icon.click();
    }
}
