package Nugios.Kazunion.MainDashboard.pages;

import Nugios.Kazunion.common.RunChrome;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class DepartingCalendarPage extends RunChrome {

    FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(5));

    //Constructor
    public DepartingCalendarPage(WebDriver driver) {
        this.driver = driver;

        //Initialise Elements
        //PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(this.driver, this);
    }

    //Locators
    @FindBy(id = "DepartingDate")
    WebElement departingDate;

    @FindBy(id = "ReturningDate")
    WebElement returningDate;

    @FindBy(xpath = "//*[@id='ui-datepicker-div']//a[text()='15']")
    WebElement dateNumber;

    @FindBy(xpath = "//body")
    WebElement scroll;

    //Methods

    public void get_DepartingDateColor(String s) {
        wait.until(ExpectedConditions.visibilityOf(departingDate));
        scroll.sendKeys(Keys.DOWN);
        scroll.sendKeys(Keys.DOWN);
        scroll.sendKeys(Keys.DOWN);
        scroll.sendKeys(Keys.DOWN);
        scroll.sendKeys(Keys.DOWN);
        departingDate.click();
        departingDate.clear();
        departingDate.sendKeys(s);
        wait.until(ExpectedConditions.visibilityOf(returningDate));
        returningDate.click();
        departingDate.click();
        departingDate.clear();
        departingDate.sendKeys(s);
        departingDate.click();
        wait.until(ExpectedConditions.visibilityOf(dateNumber));
    }

    public String getCssValue() {

        return dateNumber.getCssValue("background-color");
    }
}
