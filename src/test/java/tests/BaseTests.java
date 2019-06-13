package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.AgregarPage;
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
    public AgregarPage agregarPage;


    @BeforeMethod
    public void beforeMetohd() {
        String path = Paths.get(System.getProperty("user.dir"), "src/test/resources/webdrivers/chromedriver.exe").toString();
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.audiomusica.com/");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        filtrarPage = new FiltrarPage(driver);
        agregarPage = new AgregarPage(driver);
    }

    @AfterSuite
    public void tearDownSuite() {
        driver.quit();
    }

}
