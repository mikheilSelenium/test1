package Nugios.Kazunion.common;

import VideoRecorder.VideoRecorder_utlity;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class RunChrome {

    public static WebDriver driver;
    public static ArrayList<String> tabs;

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception{

        // 1. Run browser
        System.setProperty("webdriver.chrome.driver","chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        VideoRecorder_utlity.startRecord("TestRecording");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
