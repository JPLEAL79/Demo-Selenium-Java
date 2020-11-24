package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AudioMusicaTests extends BaseTests{


    @Test
    public void testBuscarArticulo() {

        String nombreProducto = "Piano";

        loginPage.Login(getProperty("emailVacio"),getProperty("passVacio"));
        loginPage.Login(getProperty("email"), getProperty("pass"));
        //Assert.assertTrue(loginPage.ok());

        homePage.buscarEnCajaDeTexto(nombreProducto);
        Assert.assertTrue(homePage.at());

        filtrarPage.obtenerListadoDeMarcas();
        Assert.assertTrue(filtrarPage.at());

    }
}

