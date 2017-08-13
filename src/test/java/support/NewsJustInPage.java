package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NewsJustInPage extends AbstractPage {
    private By title;
    private By firstPageList;

    public NewsJustInPage(Driver driver) throws Exception {
        super(driver);
        title = ElementMap.getLocator(UIConstants.NewsJustInPage.TITLE);
        firstPageList = ElementMap.getLocator(UIConstants.NewsJustInPage.FIRST_PAGE_LIST);
        screenIdentifier = title;
    }

    public int firstPageListSize() {
        List<WebElement> list = getArticleListFirstPage();
        return list.size();
    }

    public int minimumContentTypeNumberPerArtical() {
        List<WebElement> list = getArticleListFirstPage();
        int minimum = 0;

        if (list.size() > 0) {
            String[] articalItems = null;
            minimum = list.get(0).getText().split("\n").length;

            for (WebElement ele : list) {
                articalItems = ele.getText().split("\n");
                minimum = articalItems.length < minimum ? articalItems.length : minimum;
            }
        }

        return minimum;
    }

    private List<WebElement> getArticleListFirstPage() {
        return driver.findElements(firstPageList);
    }
}
