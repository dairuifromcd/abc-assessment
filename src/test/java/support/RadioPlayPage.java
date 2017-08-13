package support;

import org.openqa.selenium.By;

public class RadioPlayPage extends AbstractPage {
    private By centerPlayButton;
    private By isPlaying;

    public RadioPlayPage(Driver driver) throws Exception {
        super(driver);
        centerPlayButton = ElementMap.getLocator(UIConstants.RadioPlayPage.CENTER_PLAY_BUTTON);
        isPlaying = ElementMap.getLocator(UIConstants.RadioPlayPage.IS_PLAYING);
        screenIdentifier = centerPlayButton;
    }

    public boolean isPlaying() {
        return driver.isElementPresent(isPlaying);
    }
}
