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

    @FindBy(xpath = "//span[@class='label'][contains(text(),'Marcas')]")
    private WebElement linkMarca;
    @FindBy(xpath = "//form[@data-amshopby-filter='attr_category_ids']/li[@data-label = 'Marcas']/ul/li")
    private List<WebElement> listaDeMarcas;

    @FindBy(xpath = "//li[@class='item am-shopby-item']")
    private WebElement resultado;

    public FiltrarPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(this.driver, this);

    }

    public void CategoríaMarca() {
        linkMarca.click();
    }

    public void obtenerDatosDeListaDeMarcas() {
        String nombreMarca = "";
        for (WebElement marca : listaDeMarcas) {
            nombreMarca = marca.getAttribute("data-label");
            if (marca.getAttribute("data-label").contains("Casio")) {
                marca.click();
                break;
            }
            System.out.println(nombreMarca);
        }
    }

    public boolean at() {
        return resultado.isDisplayed();
    }

    public boolean linkMarcaDisponible() {
        return linkMarca.isDisplayed();
    }
}


