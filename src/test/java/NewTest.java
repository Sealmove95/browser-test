import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class NewTest  extends BaseTest{

    private final static String BASE_URL = "https://google.com";
    private final static String SEARCH_STRING = "Николай Кузнецов";

    @Test
    public void checkHref() throws IOException, URISyntaxException {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.search(SEARCH_STRING);
        mainPage.click_pic();
        mainPage.click_pic3();
    }
}