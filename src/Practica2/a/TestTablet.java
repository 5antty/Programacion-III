package Practica2.a;

public class TestTablet {

	public static void main(String[] args) {
		Tablet[] t = new Tablet[3];
		t[0] = new Tablet();
		t[0].setCosto(34);
		t[0].setMarca("Samsung");
		t[0].setModelo("Tab s2");
		t[0].setPulgadas(12);
		t[0].setSo("Android");
		t[1] = new Tablet();
		t[1].setCosto(32.5);
		t[1].setMarca("Motorola");
		t[1].setModelo("Razr");
		t[1].setPulgadas(10);
		t[1].setSo("Android");
		t[2] = new Tablet();
		t[2].setCosto(100.0);
		t[2].setMarca("Apple");
		t[2].setModelo("I pad");
		t[2].setPulgadas(14);
		t[2].setSo("IOS");

		for (int i = 0; i < 3; i++) {
			System.out.println(t[i].devolverDatos());
		}
	}

}
