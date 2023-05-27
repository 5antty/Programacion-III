package Practica5.a;

import estructuras.*;

public class camino {
	public static void caminoMasLargo(ArbolBinario<Character> a) {
		ListaGenerica<Character> caminoActual = new ListaGenericaEnlazada<Character>();
		ListaGenerica<Character> caminoMax = new ListaGenericaEnlazada<Character>();
		if (a != null && !a.esVacio()) {
			caminoActual.agregarFinal(a.getDato());
			caminoMasLargoRec(caminoActual, caminoMax, a);
			caminoActual.eliminarEn(caminoActual.tamanio() - 1);
		}
	}

	private static void caminoMasLargoRec(ListaGenerica<Character> caminoActual, ListaGenerica<Character> caminoMax,
			ArbolBinario<Character> arbol) {
		if (arbol.esHoja()) {
			if (caminoActual.tamanio() > caminoMax.tamanio())
				copiarLista(caminoActual, caminoMax);
		} else {
			if (arbol.tieneHijoIzquierdo()) {
				caminoActual.agregarFinal(arbol.getHijoIzquierdo().getDato());
				caminoMasLargoRec(caminoActual, caminoMax, arbol.getHijoIzquierdo());
				caminoActual.eliminarEn(caminoActual.tamanio() - 1);
			}
			if (arbol.tieneHijoIzquierdo()) {
				caminoActual.agregarFinal(arbol.getHijoIzquierdo().getDato());
				caminoMasLargoRec(caminoActual, caminoMax, arbol.getHijoIzquierdo());
				caminoActual.eliminarEn(caminoActual.tamanio() - 1);
			}
		}
	}

	private static void copiarLista(ListaGenerica<Character> caminoActual, ListaGenerica<Character> caminoMax) {
		while (!caminoMax.esVacia()) {
			caminoMax.eliminarEn(0);
		}
		caminoActual.comenzar();
		while (!caminoActual.fin()) {
			caminoMax.agregarFinal(caminoActual.proximo());
		}
	}

}
