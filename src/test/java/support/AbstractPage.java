package support;

import org.openqa.selenium.By;

public class AbstractPage {
    protected final Driver driver;
    protected By screenIdentifier;

    protected AbstractPage(Driver driver) {
        this.driver = driver;
    }

    public boolean isPagePresent() {
        return driver.isElementPresent(screenIdentifier);
    }
}
