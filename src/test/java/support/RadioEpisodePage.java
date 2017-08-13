package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RadioEpisodePage extends AbstractPage {
    private By facebookIframe;
    private By shareButton;
    private By downloadButton;
    private By listenButton;
    private By videoTag;
    private By loginButton;
    private By centerPlayButton;
    private AudioPlayerHelper audioHelper;

    public RadioEpisodePage(Driver driver, AudioPlayerHelper audioHelper) throws Exception {
        super(driver);
        this.audioHelper = audioHelper;
        facebookIframe = ElementMap.getLocator(UIConstants.RadioEpisodePage.FACEBOOK_IFRAME);
        shareButton = ElementMap.getLocator(UIConstants.RadioEpisodePage.SHARE_BUTTON);
        downloadButton = ElementMap.getLocator(UIConstants.RadioEpisodePage.DOWNLOAD_BUTTON);
        listenButton = ElementMap.getLocator(UIConstants.RadioEpisodePage.LISTEN_BUTTON);
        videoTag = ElementMap.getLocator(UIConstants.RadioEpisodePage.VIDEO_TAG);
        centerPlayButton = ElementMap.getLocator(UIConstants.RadioEpisodePage.CENTER_PLAY_BUTTON);
        loginButton = ElementMap.getLocator(UIConstants.RadioEpisodePage.LOGIN_BUTTON);
        screenIdentifier = facebookIframe;
    }

    public void clickShareButton() {
        driver.switchToFrame(facebookIframe);
        driver.click(shareButton);
    }

    public void clickDownloadButton() {
        driver.click(downloadButton);
    }

    public void clickListenButton() {
        driver.click(listenButton);
    }

    public boolean isMP3PagePresent() {
        return driver.isElementPresent(videoTag);
    }

    public boolean isShareWindowPresent() {
        String parent = driver.getWindowHandle();
        boolean result;

        driver.switchToSubWindow();
        result = driver.isElementPresent(loginButton);
        driver.switchToWindow(parent);

        return result;
    }

    public boolean isAudioPlayingOnMp3Page() throws InterruptedException {
        WebElement audio = driver.findElement(videoTag);
        double duration = audioHelper.getDuration(audio);
        double currentTime = audioHelper.getCurrentTime(audio);

        // give the audio a bit of time to play
        Thread.sleep(2000);

        return duration > 0 && currentTime > 0 && currentTime < duration;
    }

    public String getPlayEqualsTruePageUrl() {
        String parent = driver.getWindowHandle();
        String url = "";

        driver.switchToSubWindow();
        if (driver.isElementPresent(centerPlayButton)) {
            url = driver.getCurrentUrl();
        }
        driver.switchToWindow(parent);

        return url;
    }
}
