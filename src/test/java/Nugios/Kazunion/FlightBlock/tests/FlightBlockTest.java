package Nugios.Kazunion.FlightBlock.tests;

import Nugios.Kazunion.FlightBlock.pages.FlightBlockPage;
import Nugios.Kazunion.common.RunChrome;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightBlockTest extends RunChrome {

    @Test
    public void flightBlockTest() throws Exception{

        FlightBlockPage flightBlockPage= new FlightBlockPage(driver);
        flightBlockPage.goto_FlihtBlockItem();
        flightBlockPage.flightCode_filter();
        flightBlockPage.flightDateColum_filter();
        flightBlockPage.AvailableTicketModification_part1();
        flightBlockPage.AvailableTicketModification_part2("1");
    }

}
