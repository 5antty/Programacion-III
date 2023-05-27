package Practica3.a;

import Practica3.a.clases.*;

public class ListaDeEnterosEnlazadaTestBasico {
	public static void ImprimirReves(ListaDeEnteros l) {
		l.comenzar();
		ImprimirRecursivo(l);
		// Integer n = l.elemento(pos);

	}

	public static void ImprimirRecursivo(ListaDeEnteros l) {
		if (!l.fin()) {
			Integer aux = l.proximo();
			ImprimirRecursivo(l);
			System.out.println(aux);
		}
	}

	// listas genericas no aceptan tipos de datos primitivos, solo objetos, por eso
	// utilizar wrappers
	public static void Imprimir2(ListaDeEnterosEnlazada l) {
		l.comenzar();
		while (!l.fin()) {
			System.out.print(l.proximo() + " ");
		}
	}

	public static void Imprimir(ListaDeEnterosEnlazada l) {
		for (int i = 0; i < l.tamanio(); i++) {
			System.out.println(l.elemento(i));
		}
	}

	public static void main(String[] args) {
		ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
		// Instanciar como superclase
		l.agregarInicio(10);
		l.agregarFinal(36);
		l.agregarFinal(35);
		l.agregarFinal(7);
		l.agregarFinal(23);
		// System.out.println(l.toString());
		// ImprimirReves(l);
		// Imprimir(l);
		System.out.println(" ");
		Imprimir(l.ordenar());
	}

}
