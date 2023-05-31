package Practica7.a;

import estructuras.*;
import estructuras.grafos.*;

public class Mapa {
    private Grafo<String> mapaCiudades;

    public Mapa() {
        mapaCiudades = new GrafoImplListAdy<String>();
    }

    public Grafo<String> getMapaCiudades() {
        return mapaCiudades;
    }

    public void setMapaCiudades(Grafo<String> mapaCiudades) {
        this.mapaCiudades = mapaCiudades;
    }

    // private ListaGenerica<String> devolverCaminoExc(String city1, String city2) {
    // ListaGenericaEnlazada<String> res = new ListaGenericaEnlazada<String>();
    // boolean[] marca = new
    // boolean[this.getMapaCiudades().listaDeVertices().tamanio()];

    // ListaGenerica<Vertice<String>> lis = new
    // ListaGenericaEnlazada<Vertice<String>>();
    // ListaGenerica<Arista<String>> ady = null;
    // Cola<Vertice<String>> q = new Cola<Vertice<String>>();

    // // implementar el while hasta que el dato del vertice sea la city1
    // ListaGenerica<Vertice<String>> aux1 =
    // this.getMapaCiudades().listaDeVertices();
    // aux1.comenzar();
    // Vertice<String> aux2 = aux1.proximo();
    // while (!aux1.fin() && !(aux2.dato().equals(city1))) {
    // aux2 = aux1.proximo();
    // }

    // q.encolar(aux2);
    // marca[aux2.posicion()] = true;

    // while (!q.esVacia()) {
    // Vertice<String> cityActual = q.desencolar();
    // // Agrego la ciudad a la lista de ciudades
    // lis.agregarFinal(cityActual);

    // if (cityActual.dato().equals(city2))
    // break;

    // ady = this.getMapaCiudades().listaDeAdyacentes(cityActual);
    // ady.comenzar();
    // while (!ady.fin()) {
    // Arista<String> arista = ady.proximo();
    // int j = arista.verticeDestino().posicion();
    // if (!marca[j]) {
    // Vertice<String> w = arista.verticeDestino();
    // marca[j] = true;
    // q.encolar(w);
    // }
    // }
    // }

    // lis.comenzar();
    // Vertice<String> cityAct;
    // while (!lis.fin()) {
    // cityAct = lis.proximo();
    // res.agregarFinal(cityAct.dato());
    // }

    // // T(n) de un alg de un grafo se anota O(|V|+|E|)
    // return res;
    // }

    public ListaGenerica<String> devolverCamino(String city1, String city2) {
        ListaGenericaEnlazada<String> res = new ListaGenericaEnlazada<String>();
        boolean[] marca = new boolean[this.getMapaCiudades().listaDeVertices().tamanio()];
        ListaGenerica<Vertice<String>> aux1 = this.getMapaCiudades().listaDeVertices();
        aux1.comenzar();
        Vertice<String> aux2 = aux1.proximo();
        while (!aux1.fin() && !(aux2.dato().equals(city1))) {
            aux2 = aux1.proximo();
        }
        int i = aux2.posicion();
        if (i < marca.length)
            devolverCamino(i, this.getMapaCiudades(), res, marca, city2);
        return res;
    }

    private boolean devolverCamino(int i, Grafo<String> grafo,
            ListaGenericaEnlazada<String> lis, boolean[] marca,
            String city2) {
        marca[i] = true;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        if (v.dato().equals(city2)) {
            lis.agregarFinal(v.dato());
            return true;
        }
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            int j = ady.proximo().verticeDestino().posicion();
            if (!marca[j])
                if (!this.devolverCamino(j, grafo, lis, marca, city2))
                    lis.agregarInicio(v.dato());
        }
        return false;
    }

    public ListaGenerica<String> devolverCaminoExceptuando(String city1, String city2, ListaGenerica<String> cities) {
        ListaGenericaEnlazada<String> res = new ListaGenericaEnlazada<String>();
        boolean[] marca = new boolean[this.getMapaCiudades().listaDeVertices().tamanio()];
        ListaGenerica<Vertice<String>> aux1 = this.getMapaCiudades().listaDeVertices();
        aux1.comenzar();
        Vertice<String> aux2 = aux1.proximo();
        while (!aux1.fin() && !(aux2.dato().equals(city1))) {
            aux2 = aux1.proximo();
        }
        int j = aux2.posicion();

        for (int i = 0; i < cities.tamanio(); i++) {
            this.dceRecu(j, this.getMapaCiudades(), marca, res, cities.elemento(i));
        }
        return res;
    }

    private boolean dceRecu(int i, Grafo<String> grafo, boolean[] marca, ListaGenericaEnlazada<String> lis,
            String cities) {
        marca[i] = true;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        if (v.dato().equals(cities) && !lis.incluye(v.dato())) {
            // lis.agregarFinal(v.dato());
            return true;
        }
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            int j = ady.proximo().verticeDestino().posicion();
            if (!marca[j]) {
                if (!this.dceRecu(j, grafo, marca, lis, cities) && !lis.incluye(v.dato()))
                    lis.agregarInicio(v.dato());
            }
        }
        return false;
    }
}
