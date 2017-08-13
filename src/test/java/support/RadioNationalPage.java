package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioNationalPage extends AbstractPage {
    private By programs;
    private By bigIdeas;
    private By rightArrow;
    private By programList;
    private By searchBox;

    public RadioNationalPage(Driver driver) throws Exception {
        super(driver);
        programs = ElementMap.getLocator(UIConstants.RadioNationalPage.PROGRAMS);
        bigIdeas = ElementMap.getLocator(UIConstants.RadioNationalPage.BIG_IDEA);
        rightArrow = ElementMap.getLocator(UIConstants.RadioNationalPage.RIGHT_ARROW);
        programList = ElementMap.getLocator(UIConstants.RadioNationalPage.PROGRAM_LIST);
        searchBox = ElementMap.getLocator(UIConstants.RadioNationalPage.SEARCH_BOX);
        screenIdentifier = programs;
    }

    public void clickPrograms() {
        driver.click(programs);
    }

    public void clickBigIdea() {
        driver.click(bigIdeas);
    }

    public void clickRightArrow() {
        driver.click(rightArrow);
    }

    public void search(String text) {
        driver.enterKeys(searchBox, text);
    }

    public void selectLastProgram() throws Exception {
        List<WebElement> list = driver.findElements(programList);
        int listSize = list.size();

        // first and last list items are both "View full program guide"
        if (listSize > 2) {
            WebElement lastProgram = list.get(listSize - 2);
            while (!lastProgram.isDisplayed()) {
                clickRightArrow();
            }
            // not sure yet why need to click twice, only once is required when manually done
            driver.multiClick(lastProgram, 2);
        } else {
            throw new Exception("No radio programs found!");
        }
    }
}
