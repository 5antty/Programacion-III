package Practica4.b;

import estructuras.*;

public class TestArbolBinario {
	/*
	 * public static int sumaIzq(ArbolBinario<Integer> arbol) {
	 * int suma =0;
	 * suma= arbol.getDato();
	 * if(arbol.tieneHijoIzquierdo()&&!arbol.getHijoIzquierdo().esVacio())
	 * suma+=sumaIzq(arbol.getHijoIzquierdo());
	 * return suma;
	 * }
	 * public static int sumaDer(ArbolBinario<Integer> arbol) {
	 * int suma =0;
	 * suma= arbol.getDato();
	 * if(arbol.tieneHijoDerecho()&&!arbol.getHijoDerecho().esVacio())
	 * suma+=sumaDer(arbol.getHijoDerecho());
	 * return suma;
	 * }
	 * public static int sumaMaxVertical(ArbolBinario<Integer> arbol) {
	 * int suma=0, sumaIzq=0, sumaDer=0;
	 * if(arbol.tieneHijoIzquierdo()&&!arbol.getHijoIzquierdo().esVacio()) {
	 * sumaIzq+=sumaIzq(arbol.getHijoIzquierdo());
	 * sumaDer+=sumaDer(arbol.getHijoIzquierdo());
	 * }
	 * if(arbol.tieneHijoDerecho()&&!arbol.getHijoDerecho().esVacio()) {
	 * sumaIzq+=sumaIzq(arbol.getHijoDerecho());
	 * sumaDer+=sumaDer(arbol.getHijoDerecho());
	 * }
	 * if(sumaIzq>sumaDer)
	 * return sumaIzq;
	 * return sumaDer;
	 * }
	 */
	public static int sumaMaxVertical(ArbolBinario<Integer> a) {
		int sumaIzq = 0, sumaDer = 0;
		if (a.esVacio()) {
			return 0;
		}
		if (a.tieneHijoIzquierdo() && !a.getHijoIzquierdo().esVacio())
			sumaIzq += sumaMaxVertical(a.getHijoIzquierdo());
		if (a.tieneHijoDerecho() && !a.getHijoDerecho().esVacio())
			sumaDer += sumaMaxVertical(a.getHijoDerecho());
		return a.getDato() + Math.max(sumaIzq, sumaDer);
	}

	public static int sumaMaxHorizontal(ArbolBinario<Integer> a) {
		ArbolBinario<Integer> arbol = null;
		Cola<ArbolBinario<Integer>> cola = new Cola<ArbolBinario<Integer>>();
		ListaGenericaEnlazada<Integer> l = new ListaGenericaEnlazada<Integer>();
		int suma = 0;
		// boolean lleno =true;
		cola.encolar(a);
		cola.encolar(null);
		// int nivel = 0;
		while (!cola.esVacia()/* &&lleno */) {
			arbol = cola.desencolar();
			if (arbol != null) {
				suma += arbol.getDato();
				if (arbol.tieneHijoIzquierdo() && !arbol.getHijoIzquierdo().esVacio()) {
					cola.encolar(arbol.getHijoIzquierdo());
				}
				if (arbol.tieneHijoDerecho() && !arbol.getHijoDerecho().esVacio()) {
					cola.encolar(arbol.getHijoDerecho());
				}
			} else if (!cola.esVacia()) {
				// falta condicion para que guarde en la lista la suma del ultimo nivel
				l.agregarFinal(suma);
				suma = 0;
				cola.encolar(null);
			}
		}
		int max = -1;
		for (int i = 0; i < l.tamanio(); i++) {
			if (l.elemento(i) > max)
				max = l.elemento(i);
		}
		return max;
	}

	public static void main(String[] args) {
		// ArbolBinario<Integer> a =new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> arbolBinarioB = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> hijoIzquierdoB = new ArbolBinario<Integer>(2);
		hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		hijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<Integer>(4));
		ArbolBinario<Integer> hijoDerechoB = new ArbolBinario<Integer>(6);
		hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
		hijoDerechoB.agregarHijoDerecho(new ArbolBinario<Integer>(8));
		arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
		arbolBinarioB.agregarHijoDerecho(hijoDerechoB);
		// arbolBinarioB.printPreorden();
		System.out.println(arbolBinarioB.contarHojas());
		// ej4a dentro de la clase arbol binario
		// ej4b fuera de la clase arbol
		if (arbolBinarioB.esLleno()) {
			System.out.println("Es lleno");
		} else
			System.out.println("No es lleno");
		System.out.println(sumaMaxVertical(arbolBinarioB));
		// System.out.println(sumaMaxHorizontal(arbolBinarioB));
	}

}
