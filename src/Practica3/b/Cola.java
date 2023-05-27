package Practica3.b;

import estructuras.ListaGenericaEnlazada;

public class Cola<T> {
	private ListaGenericaEnlazada<T> cola;

	public Cola() {
		cola = new ListaGenericaEnlazada<T>();
		// en el constructor creo la lista
	}

	public void encolar(T elem) {
		cola.agregarFinal(elem);
	}

	public T desencolar() {
		cola.comenzar();
		T aux = cola.proximo();
		cola.eliminarEn(0);
		return aux;
	}

	public T tope() {
		return cola.elemento(0);
	}

	public boolean esVacia() {
		return cola.tamanio() == 0;
	}
}
