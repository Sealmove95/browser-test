import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.FileDownloadMode.PROXY;


abstract public class BaseTest {
    private final static String pathToProperties = "\\app.properties";
    public void setUp() throws IOException {
        Properties testProps = new Properties();
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        testProps.load(new FileInputStream(dir + pathToProperties));
        Configuration.browser = testProps.getProperty("target.browser");
        if (testProps.getProperty("target.browser") == "chrome") {
            WebDriverManager.chromedriver().setup();
        } else if (testProps.getProperty("target.browser") == "firefox") {
            WebDriverManager.firefoxdriver().setup();
        }
        Configuration.driverManagerEnabled = true;
        Configuration.proxyEnabled = true;
        Configuration.fileDownload = PROXY;
        Configuration.headless = false;
        Configuration.downloadsFolder = "C:\\downloads";
        Configuration.reportsFolder = "C:\\downloads";
    }

    @Before
    public void init() throws IOException {
        setUp();
    }

    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}

