package Nugios.Kazunion.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class NewTab extends RunChrome {

    @Test
    public void newTab(){

        WebDriverWait wait = new WebDriverWait(driver, 30);
        ((JavascriptExecutor)driver).executeScript("window.open()");
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://uae.kazunion.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rustar_popupbox']/ul/li[1]/a/img")));
        driver.findElement(By.xpath("//*[@id='rustar_popupbox']/ul/li[1]/a/img")).click();
    }
}
