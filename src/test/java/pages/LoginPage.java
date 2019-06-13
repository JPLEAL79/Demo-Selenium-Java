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
    @FindBy(id = "email")
    private WebElement campoEmail;
    @FindBy(id = "pass")
    private WebElement campoPassword;
    @FindBy(id = "send2")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@data-bind='text: customer().fullname'][ contains (text(),'Juan Pablo Leal')]")
    private WebElement loginCorrecto;
    @FindBy(xpath = "//div[@id='email-error'][contains (text(), 'Este es un campo obligatorio.')]")
    private WebElement loginFallido;

    @FindBy(xpath = "//div[contains (text(),'Se requieren nombre de usuario y contraseña.')]")
    private WebElement seRequiereUserYpass;


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
        return loginCorrecto.isDisplayed();
    }

    public boolean fail() {
        return loginFallido.isDisplayed() || seRequiereUserYpass.isDisplayed();
    }
}

