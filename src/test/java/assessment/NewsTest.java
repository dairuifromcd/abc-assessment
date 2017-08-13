package assessment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import support.*;

public class NewsTest {
    private Driver driver;
    private JwPlayerHelper playerHelper;
    private NewsHomePage newsHomePage;
    private NewsJustInPage newsJustInPage;
    private NewsVideoPage newsVideoPage;
    private NewsImagePage newsImagePage;

    @Before
    public void setUp() {
        try {
            driver = new Driver();
            playerHelper = new JwPlayerHelper(driver.getExecutor());
            newsHomePage = new NewsHomePage(driver);
            newsJustInPage = new NewsJustInPage(driver);
            newsVideoPage = new NewsVideoPage(driver, playerHelper);
            newsImagePage = new NewsImagePage(driver);
        } catch (Exception e) {
            System.out.println("Error during setting up NewsTest: " + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLoadNewsPage() {
        getNewsHome();
    }

    @Test
    public void testNavigateToJustIn() {
        getJustIn();
    }

    @Test
    public void testJustInContent() {
        getJustIn();
        Assert.assertEquals(25, newsJustInPage.firstPageListSize());
        int count = newsJustInPage.minimumContentTypeNumberPerArtical();
        // Title, Timestamp and Text are always available, so minimum is 3. Update and author are optional, so maximum is 5.
        // Ideally each type of content should be validated against if have access to database.
        Assert.assertTrue(count == 3 || count == 4 || count == 5);
    }

    @Test
    public void testLoadVideo() {
        driver.get(UIConstants.URL.NEWS_VIDEO);
        Assert.assertTrue(newsVideoPage.isPagePresent());
        newsVideoPage.play();
        Assert.assertTrue(newsVideoPage.isPlaying());
    }

    @Test
    public void testLoadImage() {
        driver.get(UIConstants.URL.NEWS_IMAGE);
        Assert.assertTrue(newsImagePage.isPagePresent());
        Assert.assertTrue(newsImagePage.isImageDisplayed());
    }

    private void getNewsHome() {
        driver.get(UIConstants.URL.NEWS_HOME);
        Assert.assertTrue(newsHomePage.isPagePresent());
        Assert.assertEquals("ABC News", newsHomePage.getBanner());
    }

    private void getJustIn() {
        getNewsHome();
        newsHomePage.clickJustIn();
        Assert.assertTrue(newsJustInPage.isPagePresent());
    }
}
