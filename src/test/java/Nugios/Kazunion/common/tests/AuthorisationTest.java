package Nugios.Kazunion.common.tests;

import Nugios.Kazunion.common.RunChrome;
import Nugios.Kazunion.common.pages.AuthorisationPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AuthorisationTest extends RunChrome {

    @Test
    @Parameters({"userName", "password"})
    public void authorisationTest(String userName, String password) {

        AuthorisationPage authorisationPage = new AuthorisationPage(driver);
        authorisationPage.set_country();
        Assert.assertEquals(authorisationPage.get_selectedCountry(), "KAZUNION");
        authorisationPage.set_username(userName);
        authorisationPage.set_password(password);
        authorisationPage.clickOn_LoginButton();
    }
}
