package support;

public class NewsVideoPage extends AbstractPage {
    private JwPlayerHelper player;

    public NewsVideoPage(Driver driver, JwPlayerHelper player) {
        super(driver);
        this.player = player;
    }

    @Override
    public boolean isPagePresent() {
        return player.isPlayerReady();
    }

    public void play() {
        player.play();
    }

    public boolean isPlaying() {
        return player.isPlaying();
    }
}
