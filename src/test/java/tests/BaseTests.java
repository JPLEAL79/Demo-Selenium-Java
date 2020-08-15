package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.FiltrarPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTests {


    public WebDriver driver;
    public String url = "https://www.audiomusica.com/";
    public HomePage homePage;
    public LoginPage loginPage;
    public FiltrarPage filtrarPage;


    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) throws Exception {

        switch (browser) {

            case "chrome":

                //instrucciones para arrancar el browser
                ChromeOptions opts = new ChromeOptions();
                opts.addArguments("--disable-notifications"); //Opción de Chrome sirve para desactivar notificacion
                opts.addArguments("--start-maximized"); //Opción de Chrome sirve para que inicie maximizado

                
                System.setProperty("webdriver.chrome.driver", "./src/test/resources/webdrivers/chromedriver.exe");
                driver = new ChromeDriver(opts);
                loginPage = new LoginPage(driver);
                homePage = new HomePage(driver);
                filtrarPage = new FiltrarPage(driver);
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "./src/test/resources/webdrivers/geckodriver.exe");
                driver = new FirefoxDriver();
                loginPage = new LoginPage(driver);
                homePage = new HomePage(driver);
                filtrarPage = new FiltrarPage(driver);
                break;
            default:
                throw new Exception("Navegador" + browser + "no soportado");

        }

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

}


