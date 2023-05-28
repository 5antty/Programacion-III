package Practica7.a;

import estructuras.grafos.*;
import estructuras.*;

public class Recorridos<T> {
    public ListaGenerica<Vertice<T>> dfs(Grafo<T> grafo) {
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        ListaGenericaEnlazada<Vertice<T>> res = new ListaGenericaEnlazada<Vertice<T>>();
        for (int i = 0; i < marca.length; i++) {
            if (!marca[i])
                this.dfs(i, grafo, res, marca);
        }
        return res;
    }

    private void dfs(int i, Grafo<T> grafo, ListaGenericaEnlazada<Vertice<T>> lis, boolean[] marca) {
        marca[i] = true;
        Vertice<T> v = grafo.listaDeVertices().elemento(i);
        lis.agregarFinal(v);
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            int j = ady.proximo().verticeDestino().posicion();
            if (!marca[j])
                this.dfs(j, grafo, lis, marca);
        }
    }

    public ListaGenerica<Vertice<T>> bfs(Grafo<T> grafo) {
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        ListaGenericaEnlazada<Vertice<T>> res = new ListaGenericaEnlazada<Vertice<T>>();
        for (int i = 0; i < marca.length; i++) {
            if (!marca[i])
                this.bfs(i, grafo, marca, res);
        }
        return res;
    }

    private void bfs(int i, Grafo<T> grafo, boolean[] marca, ListaGenericaEnlazada<Vertice<T>> lis) {
        ListaGenerica<Arista<T>> ady = null;
        Cola<Vertice<T>> q = new Cola<Vertice<T>>();
        q.encolar(grafo.listaDeVertices().elemento(i));
        marca[i] = true;
        while (!q.esVacia()) {
            Vertice<T> v = q.desencolar();
            lis.agregarFinal(v);
            ady = grafo.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<T> arista = ady.proximo();
                int j = arista.verticeDestino().posicion();
                if (!marca[j]) {
                    Vertice<T> w = arista.verticeDestino();
                    marca[j] = true;
                    q.encolar(w);
                }
            }
        }
    }
}
