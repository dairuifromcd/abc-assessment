package assessment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import support.*;

public class RadioTest {
    private Driver driver;
    private AudioPlayerHelper audioHelper;
    private RadioNationalPage radioNationalPage;
    private RadioBigIdeas radioBigIdeas;
    private RadioSearchPage radioSearchPage;
    private RadioEpisodePage radioEpisodePage;
    private RadioPlayPage radioPlayPage;

    @Before
    public void setUp() {
        try {
            driver = new Driver();
            audioHelper = new AudioPlayerHelper(driver.getExecutor());
            radioNationalPage = new RadioNationalPage(driver);
            radioBigIdeas = new RadioBigIdeas(driver);
            radioSearchPage = new RadioSearchPage(driver);
            radioEpisodePage = new RadioEpisodePage(driver, audioHelper);
            radioPlayPage = new RadioPlayPage(driver);
        } catch (Exception e) {
            System.out.println("Error during setting up NewsTest: " + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testNavigateToBigIdeas() {
        getRadioNational();
        radioNationalPage.clickPrograms();
        radioNationalPage.clickBigIdea();
        Assert.assertTrue(radioBigIdeas.isPagePresent());
    }

    @Test
    public void testSelectLastProgram() throws Exception {
        getRadioNational();
        radioNationalPage.selectLastProgram();
    }

    @Test
    public void testSearch() {
        getRadioNational();
        radioNationalPage.search("Sample Program");
        Assert.assertTrue(radioSearchPage.isPagePresent());

        int totalCount = radioSearchPage.getTotalResultNumber();
        int firstPageCount = radioSearchPage.getFirstPageResultNumber();

        if (totalCount > 20) {
            Assert.assertEquals(20, firstPageCount);
        } else {
            Assert.assertEquals(totalCount, firstPageCount);
        }
    }

    @Test
    public void testShare() {
        getRadioEpisode();
        radioEpisodePage.clickShareButton();
        Assert.assertTrue(radioEpisodePage.isShareWindowPresent());
    }

    @Test
    public void testPlayAudio() throws InterruptedException {
        getRadioEpisode();
        radioEpisodePage.clickDownloadButton();
        Assert.assertTrue(radioEpisodePage.isMP3PagePresent());
        Assert.assertTrue(radioEpisodePage.isAudioPlayingOnMp3Page());
    }

    @Test
    public void testListen() {
        getRadioEpisode();
        radioEpisodePage.clickListenButton();
        Assert.assertEquals(UIConstants.URL.RADIO_PLAY, radioEpisodePage.getPlayEqualsTruePageUrl());
    }

    @Test
    public void testLoadAudioPlayer() {
        driver.get(UIConstants.URL.RADIO_PLAY);
        Assert.assertTrue(radioPlayPage.isPlaying());
    }

    private void getRadioNational() {
        driver.get(UIConstants.URL.RADIO_NATIONAL);
        Assert.assertTrue(radioNationalPage.isPagePresent());
    }

    private void getRadioEpisode() {
        driver.get(UIConstants.URL.RADIO_EPISODE);
        Assert.assertTrue(radioEpisodePage.isPagePresent());
    }
}
