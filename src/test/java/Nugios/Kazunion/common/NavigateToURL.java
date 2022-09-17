package Nugios.Kazunion.common;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class NavigateToURL extends RunChrome {

    @Test
    public static void navigateToURL(){

        WebDriverWait wait = new WebDriverWait(driver, 30);

        // 2. Open URL
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://nugioscore.rustaronline.ge/ProductionUAE");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnLogin")));
    }
}