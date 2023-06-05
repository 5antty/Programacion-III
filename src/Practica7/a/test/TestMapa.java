package Practica7.a.test;

import estructuras.grafos.*;
import Practica7.a.Mapa;
import estructuras.*;

public class TestMapa {
    public static void main(String[] args) {
        Mapa map = new Mapa();
        Vertice<String> c = new VerticeImplListAdy<String>("Caleta");
        Vertice<String> c1 = new VerticeImplListAdy<String>("Comodoro");
        Vertice<String> c2 = new VerticeImplListAdy<String>("CABA");
        Vertice<String> c3 = new VerticeImplListAdy<String>("La Plata");
        Vertice<String> c4 = new VerticeImplListAdy<String>("Mendoza");
        Vertice<String> c5 = new VerticeImplListAdy<String>("Catamarca");
        Vertice<String> c6 = new VerticeImplListAdy<String>("Lima");
        map.getMapaCiudades().agregarVertice(c);
        map.getMapaCiudades().agregarVertice(c1);
        map.getMapaCiudades().agregarVertice(c2);
        map.getMapaCiudades().agregarVertice(c3);
        map.getMapaCiudades().agregarVertice(c4);
        map.getMapaCiudades().agregarVertice(c5);
        map.getMapaCiudades().agregarVertice(c6);
        map.getMapaCiudades().conectar(c, c1, 1);
        map.getMapaCiudades().conectar(c, c2, 1);
        map.getMapaCiudades().conectar(c1, c2, 1);
        map.getMapaCiudades().conectar(c1, c3, 1);
        map.getMapaCiudades().conectar(c2, c3, 1);
        map.getMapaCiudades().conectar(c2, c4, 1);
        map.getMapaCiudades().conectar(c3, c5, 1);
        map.getMapaCiudades().conectar(c5, c6, 1);
        map.getMapaCiudades().conectar(c4, c6, 1);

        ListaGenerica<String> res = map.devolverCaminoC("Caleta", "Lima");
        if (res != null)
            System.out.println(res);

        ListaGenerica<String> exc = new ListaGenericaEnlazada<String>();
        exc.agregarFinal("La Plata");
        exc.agregarFinal("Catamarca");
        exc.agregarFinal("Comodoro");

        res = map.devolverCaminoExceptuando("Caleta", "Lima", exc);
        if (res != null)
            System.out.println(res);

        res = map.caminoMasCorto("CABA", "Lima");
        if (res != null)
            System.out.println(res);
        res = map.caminoSinCargarCombustible("Caleta", "Lima", 3);
        if (res != null)
            System.out.println(res);
    }
}
