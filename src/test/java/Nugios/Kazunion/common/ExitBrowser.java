package Nugios.Kazunion.common;

import VideoRecorder.VideoRecorder_utlity;
import org.testng.annotations.AfterSuite;

public class ExitBrowser extends RunChrome{

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        VideoRecorder_utlity.stopRecord();
    }
}
