package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgregarPage {

    private WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[@class='product-item-link'][contains(text(),' Piano digital PX-160, color negro, sin fuente de poder')]")
    private WebElement clickEnArticulo;
    @FindBy(css = "span[data-ui-id]")
    private WebElement articuloVisible;
    @FindBy(linkText = "Ver Stock en Tiendas")
    private WebElement linkVerStock;
    @FindBy(xpath = "//*[@class='block-title'] [contains (text() , 'Stock solamente referencial, favor revisar previamente con tiendas.')]")
    private WebElement tiendasDeStock;
    @FindBy(xpath = "//a[@class='fancybox-item fancybox-close']")
    private WebElement clickCerrarMsjDeStock;
    @FindBy(xpath = "//input[@id='qty']")
    private WebElement cajaDeTexto;
    @FindBy(xpath = "//button[@id='product-addtocart-button']")
    private WebElement buttonAgregar;

    @FindBy(xpath = "//div[@class='modals-wrapper']/aside[3]//button[@class='action-close']")
    private WebElement cerrarMsjDeArticuloAgregado;


    public AgregarPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(this.driver, this);

    }

    public void seleccionarArticulo() {
        clickEnArticulo.click();

    }

    public void verStockDeArticulos() {
        linkVerStock.click();
        clickCerrarMsjDeStock.click();
    }

    public void agregarArticuloAlCarritoDeCompras(){
        cajaDeTexto.clear();
        cajaDeTexto.sendKeys("1");
        buttonAgregar.click();
        wait.until(ExpectedConditions.elementToBeClickable(this.cerrarMsjDeArticuloAgregado));
        cerrarMsjDeArticuloAgregado.click();

    }

    public boolean articuloDisponible() {
        return articuloVisible.isDisplayed();
    }

    public boolean stockDisponible() {
        return tiendasDeStock.isDisplayed();
    }

    public boolean seAgregoAlCarrito() {
        return cerrarMsjDeArticuloAgregado.isDisplayed();
    }
}

