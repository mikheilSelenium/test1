package Nugios.Kazunion.FlightBlock.tests;

import Nugios.Kazunion.FlightBlock.pages.FlightBlockPage;
import Nugios.Kazunion.common.RunChrome;
import org.testng.annotations.Test;

public class AvailableTicketOriginalCondition extends RunChrome {

    @Test
    public void flightBlockTest() throws Exception{

        FlightBlockPage flightBlockPage= new FlightBlockPage(driver);
        flightBlockPage.AvailableTicketModification_part3("40");
    }

}
