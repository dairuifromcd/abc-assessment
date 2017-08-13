package support;

import org.openqa.selenium.By;

public class NewsImagePage extends AbstractPage {
    private By image;

    public NewsImagePage(Driver driver) throws Exception {
        super(driver);
        image = ElementMap.getLocator(UIConstants.NewsImagePage.IMAGE);
        screenIdentifier = image;
    }

    public boolean isImageDisplayed() {
        return driver.isDisplayed(image);
    }
}
