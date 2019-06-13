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

    @FindBy(xpath = "//a [@class='product-item-link' ][contains (text(), 'Piano Digital PX-870, color negro')]")
    private WebElement clickEnArticulo;
    @FindBy(xpath = "//div[@class='value'][contains (text(),'1105901')]")
    private WebElement articuloVisible;
    @FindBy(linkText = "Ver Stock en Tiendas")
    private WebElement linkVerStock;
    @FindBy(xpath = "//*[contains(text(),'Este producto está disponible en las siguientes tiendas:')]")
    private WebElement tiendasDeStock;
    @FindBy(xpath = "//a[@class='fancybox-item fancybox-close']")
    private WebElement clickCerrarMsjDeStock;
    @FindBy(xpath = "//input[@id='qty']")
    private WebElement cajaDeTexto;
    @FindBy(xpath = "//button[@id='product-addtocart-button']")
    private WebElement buttonAgregar;
    @FindBy(xpath = "//div[@id='modal-content-24']")
    private WebElement msjSeAgregoAlCarrito;
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
        return msjSeAgregoAlCarrito.isDisplayed();
    }
}

