package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTests;

public class LoginPage extends BaseTests {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[contains(text(),'Iniciar sesión')]")
    private WebElement clickIniciaSesion;
    @FindBy(xpath = "//*[@id='email']")
    private WebElement campoEmail;
    @FindBy(id = "pass")
    private WebElement campoPassword;
    @FindBy(id = "send2")
    private WebElement loginButton;
    @FindBy(xpath ="//*[@class='customer-menu']//a[contains(text(),'Cerrar sesión')]")
    private WebElement usuarioCorrecto;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(this.driver, this);
    }

    public void Login(String email, String password) {
        clickIniciaSesion.click();
        campoEmail.sendKeys(email);
        campoPassword.sendKeys(password);
        loginButton.click();
    }

    public boolean ok() {
        return usuarioCorrecto.isDisplayed();
    }
}

