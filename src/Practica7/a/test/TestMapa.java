package Practica7.a.test;

import estructuras.grafos.*;
import Practica7.a.Mapa;
import estructuras.*;

public class TestMapa {
    public static void main() {
        Mapa map = new Mapa();
        Vertice<String> c = new VerticeImplListAdy<String>("Caleta");
        Vertice<String> c1 = new VerticeImplListAdy<String>("Comodoro");
        Vertice<String> c2 = new VerticeImplListAdy<String>("CABA");
        Vertice<String> c3 = new VerticeImplListAdy<String>("La Plata");
        map.mapaCiudades.conectar(c, c2, 0);
        map.mapaCiudades.conectar(c2, c3, 0);
        map.mapaCiudades.conectar(c3, c1, 0);
        ListaGenericaEnlazada<String> res = map.devolverCamino("Caleta", "Comodoro");
        System.out.println(res);
    }
}
