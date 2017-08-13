package support;

import org.openqa.selenium.By;

public class NewsHomePage extends AbstractPage {
    private By banner;
    private By justIn;

    public NewsHomePage(Driver driver) throws Exception {
        super(driver);
        banner = ElementMap.getLocator(UIConstants.NewsHomePage.BANNER);
        justIn = ElementMap.getLocator(UIConstants.NewsHomePage.JUSTIN);
        screenIdentifier = banner;
    }

    public String getBanner() {
        return driver.getAttribute(banner, "alt");
    }

    public void clickJustIn() {
        driver.click(justIn);
    }
}
