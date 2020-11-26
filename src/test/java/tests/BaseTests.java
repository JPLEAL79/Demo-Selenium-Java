package tests;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import pages.FiltrarPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class BaseTests {

    public WebDriver driver;
    public String url = "https://www.audiomusica.com/";
    public HomePage homePage;
    public LoginPage loginPage;
    public FiltrarPage filtrarPage;
    public static final String WINDOWS_DRIVER_PATH = "src/test/resources/webdrivers/";
    public static final String UNIX_DRIVER_PATH = "/usr/local/bin/";
    Properties props;

    @BeforeMethod
    
    @Parameters("browser")
    public void setUp(String browser) throws Exception {
        props = ConfigManager.readPropertiesFile();
        driver = startBrowser(System.getProperty("os.name"), browser);

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        filtrarPage = new FiltrarPage(driver);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

    public String getProperty(String nombreProperty) {
        return (String) this.props.get(nombreProperty);
    }

    private WebDriver startBrowser(String osName, String browserName) throws MalformedURLException {
        String basePath = "";
        String fileExt = "";
        String execName = "";
        if(osName.startsWith("Windows")) {
            basePath = WINDOWS_DRIVER_PATH;
            fileExt = ".exe";
        }
        else {
            basePath = UNIX_DRIVER_PATH;
        }

        if (BrowserType.FIREFOX.contains(browserName)) { 
            execName = "geckodriver";
            System.setProperty("webdriver.gecko.driver", basePath + execName + fileExt);
            FirefoxOptions opts = new FirefoxOptions();
            opts.addArguments("--disable-notifications");
            opts.addArguments("--start-maximized");

            return new FirefoxDriver(opts);


        } else if (BrowserType.SAFARI.contains(browserName)) {
            execName = "safaridriver";
            System.setProperty("webdriver.safari.driver", basePath + execName + fileExt);
            return new SafariDriver();


        } else if (BrowserType.EDGE.contains(browserName)) {
            execName = "msedgedriver";
            System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, basePath + execName + fileExt);
            return new EdgeDriver();


        } else {
            execName = "chromedriver";
            System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, basePath + execName + fileExt);
            ChromeOptions opts = new ChromeOptions();
            opts.addArguments("--disable-notifications"); //Opción de Chrome sirve para desactivar notificacion
            opts.addArguments("--start-maximized"); //Opción de Chrome sirve para que inicie maximizado

            // aca se creo la conexión  para docker
            DesiredCapabilities dc = DesiredCapabilities.chrome();
            URL url = new URL("http://localhost:4444/wd/hub");
            RemoteWebDriver driver = new RemoteWebDriver(url, dc);
            return new ChromeDriver(opts);
        }
    }
}


