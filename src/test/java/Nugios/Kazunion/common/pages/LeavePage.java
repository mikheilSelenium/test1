package Nugios.Kazunion.common.pages;

import Nugios.Kazunion.common.RunChrome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LeavePage extends RunChrome {

    WebDriverWait wait = new WebDriverWait(driver, 60);

    //Constructor
    public LeavePage(WebDriver driver) {
        this.driver = driver;

        //Initialise Elements
        //PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(this.driver, this);
    }


    //Locators

    @FindBy(xpath = "//button[@aria-label='პროფილი']")
    WebElement profile_Button;

    @FindBy(xpath = "//button[@aria-label='სისტემიდან გასვლა']")
    WebElement leave_Button;


    //Methods

    public void clickOn_Leave() {
        wait.until(ExpectedConditions.visibilityOf(profile_Button));
        profile_Button.click();
        wait.until(ExpectedConditions.visibilityOf(leave_Button));
        leave_Button.click();
    }
}