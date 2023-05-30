package Practica7.a.test;

import estructuras.grafos.*;
import Practica7.a.Mapa;
import Practica7.a.Recorridos;
import estructuras.*;

public class TestMapa {
    public static void main(String[] args) {
        Mapa map = new Mapa();
        Vertice<String> c = new VerticeImplListAdy<String>("Caleta");
        Vertice<String> c1 = new VerticeImplListAdy<String>("Comodoro");
        Vertice<String> c2 = new VerticeImplListAdy<String>("CABA");
        Vertice<String> c3 = new VerticeImplListAdy<String>("La Plata");
        Vertice<String> c4 = new VerticeImplListAdy<String>("Lima");
        Vertice<String> c5 = new VerticeImplListAdy<String>("Catamarca");
        map.getMapaCiudades().agregarVertice(c);
        map.getMapaCiudades().agregarVertice(c1);
        map.getMapaCiudades().agregarVertice(c2);
        map.getMapaCiudades().agregarVertice(c3);
        map.getMapaCiudades().agregarVertice(c4);
        map.getMapaCiudades().agregarVertice(c5);
        map.getMapaCiudades().conectar(c, c2, 0);
        map.getMapaCiudades().conectar(c2, c3, 0);
        map.getMapaCiudades().conectar(c3, c1, 0);
        map.getMapaCiudades().conectar(c1, c2, 0);
        map.getMapaCiudades().conectar(c3, c4, 0);
        map.getMapaCiudades().conectar(c2, c4, 0);
        map.getMapaCiudades().conectar(c5, c, 0);
        map.getMapaCiudades().conectar(c5, c4, 0);
        ListaGenerica<String> res = map.devolverCamino("Caleta", "Comodoro");
        if (res != null)
            System.out.println(res);
        /*
         * Recorridos<String> r = new Recorridos<String>();
         * ListaGenerica<Vertice<String>> lis = r.bfs(map.getMapaCiudades());
         * while (!lis.fin()) {
         * System.out.println(lis.proximo().dato());
         * }
         * System.out.println();
         * lis = r.dfs(map.getMapaCiudades());
         * while (!lis.fin()) {
         * System.out.println(lis.proximo().dato());
         * }
         */
        ListaGenerica<String> exc = new ListaGenericaEnlazada<String>();
        exc.agregarFinal("Caleta");
        exc.agregarFinal("CABA");
        res = map.devolverCaminoExceptuando("Catamarca", "CABA", exc);
        if (res != null)
            System.out.println(res);
    }
}
