package Nugios.Kazunion.MainDashboard.tests;

import Nugios.Kazunion.FlightBlock.pages.FlightBlockPage;
import Nugios.Kazunion.MainDashboard.pages.DepartingCalendarPage;
import Nugios.Kazunion.common.RunChrome;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DepartingCalendarTest extends RunChrome {

    @Test
    @Parameters({"color"})
    public void departingCalendarTest(String Color) {

        DepartingCalendarPage departingCalendarPage= new DepartingCalendarPage(driver);
        departingCalendarPage.get_DepartingDateColor("15.11.2022");
        Assert.assertEquals(departingCalendarPage.getCssValue(), Color);
    }

}
