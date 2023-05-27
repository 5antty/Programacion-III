package Practica2.a;

public class IteradorAB {

	public void iteracionConFor(int a, int b) {
		for (int i = a; i <= b; i++) {
			System.out.println(i);
		}
	}

	public void iteracionConWhile(int a, int b) {
		int i = a;
		while (i <= b) {
			System.out.println(i);
			i++;
		}
	}

	public int recursivo(int a, int b) {
		int i = a;
		if (i == b) {
			return b;
		} else
			return recursivo(i, b);
	}

	public static void main(String[] args) {
		IteradorAB it = new IteradorAB();
		it.iteracionConFor(1, 5);
		it.iteracionConWhile(1, 5);
	}

}
