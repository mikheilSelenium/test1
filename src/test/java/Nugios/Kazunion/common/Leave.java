package Nugios.Kazunion.common;

import Nugios.Kazunion.ScreenRecorder.ScreenListener;
import Nugios.Kazunion.common.pages.LeavePage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ScreenListener.class)
public class Leave extends RunChrome{

    @Test
    public void leaveTest() {

        LeavePage leavePage = new LeavePage(driver);
        leavePage.clickOn_Leave();
    }
}