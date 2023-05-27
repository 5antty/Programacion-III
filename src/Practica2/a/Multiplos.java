package Practica2.a;

import java.util.Scanner;

public class Multiplos {
	public static int[] getMultiplos(int n) {
		int[] mul = new int[n];
		for (int i = 0; i < n; i++) {
			mul[i] = n * (i + 1);
		}
		return mul;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese un numero ");
		int n = s.nextInt();
		s.close();
		getMultiplos(n);
		for (int i = 0; i < n; i++) {
			System.out.println(getMultiplos(n)[i]);
		}
	}

}
