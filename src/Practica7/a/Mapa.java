package Practica7.a;

import estructuras.*;
import estructuras.grafos.*;

public class Mapa {
    public Grafo<String> mapaCiudades;

    public Mapa() {
        mapaCiudades = new GrafoImplListAdy<String>();
    }

    public ListaGenericaEnlazada<String> devolverCamino(String city1, String city2) {
        ListaGenericaEnlazada<String> res = new ListaGenericaEnlazada<String>();
        Grafo<String> aux = this.mapaCiudades;
        boolean[] marca = new boolean[aux.listaDeVertices().tamanio()];

        ListaGenerica<Vertice<String>> lis = new ListaGenericaEnlazada<Vertice<String>>();
        ListaGenerica<Arista<String>> ady = null;
        Cola<Vertice<String>> q = new Cola<Vertice<String>>();

        // implementar el while hasta que el dato del vertice sea la city1
        ListaGenerica<Vertice<String>> aux1 = aux.listaDeVertices();
        Vertice<String> aux2 = aux1.proximo();
        while (!aux1.fin() && !(aux2.dato().equals(city1))) {
            aux2 = aux1.proximo();
        }

        q.encolar(aux2);
        marca[aux2.posicion()] = true;
        while (!q.esVacia()) {
            Vertice<String> cityActual = q.desencolar();
            // Agrego la ciudad a la lista de ciudades
            lis.agregarFinal(cityActual);

            if (cityActual.dato().equals(city2))
                break;

            ady = aux.listaDeAdyacentes(cityActual);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<String> arista = ady.proximo();
                int j = arista.verticeDestino().posicion();
                if (!marca[j]) {
                    Vertice<String> w = arista.verticeDestino();
                    marca[j] = true;
                    q.encolar(w);
                }
            }
        }
        lis.comenzar();
        Vertice<String> cityAct = lis.proximo();

        while (!lis.fin()) {
            res.agregarFinal(cityAct.dato());
            cityAct = lis.proximo();
        }

        // T(n) de un alg de un grafo se anota O(|V|+|E|)
        return res;
    }
}