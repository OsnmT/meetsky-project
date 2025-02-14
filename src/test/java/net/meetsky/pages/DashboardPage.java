package net.meetsky.pages;

import net.meetsky.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }


}
