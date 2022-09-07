import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement textBoxINput = $x("//input[@type='text']");
    private final SelenideElement pictureElement = $x("//*[@id='hdtb-msb']/div[1]/div/div[2]/a");
    private final SelenideElement picture3 = $x("//*[@id=\'islrg\']/div[1]/div[3]/a[1]/div[1]/img");

    public MainPage(String url){
        Selenide.open(url);
    }

    /**
     * Выполняется поиск среди статей и нажимается кнопка Enter
     * @param searchString
     */
    public void search(String searchString){
        textBoxINput.setValue(searchString);
        textBoxINput.sendKeys(Keys.ENTER);
    }

    public void click_pic(){
        pictureElement.click();
    }

    public void click_pic3() throws IOException, URISyntaxException {
        picture3.screenshot();
    }

    public void openWebSite(String url){
        Selenide.open(url);
    }
}
