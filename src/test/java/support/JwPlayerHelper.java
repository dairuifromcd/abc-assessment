package support;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class JwPlayerHelper {
    private JavascriptExecutor executor;
    Wait<JavascriptExecutor> wait;

    public JwPlayerHelper(JavascriptExecutor executor) {
        this.executor = executor;
        wait = new FluentWait<JavascriptExecutor>(executor)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NullPointerException.class);
    }

    public boolean isPlayerReady() {
        return wait.until(new Function<JavascriptExecutor, Boolean>() {
            public Boolean apply(JavascriptExecutor executor) {
                return executor.executeScript("return jwplayer().getState()") != null;
            }
        });
    }

    public void play() {
        executor.executeScript("jwplayer().play();");
    }

    public boolean isPlaying() {
        return wait.until(new Function<JavascriptExecutor, Boolean>() {
            public Boolean apply(JavascriptExecutor executor) {
                return executor.executeScript("return jwplayer().getState()").equals("PLAYING");
            }
        });
    }
}
