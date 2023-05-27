package Practica3.a;

import Practica3.a.clases.*;

public class TestOrdenamientos {

	public static void Imprimir(ListaDeEnteros l) {
		for (int i = 0; i < l.tamanio(); i++) {
			System.out.println(l.elemento(i));
		}
	}

	public static void main(String[] args) {
		ListaDeEnterosEnlazada l1 = new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada l2 = new ListaDeEnterosEnlazada();
		l1.agregarFinal(1);
		l1.agregarInicio(4);
		l1.agregarFinal(5);
		l1.agregarFinal(6);
		l2.agregarFinal(2);
		l2.agregarFinal(3);
		l2.agregarFinal(7);
		l2.agregarFinal(8);

		Imprimir(l1.ordenar().combinarOrdenado(l2));
	}

}
