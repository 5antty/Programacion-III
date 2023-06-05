package Practica7.a;

import estructuras.grafos.*;
import estructuras.ListaGenerica;

public class Algoritmos<T> {
    public boolean subgrafoCuadrado(Grafo<T> grafo) {
        boolean cond = false;

        if (!grafo.esVacio()) {
            AlgAux cont = new AlgAux();
            boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
            for (int i = 0; i < marca.length; i++) {
                if (!marca[i]) {
                    cont.setGrado(0);
                    if (subgrafoCuadrado(i, grafo, marca, enRecursion) == 4)
                        return true;
                }
            }
        }

        return cond;
    }

    private int subgrafoCuadrado(int i, Grafo<T> grafo, boolean[] marca, boolean[] enRecursion) {
        marca[i] = true;
        enRecursion[i] = true;
        int aux = 0;
        if(){
            
        }

        Vertice<T> v = grafo.listaDeVertices().elemento(i);
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();

        while (!ady.fin()) {
            int j = ady.proximo().verticeDestino().posicion();
            if (!marca[j]) {
                aux += subgrafoCuadrado(j, grafo, marca, enRecursion);
                if (aux > 0)
                    return aux + 1;
            } else if (enRecursion[j]) {
                return 1;
            }
        }
        enRecursion[i] = false;
        return aux;
    }
}
