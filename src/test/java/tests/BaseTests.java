package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.FiltrarPage;
import pages.HomePage;
import pages.LoginPage;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class BaseTests {


    public WebDriver driver;
    public HomePage homePage;
    public LoginPage loginPage;
    public FiltrarPage filtrarPage;


    @BeforeMethod
    public void beforeMetohd() {

        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--disable-notifications"); //Opción de Chrome sirve para desactivar las notificacion
        opts.addArguments("--start-maximized"); //Opción de Chrome sirve para que inicie maximizado



        System.setProperty("webdriver.chrome.driver", "./src/test/resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.audiomusica.com/");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        filtrarPage = new FiltrarPage(driver);

    }

    @AfterSuite
    public void tearDownSuite() {
        driver.quit();
    }

}
