package Nugios.Kazunion.FlightBlock.pages;

import Nugios.Kazunion.common.RunChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.time.Duration;

public class FlightBlockPage extends RunChrome {

    FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(5));

    //Constructor
    public FlightBlockPage(WebDriver driver) {
        this.driver = driver;

        //Initialise Elements
        //PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(this.driver, this);
    }

    //Locators
    @FindBy(xpath = "(//span[text()='Flights'])[2]")
    WebElement flightMenu;

    @FindBy(xpath = "(//a[text()='Flight Block'])[2]")
    WebElement flightBlockItem;

    @FindBy(id = "gvFlightBlock_DXFREditorcol5_I")
    WebElement flightCode_input;

    @FindBy(xpath = "//td[@id='gvFlightBlockTicketAvailability_col2']//img")
    WebElement flightDate_filter;

    @FindBy(xpath = "//td[@id='gvFlightBlockTicketAvailability_col2']//td")
    WebElement flightDate_txt;

    @FindBy(id = "gvFlightBlockTicketAvailability_HFListBox2_LBFE_I")
    WebElement filterInputBox;

    @FindBy(id = "gvFlightBlockTicketAvailability_HFListBox2_!15.11.2022 12:00:00 AM_D")
    WebElement filtered_checkBox;

    @FindBy(id = "gvFlightBlockTicketAvailability_DXHFP_TPCFCm1_O_CD")
    WebElement filter_OKbutton;

    @FindBy(id = "gvFlightBlockTicketAvailability_DXGroupRow0")
    WebElement materializationRow;

    @FindBy(id = "gvFlightBlockTicketAvailability_DXDataRow1")
    WebElement materializationItem;

    @FindBy(id = "AvailableTickets_I")
    WebElement AvailableTickets_input;

    @FindBy(id = "btnUpdate_CD")
    WebElement save_button;

    @FindBy(xpath = "//div[contains(@id, 'success-alert')]//span")
    WebElement message_txt;




    //Methods

    public void goto_FlihtBlockItem() throws Exception{
        wait.until(ExpectedConditions.visibilityOf(flightMenu));
        flightMenu.click();
        wait.until(ExpectedConditions.visibilityOf(flightBlockItem));
        flightBlockItem.click();
        Thread.sleep(1000);
    }

    public void flightCode_filter() {
        wait.until(ExpectedConditions.textToBePresentInElement(flightDate_txt, "FlightDate"));
        wait.until(ExpectedConditions.visibilityOf(flightCode_input));
        flightCode_input.sendKeys("FZ1722");
        flightCode_input.sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("gvFlightBlockTicketAvailability_LPV")));
    }

    public void flightDateColum_filter() {
        wait.until(ExpectedConditions.textToBePresentInElement(flightDate_txt, "FlightDate"));
        wait.until(ExpectedConditions.visibilityOf(flightCode_input));
        flightDate_filter.click();
        wait.until(ExpectedConditions.visibilityOf(filterInputBox));
        filterInputBox.sendKeys("15.11.2022");
        filterInputBox.sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.visibilityOf(filtered_checkBox));
        filtered_checkBox.click();
        wait.until(ExpectedConditions.visibilityOf(filter_OKbutton));
        filter_OKbutton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("gvFlightBlockTicketAvailability_LPV")));
    }

    public void AvailableTicketModification_part1() {
        wait.until(ExpectedConditions.visibilityOf(materializationRow));
        Actions actions = new Actions(driver);
        actions.doubleClick(materializationRow).perform();
    }

    public void AvailableTicketModification_part2(String tktNumber) throws Exception{
        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        actions.doubleClick(materializationItem).perform();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(AvailableTickets_input));
        AvailableTickets_input.clear();
        AvailableTickets_input.sendKeys(tktNumber);
        save_button.click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.textToBePresentInElement(message_txt, "Operation completed successfully!"));
        Assert.assertEquals(message_txt.getText(), "Operation completed successfully!...");
    }

    public void AvailableTicketModification_part3(String tktNumber) throws Exception{
        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        actions.doubleClick(materializationItem).perform();
        wait.until(ExpectedConditions.visibilityOf(AvailableTickets_input));
        AvailableTickets_input.clear();
        AvailableTickets_input.sendKeys(tktNumber);
        save_button.click();
    }
}
