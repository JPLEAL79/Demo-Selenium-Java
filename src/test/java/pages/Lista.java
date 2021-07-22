package pages;


import java.util.ArrayList;
import java.util.List;

public class Lista {

    public static void main(String[] args) {
        List<String> listaDeNombres = new ArrayList();
        listaDeNombres.add("andrea");
        listaDeNombres.add("felipe");
        listaDeNombres.add("juan");
        listaDeNombres.add("pablo");

        for (String nombre : listaDeNombres) {
            System.out.println(nombre);
        }
    }
}

/*
 *  getAttribute = para obtener el valor de un atributo de un elemento web
 *
 */
