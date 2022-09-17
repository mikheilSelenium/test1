package Nugios.Kazunion.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import Nugios.Kazunion.common.NewTab;

import java.util.ArrayList;

public class MainTab extends RunChrome {


    @Test
    public void mainTab(){

        driver.switchTo().window(tabs.get(0));
    }
}
