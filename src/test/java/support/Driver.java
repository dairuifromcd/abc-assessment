package support;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Driver {
    private ChromeDriver driver;

    public Driver () {
        System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + "\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // allow long wait time because load time is not examined here
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    public void quit() {
        driver.quit();
    }

    public void get(String url) {
        driver.get(url);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public JavascriptExecutor getExecutor() {
        return driver;
    }

    public void click(By by) {
        driver.findElement(by).click();
    }

    public void multiClick(WebElement element, int times) {
        for (int i = 0; i < times; i++) {
            element.click();
        }
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getAttribute(By by, String attribute) {
        return driver.findElement(by).getAttribute(attribute);
    }

    public boolean isDisplayed(By by) {
        return driver.findElement(by).isDisplayed();
    }

    public void enterKeys(By by, String key) {
        WebElement element = driver.findElement(by);
        element.sendKeys(key);
        element.sendKeys(Keys.ENTER);
    }

    public String getText(By by) {
        return driver.findElement(by).getText();
    }

    public int elementListNumber(By by) {
        List<WebElement> list = driver.findElements(by);
        return list.size();
    }

    public void switchToFrame(By by) {
        WebElement frame = driver.findElement(by);
        driver.switchTo().frame(frame);
    }

    public void switchToWindow(String handle) {
        driver.switchTo().window(handle);
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public void switchToSubWindow() {
        String parent = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();

        // assume only one sub window is open
        if (handles.size() == 2) {
            Iterator<String> iterator = handles.iterator();

            while (iterator.hasNext()) {
                String handle = iterator.next().toString();

                if (!handle.contains(parent)) {
                    switchToWindow(handle);
                }
            }
        }
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
