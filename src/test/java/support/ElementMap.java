package support;

import org.openqa.selenium.By;

public final class ElementMap {
    private ElementMap() {

    }

    public static By getLocator(String element) throws Exception {
        String[] splitedElement = element.split(":");
        String type = splitedElement[0].toLowerCase();
        String value = splitedElement[1];

        if (type.equals("xpath")) {
            return By.xpath(value);
        } else if (type.equals("id")) {
            return By.id(value);
        } else if (type.equals("tagname")) {
            return By.tagName(value);
        } else if (type.equals("linktext")) {
            return By.linkText(value);
        } else {
            throw new Exception("Unknown locator type: " + type);
        }
    }
}
