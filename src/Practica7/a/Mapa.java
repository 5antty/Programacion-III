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

    // IMPLEMENTACION DE LA CATEDRA PARA DEVOLVER CAMINO
    public ListaGenerica<String> devolverCaminoC(String origen, String destino) {
        Vertice<String> vIni = null;
        Vertice<String> vFin = null;
        Grafo<String> aux = this.getMapaCiudades();
        boolean[] visitados = new boolean[aux.listaDeVertices().tamanio()];
        ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
        if (aux != null && !aux.esVacio()) {
            ListaGenerica<Vertice<String>> vertices = aux.listaDeVertices();
            vertices.comenzar();
            while (!vertices.fin()) {
                Vertice<String> vAux = vertices.proximo();
                if (vAux.dato().equals(origen))
                    vIni = vAux;
                if (vAux.dato().equals(destino))
                    vFin = vAux;
            }
            ListaGenerica<String> caminoAct = new ListaGenericaEnlazada<String>();
            if (vIni != null && vFin != null)
                dfsCamino(aux, vIni, vFin, caminoAct, camino, visitados);
        }
        return camino;
    }

    private void dfsCamino(Grafo<String> grafo, Vertice<String> vact, Vertice<String> vfin,
            ListaGenerica<String> caminoAct, ListaGenerica<String> camino, boolean[] marca) {
        caminoAct.agregarFinal(vact.dato());
        marca[vact.posicion()] = true;
        if (vact == vfin) {
            if (camino.esVacia() || camino.tamanio() > caminoAct.tamanio())
                copiarLista(caminoAct, camino);
        } else {
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(vact);
            ady.comenzar();
            while (!ady.fin()) {
                Vertice<String> vaux = ady.proximo().verticeDestino();
                if (!marca[vaux.posicion()])
                    dfsCamino(grafo, vaux, vfin, caminoAct, camino, marca);
            }
        }
    }

    public void copiarLista(ListaGenerica<String> origen, ListaGenerica<String> dest) {
        while (!dest.esVacia()) {
            dest.eliminarEn(0);
        }
        origen.comenzar();
        while (!origen.fin()) {
            dest.agregarFinal(origen.proximo());
        }
    }

    public ListaGenerica<String> devolverCaminoExceptuando(String city1, String city2, ListaGenerica<String> cities) {
        ListaGenericaEnlazada<String> res = new ListaGenericaEnlazada<String>();
        Grafo<String> aux = this.getMapaCiudades();
        boolean[] marca = new boolean[aux.listaDeVertices().tamanio()];

        Vertice<String> vIni = null;
        Vertice<String> vFin = null;

        if (aux != null && !aux.esVacio()) {
            ListaGenerica<Vertice<String>> vertices = aux.listaDeVertices();
            vertices.comenzar();
            while (!vertices.fin()) {
                Vertice<String> vAux = vertices.proximo();
                if (vAux.dato().equals(city1))
                    vIni = vAux;
                if (vAux.dato().equals(city2))
                    vFin = vAux;
            }
            if (vIni != null && vFin != null)
                dfsCaminoEx(this.getMapaCiudades(), vIni, vFin, res, marca, cities);
        }

        return res;
    }

    private boolean dfsCaminoEx(Grafo<String> grafo, Vertice<String> vact, Vertice<String> vfin,
            ListaGenerica<String> camino, boolean[] marca, ListaGenerica<String> ex) {
        marca[vact.posicion()] = true;
        if (vact == vfin) {
            camino.agregarFinal(vact.dato());
            return true;
        }
        if (ex.incluye(vact.dato())) {
            return false;
        }
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(vact);
        ady.comenzar();
        while (!ady.fin()) {
            Vertice<String> vaux = ady.proximo().verticeDestino();
            if (!marca[vaux.posicion()])
                if (dfsCaminoEx(grafo, vaux, vfin, camino, marca, ex)) {
                    camino.agregarInicio(vact.dato());
                    return true;
                }
        }
        return false;
    }

    public ListaGenerica<String> caminoMasCorto(String city1, String city2) {
        ListaGenerica<String> res = new ListaGenericaEnlazada<>();
        Grafo<String> aux = this.getMapaCiudades();
        boolean[] marca = new boolean[aux.listaDeVertices().tamanio()];
        Vertice<String> vIni = null;
        Vertice<String> vFin = null;
        if (aux != null && !aux.esVacio()) {
            ListaGenerica<Vertice<String>> vertices = aux.listaDeVertices();
            vertices.comenzar();
            while (!vertices.fin()) {
                Vertice<String> vAux = vertices.proximo();
                if (vAux.dato().equals(city1))
                    vIni = vAux;
                if (vAux.dato().equals(city2))
                    vFin = vAux;
            }
            if (vIni != null && vFin != null) {
                ListaGenerica<String> caminoAct = new ListaGenericaEnlazada<String>();
                dfsCaminoCorto(this.getMapaCiudades(), vIni, vFin, marca, caminoAct, res);
            }
        }
        return res;
    }

    private void dfsCaminoCorto(Grafo<String> grafo, Vertice<String> vact, Vertice<String> vfin, boolean[] marca,
            ListaGenerica<String> aux, ListaGenerica<String> res) {
        marca[vact.posicion()] = true;
        aux.agregarFinal(vact.dato());
        if (vact == vfin) {
            if (res.esVacia() || aux.tamanio() < res.tamanio())
                copiarLista(aux, res);
        } else {
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(vact);
            ady.comenzar();
            while (!ady.fin()) {
                Vertice<String> vaux = ady.proximo().verticeDestino();
                if (!marca[vaux.posicion()]) {
                    dfsCaminoCorto(grafo, vaux, vfin, marca, aux, res);
                    marca[vaux.posicion()] = false;
                    aux.eliminarEn(aux.tamanio() - 1);
                }
            }
        }
    }

    public ListaGenerica<String> caminoSinCargarCombustible(String city1, String city2, int tanque) {
        ListaGenerica<String> res = new ListaGenericaEnlazada<String>();
        Grafo<String> aux = this.getMapaCiudades();
        boolean[] marca = new boolean[aux.listaDeVertices().tamanio()];
        Vertice<String> vIni = null;
        Vertice<String> vFin = null;
        if (aux != null && !aux.esVacio()) {
            ListaGenerica<Vertice<String>> vertices = aux.listaDeVertices();
            vertices.comenzar();
            while (!vertices.fin()) {
                Vertice<String> vAux = vertices.proximo();
                if (vAux.dato().equals(city1))
                    vIni = vAux;
                if (vAux.dato().equals(city2))
                    vFin = vAux;
            }
            if (vIni != null && vFin != null) {
                ListaGenerica<String> caminoAct = new ListaGenericaEnlazada<String>();
                dfsSinCombustible(aux, vIni, vFin, marca, tanque, caminoAct, res);
            }
        }
        return res;
    }

    private void dfsSinCombustible(Grafo<String> grafo, Vertice<String> vact, Vertice<String> vfin, boolean[] marca,
            int tanque, ListaGenerica<String> aux, ListaGenerica<String> res) {
        marca[vact.posicion()] = true;
        aux.agregarFinal(vact.dato());
        if (tanque < 0)
            return;
        if (vact == vfin) {
            if (res.esVacia())
                copiarLista(aux, res);
        } else {
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(vact);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<String> arista = ady.proximo();
                Vertice<String> vaux = arista.verticeDestino();
                if (!marca[vaux.posicion()]) {
                    dfsSinCombustible(grafo, vaux, vfin, marca, tanque - arista.peso(), aux, res);
                    marca[vaux.posicion()] = false;
                    aux.eliminarEn(aux.tamanio() - 1);
                }
            }
        }
    }

    public ListaGenerica<String> caminoConMenorCargaDeCombustible(String city1, String city2, int tanque) {
        ListaGenerica<String> res = new ListaGenericaEnlazada<String>();
        Grafo<String> aux = this.getMapaCiudades();
        boolean[] marca = new boolean[aux.listaDeVertices().tamanio()];
        Vertice<String> vIni = null;
        Vertice<String> vFin = null;
        if (aux != null && !aux.esVacio()) {
            ListaGenerica<Vertice<String>> vertices = aux.listaDeVertices();
            vertices.comenzar();
            while (!vertices.fin()) {
                Vertice<String> vAux = vertices.proximo();
                if (vAux.dato().equals(city1))
                    vIni = vAux;
                if (vAux.dato().equals(city2))
                    vFin = vAux;
            }
            if (vIni != null && vFin != null) {
                Arista<String> ar = aux.listaDeAdyacentes(vIni).elemento(0);
                ListaGenerica<String> caminoAct = new ListaGenericaEnlazada<String>();
                dfsCaminoConCarga(aux, vIni, vFin, marca, tanque, tanque - ar.peso(), caminoAct, res);
            }
        }
        return res;
    }

    private void dfsCaminoConCarga(Grafo<String> grafo, Vertice<String> vact, Vertice<String> vfin, boolean[] marca,
            int tanque, int tanqueAct, ListaGenerica<String> aux, ListaGenerica<String> res) {
        marca[vact.posicion()] = true;
        aux.agregarFinal(vact.dato());
        if (tanque < 0)
            return;
        if (vact == vfin) {
            if (res.esVacia())
                copiarLista(aux, res);
        } else {
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(vact);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<String> arista = ady.proximo();
                Vertice<String> vaux = arista.verticeDestino();
                if (!marca[vaux.posicion()]) {
                    if (tanqueAct - arista.peso() > 0)
                        dfsCaminoConCarga(grafo, vaux, vfin, marca, tanque, tanqueAct - arista.peso(), aux, res);
                    else
                        dfsCaminoConCarga(grafo, vaux, vfin, marca, tanque, tanque - arista.peso(), aux, res);
                    marca[vaux.posicion()] = false;
                    aux.eliminarEn(aux.tamanio() - 1);
                }
            }
        }
    }
}
