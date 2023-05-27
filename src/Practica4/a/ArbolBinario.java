package Practica4.a;

import estructuras.*;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;
	private ArbolBinario<T> hijoDerecho;

	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo != null;
	}

	public boolean tieneHijoDerecho() {
		return this.hijoDerecho != null;
	}

	public boolean esLleno() {
		ArbolBinario<T> arbol = null;
		Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();
		boolean lleno = true;
		cola.encolar(this);
		int cantNodos = 0;
		cola.encolar(null);
		int nivel = 0;
		while (!cola.esVacia() && lleno) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if (arbol.tieneHijoIzquierdo() && !arbol.getHijoIzquierdo().esVacio()) {
					cola.encolar(arbol.getHijoIzquierdo());
					cantNodos++;
				}
				if (arbol.tieneHijoDerecho() && !arbol.getHijoDerecho().esVacio()) {
					cola.encolar(arbol.getHijoDerecho());
					cantNodos++;
				}
			} else if (!cola.esVacia()) {
				if (cantNodos == Math.pow(2, ++nivel)) {
					cola.encolar(null);
					cantNodos = 0;
				} else
					lleno = false;
			}
		}
		return lleno;
	}

	boolean esCompleto() {
		return false;
	}

	// imprime el arbol en preorden
	public void printPreorden() {
		System.out.println(this.getDato());
		if (this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().printPreorden();
		if (this.tieneHijoDerecho())
			this.getHijoDerecho().printPreorden();
	}

	// imprime el arbol en postorden
	public void printInorden() {
		if (this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().printPreorden();
		System.out.println(this.getDato());
		if (this.tieneHijoDerecho())
			this.getHijoDerecho().printPreorden();
	}

	// imprime el arbol en postorden
	public void printPostorden() {
		if (this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().printPreorden();
		if (this.tieneHijoDerecho())
			this.getHijoDerecho().printPreorden();
		System.out.println(this.getDato());
	}

	public void recorridoPorNiveles() {

	}

	private void fRecursivo(ListaGenerica<T> listaf) {
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().fRecursivo(listaf);
		}
		if (this.esHoja()) {
			listaf.agregarFinal(this.getDato());
		}
		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().fRecursivo(listaf);
		}
	}

	public ListaGenerica<T> frontera() {
		ListaGenerica<T> l = new ListaGenericaEnlazada<T>();
		fRecursivo(l);
		return l;
	}

	public void recursivo(ArbolBinario<T> a, int cant) {
		if (this.esHoja()) {
			cant++;
		}
		if (this.tieneHijoIzquierdo())
			this.recursivo(a.getHijoIzquierdo(), cant);
		if (this.tieneHijoDerecho())
			this.recursivo(a.getHijoDerecho(), cant);

	}

	public int contarHojas() {
		int hojas = 0;
		if (this.esHoja())
			return 1;
		if (this.tieneHijoIzquierdo())
			hojas = this.getHijoIzquierdo().contarHojas();
		if (this.tieneHijoDerecho())
			hojas += this.getHijoDerecho().contarHojas();
		return hojas;
	}

}
