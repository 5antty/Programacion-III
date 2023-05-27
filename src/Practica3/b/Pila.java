package Practica3.b;

import estructuras.ListaGenericaEnlazada;

public class Pila<T> {
	private ListaGenericaEnlazada<T> pila;

	public Pila() {
		pila = new ListaGenericaEnlazada<T>();
		// TODO Auto-generated constructor stub
	}

	public void apilar(T elem) {
		pila.agregarInicio(elem);
	}

	public T desapilar() {
		pila.comenzar();
		T aux = pila.proximo();
		pila.eliminar(aux);
		return aux;
	}

	public T tope() {
		return pila.elemento(0);
	}

	public boolean esVacia() {
		return (pila.tamanio() == 0);
	}
}
