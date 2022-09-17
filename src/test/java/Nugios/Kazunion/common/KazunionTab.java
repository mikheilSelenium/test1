package Nugios.Kazunion.common;

import org.testng.annotations.Test;

public class KazunionTab extends RunChrome {


    @Test
    public void kazunionTab(){

        driver.switchTo().window(tabs.get(1));
    }
}
