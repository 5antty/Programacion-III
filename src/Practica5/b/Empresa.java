package Practica5.b;

import estructuras.*;

public class Empresa {

	private ArbolGeneral<Empleado> empleados;

	public ListaGenerica<Integer> cat(int nivelP) {
		ArbolGeneral<Empleado> arbolAux = null;
		Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
		ListaGenericaEnlazada<ArbolGeneral<Empleado>> l = new ListaGenericaEnlazada<ArbolGeneral<Empleado>>();
		ListaGenerica<Integer> aux = new ListaGenericaEnlazada<Integer>();
		cola.encolar(this.empleados);
		cola.encolar(null);
		// int nivel = 0;

		// int max=1;
		while (!cola.esVacia()) {
			arbolAux = cola.desencolar();
			int cantNodos = 0;
			if (arbolAux != null) {

				if (arbolAux.tieneHijos()) {
					l = arbolAux.getHijos();
					while (!l.fin()) {
						cantNodos++;
						cola.encolar(l.proximo());
					}
					aux.agregarFinal(cantNodos);
				}
			} else if (!cola.esVacia()) {
				// nivel++;
				cola.encolar(null);
			}
		}
		return aux;
	}

	/*
	 * public ListaGenerica<Integer> cat( int nivelP) {
	 * ArbolGeneral<Empleado> arbolAux = null;
	 * Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
	 * ListaGenericaEnlazada<ArbolGeneral<Empleado>> l = new
	 * ListaGenericaEnlazada<ArbolGeneral<Empleado>>();
	 * ListaGenerica<Empleado> emp = new ListaGenericaEnlazada<Empleado>();
	 * cola.encolar(this.empleados);
	 * cola.encolar(null);
	 * int nivel =0;
	 * int cantNodos=0;
	 * //int max=1;
	 * while(!cola.esVacia()) {
	 * arbolAux = cola.desencolar();
	 * 
	 * if(arbolAux!=null) {
	 * if(nivel==nivelP && arbolAux.tieneHijos()) {
	 * l = arbolAux.getHijos();
	 * while(!l.fin()) {
	 * cantNodos++;
	 * cola.encolar(l.proximo());
	 * }
	 * }
	 * } else if(!cola.esVacia()) {
	 * if (nivel == nivelP)
	 * return cantNodos;
	 * nivel++;
	 * cola.encolar(null);
	 * }
	 * }
	 * return cantNodos;
	 * }
	 */

	public int ancho(ArbolGeneral<Empleado> arbol) {
		ArbolGeneral<Empleado> arbolAux = null;
		Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
		ListaGenericaEnlazada<ArbolGeneral<Empleado>> l = new ListaGenericaEnlazada<ArbolGeneral<Empleado>>();
		cola.encolar(arbol);
		cola.encolar(null);
		int max = -1;
		int maxNodos = -1;
		int nivel = 0;
		while (!cola.esVacia()) {
			arbolAux = cola.desencolar();
			int cantNodos = 0;
			if (arbolAux != null) {
				if (arbolAux.tieneHijos()) {
					l = arbolAux.getHijos();
					while (!l.fin()) {
						cantNodos++;
						cola.encolar(l.proximo());
					}
				}
			} else if (!cola.esVacia()) {
				if (cantNodos > maxNodos) {
					maxNodos = cantNodos;
					max = nivel;
				}
				nivel++;
				cola.encolar(null);
			}
		}
		return max;
	}

	public static int cantidadEmpleados(ArbolGeneral<Empleado> arbol) {
		ArbolGeneral<Empleado> arbolAux = null;
		Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
		ListaGenericaEnlazada<ArbolGeneral<Empleado>> l = new ListaGenericaEnlazada<ArbolGeneral<Empleado>>();
		cola.encolar(arbol);
		cola.encolar(null);
		int cantNodos = 0;
		while (!cola.esVacia()) {
			arbolAux = cola.desencolar();
			if (arbolAux != null) {
				if (arbolAux.tieneHijos()) {
					l = arbolAux.getHijos();
					while (!l.fin()) {
						cantNodos++;
						cola.encolar(l.proximo());
					}
				}
			} else if (!cola.esVacia()) {
				cola.encolar(null);
			}
		}
		return cantNodos;
	}

	public void reemplazarPresidente() {

	}
}
