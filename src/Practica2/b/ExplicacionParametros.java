package Practica2.b;

//Escirbir un metodo de clase que reciba un arreglo de enteros
//y devuelve la suma de sus elementos. hacer de dos formas distintas.
//No se puede devolver arreglos.
public class ExplicacionParametros {
	public static int sumaArreglos(int[] arreglo) {
		int suma = 0;
		/*
		 * for (int i=0; i<arreglo.length; i++) {
		 * suma+=arreglo[i];
		 * }
		 */
		for (int i : arreglo) {
			suma += i;
		}
		return suma;
	}

	public static void sumaArreglos2(int[] arreglo, int resultado) {
		int suma = 0;
		for (int i : arreglo) {
			suma += i;
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4 };
		System.out.println(sumaArreglos(a));
	}

}
