package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    WebDriverWait wait;

    @FindBy(css= ".search .input-text")
    private WebElement cajaDeBusqueda;


    public HomePage(WebDriver driver) {
        wait = new WebDriverWait(driver, 15);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        PageFactory.initElements(this.driver, this);

    }

    public void buscarEnCajaDeTexto(String nombreProducto){
        cajaDeBusqueda.sendKeys(nombreProducto);
        cajaDeBusqueda.sendKeys(Keys.ENTER);
    }

    public boolean at() {
        return cajaDeBusqueda.isDisplayed();
    }
}

