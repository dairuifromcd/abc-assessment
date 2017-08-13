package support;

import org.openqa.selenium.By;

public class RadioBigIdeas extends AbstractPage {
    private By program_banner;

    public RadioBigIdeas(Driver driver) throws Exception {
        super(driver);
        program_banner = ElementMap.getLocator(UIConstants.RadioBigIdeas.PROGRAM_BANNER);
        screenIdentifier = program_banner;
    }
}
