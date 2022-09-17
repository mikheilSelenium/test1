package Nugios.Kazunion.common.tests;

import Nugios.Kazunion.common.RunChrome;
import Nugios.Kazunion.common.pages.AuthorisationKazPage;
import Nugios.Kazunion.common.pages.AuthorisationPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AuthorisationKazTest extends RunChrome {

    @Test
    @Parameters({"userName", "password"})
    public void authorisationTest(String userName, String password) {

        AuthorisationKazPage authorisationKazPage = new AuthorisationKazPage(driver);
        authorisationKazPage.set_username(userName);
        authorisationKazPage.set_password(password);
        authorisationKazPage.clickOn_LoginButton();
    }
}
