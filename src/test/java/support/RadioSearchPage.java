package support;

import org.openqa.selenium.By;

public class RadioSearchPage extends AbstractPage {
    private By title;
    private By totalResultNumber;
    private By firstPageArticle;

    public RadioSearchPage(Driver driver) throws Exception {
        super(driver);
        title = ElementMap.getLocator(UIConstants.RadioSearchPage.TITLE);
        totalResultNumber = ElementMap.getLocator(UIConstants.RadioSearchPage.TOTAL_RESULT_NUMBER);
        firstPageArticle = ElementMap.getLocator(UIConstants.RadioSearchPage.FIRST_PAGE_ARTICAL);
        screenIdentifier = title;
    }

    public int getTotalResultNumber() {
        String strNumber = driver.getText(totalResultNumber);
        return Integer.parseInt(strNumber);
    }

    public int getFirstPageResultNumber() {
        return driver.elementListNumber(firstPageArticle);
    }
}
