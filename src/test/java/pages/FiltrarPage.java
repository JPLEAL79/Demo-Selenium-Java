package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FiltrarPage {

    WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id='kuFilterNames-manufacturer']/ul/li")
    private List<WebElement> listaDeMarcas;

    @FindBy (xpath =  "//*[@id='kuFilterNames-manufacturer']")
    private WebElement marcas;



    public FiltrarPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(this.driver, this);

    }

    public void obtenerListadoDeMarcas() {
        String nombreMarca = "";

        for (WebElement marca : listaDeMarcas) {
            nombreMarca = marca.getText();
            System.out.println(nombreMarca);

        }
    }

    public boolean at() {
        return marcas.isDisplayed();

    }
}


