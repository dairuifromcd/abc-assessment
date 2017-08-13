package support;

public final class UIConstants {
    public static final class URL {
        public static final String NEWS_HOME = "http://www.abc.net.au/news/";
        public static final String NEWS_VIDEO = "http://www.abc.net.au/news/2017-02-09/weatherill-promises-to-intervene-dramatically/8254908";
        public static final String NEWS_IMAGE = "http://www.abc.net.au/news/2017-02-10/abc-open-pic-of-the-week/8256256";
        public static final String RADIO_NATIONAL = "http://www.abc.net.au/radionational/";
        //public static final String RADIO_BIG_IDEA = "http://www.abc.net.au/radionational/programs/bigideas/";
        public static final String RADIO_EPISODE = "http://www.abc.net.au/radionational/programs/bigideas/a-treaty-to-ban-nuclear-weapons/8742524";
        public static final String RADIO_PLAY = "https://radio.abc.net.au/programitem/peaLJ4Rlp3?play=true";
    }

    public static final class NewsHomePage {
        public static final String BANNER = "xpath://img[@alt='ABC News']";
        public static final String JUSTIN = "id:n-justin";
    }

    public static final class NewsJustInPage {
        public static final String TITLE = "xpath://h1[text()='Just In']";
        public static final String FIRST_PAGE_LIST = "xpath://ul[@class='article-index']/li";
    }

    public static final class NewsImagePage {
        public static final String IMAGE = "xpath://li/img";
    }

    public static final class RadioNationalPage {
        public static final String PROGRAMS = "linktext:Programs";
        public static final String BIG_IDEA = "linktext:Big Ideas";
        public static final String RIGHT_ARROW = "id:right-arrow";
        public static final String PROGRAM_LIST = "xpath://ul[@class='at-a-glance']/li";
        public static final String SEARCH_BOX = "id:search-simple-input-query";
    }

    public static final class RadioBigIdeas {
        public static final String PROGRAM_BANNER = "xpath://h2/a[text()='Big Ideas']";
    }

    public static final class RadioSearchPage {
        public static final String TITLE = "xpath://h2[text()='Search']";
        public static final String TOTAL_RESULT_NUMBER = "xpath://strong";
        public static final String FIRST_PAGE_ARTICAL = "xpath://ul[@class='article-index']/li";
    }

    public static final class RadioEpisodePage {
        public static final String FACEBOOK_IFRAME = "xpath://iframe[contains(@title, 'Facebook')]";
        public static final String SHARE_BUTTON = "xpath://span[text()='Share']";
        public static final String DOWNLOAD_BUTTON = "linktext:Download audio";
        public static final String LISTEN_BUTTON = "linktext:Listen now";
        public static final String LOGIN_BUTTON = "id:loginbutton";
        public static final String VIDEO_TAG = "tagname:video";
        public static final String CENTER_PLAY_BUTTON = "xpath://div[@role='button']";
    }

    public static final class RadioPlayPage {
        public static final String CENTER_PLAY_BUTTON = "xpath://div[@role='button']";
        // this selector can be 'Playing' and 'Paused' according to player state
        public static final String IS_PLAYING = "xpath://span[text()='Playing']";
    }
}
