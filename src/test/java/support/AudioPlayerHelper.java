package support;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class AudioPlayerHelper {
    private JavascriptExecutor executor;

    public AudioPlayerHelper(JavascriptExecutor executor) {
        this.executor = executor;
    }

    public double getDuration(WebElement audio) {
        return (Double)executor.executeScript("return arguments[0].duration;", audio);
    }

    public double getCurrentTime(WebElement audio) {
        return (Double)executor.executeScript("return arguments[0].currentTime;", audio);
    }
}
