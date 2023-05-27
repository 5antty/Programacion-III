package Practica5.a;

import estructuras.*;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenericaEnlazada<ArbolGeneral<T>> hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenericaEnlazada<ArbolGeneral<T>> hijos) {
		this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
		this.hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();
	}

	public ArbolGeneral(T dato, ListaGenericaEnlazada<ArbolGeneral<T>> hijos) {
		this(dato);
		this.hijos = hijos;
	}

	public ListaGenericaEnlazada<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}

	public boolean tieneHijos() {
		return this.hijos != null && !this.hijos.esVacia();
	}

	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo))
				hijos.eliminar(hijo);
		}
	}

	public Integer altura() {
		ArbolGeneral<T> arbol = null;
		Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
		ListaGenericaEnlazada<ArbolGeneral<T>> l = new ListaGenericaEnlazada<ArbolGeneral<T>>();
		cola.encolar(this);
		cola.encolar(null);
		int nivel = 0;
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if (arbol.tieneHijos()) {
					l = arbol.getHijos();
					while (!l.fin()) {
						cola.encolar(l.proximo());
					}
				}
			} else if (!cola.esVacia()) {
				nivel++;
				cola.encolar(null);
			}
		}
		return nivel;
	}

	public ListaGenericaEnlazada<T> preOrden() {
		ListaGenericaEnlazada<T> lis = new ListaGenericaEnlazada<T>();
		this.preOrden(lis);
		return lis;
	}

	private void preOrden(ListaGenericaEnlazada<T> l) {
		l.agregarFinal(this.getDato());
		ListaGenericaEnlazada<ArbolGeneral<T>> lhijos = this.getHijos();
		lhijos.comenzar();
		while (!lhijos.fin()) {
			(lhijos.proximo()).preOrden(l);
		}
	}

	public boolean include(T dato) {
		ListaGenericaEnlazada<T> l = this.preOrden();
		return l.incluye(dato);
	}

	public Integer nivel(T dato) {
		int nivel = 0;
		// falta implementar
		if (this.getDato().equals(dato))
			return 0;
		else {
			ListaGenericaEnlazada<ArbolGeneral<T>> hijos = this.getHijos();
			ArbolGeneral<T> unHijo = null;
			nivel = 0;
			hijos.comenzar();
			while (!hijos.fin()) {
				unHijo = hijos.proximo();

				nivel = unHijo.nivel(dato);
			}
		}
		return nivel + 1;
	}

	public Integer ancho() {
		ArbolGeneral<T> arbol = null;
		Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
		ListaGenericaEnlazada<ArbolGeneral<T>> l = new ListaGenericaEnlazada<ArbolGeneral<T>>();
		cola.encolar(this);
		cola.encolar(null);
		int max = 1;
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			int cantNodos = 0;
			if (arbol != null) {
				if (arbol.tieneHijos()) {
					l = arbol.getHijos();
					while (!l.fin()) {
						cantNodos++;
						cola.encolar(l.proximo());
					}
				}
			} else if (!cola.esVacia()) {
				if (cantNodos > max) {
					max = cantNodos;
				}
				cola.encolar(null);
			}
		}
		return max;
	}

	public Integer cat(int nivelP) {
		ArbolGeneral<T> arbol = null;
		Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
		ListaGenericaEnlazada<ArbolGeneral<T>> l = new ListaGenericaEnlazada<ArbolGeneral<T>>();
		cola.encolar(this);
		cola.encolar(null);
		int nivel = 0;
		int cantNodos = 0;
		// int max=1;
		while (!cola.esVacia()) {
			arbol = cola.desencolar();

			if (arbol != null) {
				if (nivel == nivelP)
					cantNodos++;
				else if (arbol.tieneHijos()) {
					l = arbol.getHijos();
					while (!l.fin()) {
						cola.encolar(l.proximo());
					}
				}
			} else {
				if (nivel == nivelP) {
					return cantNodos;
				}

				else if (!cola.esVacia()) {
					nivel++;
					cola.encolar(null);
				}
			}
		}
		return cantNodos;
	}

}