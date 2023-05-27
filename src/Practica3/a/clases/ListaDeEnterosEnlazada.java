package Practica3.a.clases;

/**
 * La clase ListaDeEnterosEnlazada es una ListaDeEnteros, donde los elementos de
 * la lista (nodos) referencian al siguiente elemento (nodo), por este motivo,
 * la ListaDeEnterosEnlazada no tiene límite en la cantidad de elementos que se
 * pueden almacenar.
 */
public class ListaDeEnterosEnlazada extends ListaDeEnteros {
	/* primer nodo de la lista, si la lista esta vacia, inicio es null */
	private NodoEntero inicio;

	/*
	 * nodo actual que se va actualizando a medida que recorremos la lista, si
	 * la lista esta vacia, actual es null
	 */
	private NodoEntero actual;

	/* ultimo nodo de la lista, si la lista esta vacia, fin es null */
	private NodoEntero fin;

	/* cantidad de nodos en la lista */
	private int tamanio;

	@Override
	public void comenzar() {
		actual = inicio;
	}

	@Override
	public Integer proximo() {
		Integer elem = this.actual.getDato();
		this.actual = this.actual.getSiguiente();
		return elem;
	}

	@Override
	public boolean fin() {
		return (this.actual == null);
	}

	@Override
	public Integer elemento(int pos) {
		if (pos < 0 || pos > this.tamanio() - 1) // no es posicion valida
			return null;
		NodoEntero n = this.inicio;
		while (pos-- > 0)
			n = n.getSiguiente();
		return n.getDato();
	}

	@Override
	public boolean agregarEn(Integer elem, int pos) {
		if (pos < 0 || pos > this.tamanio()) // posicion no valida
			return false;
		this.tamanio++;
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);
		if (pos == 0) { // inserta al principio
			aux.setSiguiente(inicio);
			this.inicio = aux;
		} else {
			NodoEntero n = this.inicio;
			NodoEntero ant = null;
			int posActual = 0;
			while (!(n == null) && (posActual < pos)) {
				ant = n;
				n = n.getSiguiente();
				posActual++;
			}
			aux.setSiguiente(n);
			ant.setSiguiente(aux);

			if (aux.getSiguiente() == null)
				this.fin = aux;
		}
		return true;
	}

	@Override
	public boolean agregarInicio(Integer elem) {
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);

		if (this.inicio == null) {
			this.inicio = aux;
			this.actual = aux;
			this.fin = aux;
		} else {
			aux.setSiguiente(this.inicio);
			this.inicio = aux;
		}
		this.tamanio++;
		return true;
	}

	@Override
	public boolean agregarFinal(Integer elem) {
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);
		if (this.inicio == null) {
			this.inicio = aux;
			this.actual = aux;
			this.fin = aux;
		} else {
			fin.setSiguiente(aux);
			fin = aux;
		}
		tamanio++;
		return true;
	}

	@Override
	public boolean eliminar(Integer elem) {
		NodoEntero n = this.inicio;
		NodoEntero ant = null;
		while ((n != null) && (!n.getDato().equals(elem))) {
			ant = n;
			n = n.getSiguiente();
		}
		if (n == null)
			return false;
		else {
			if (ant == null)
				this.inicio = this.inicio.getSiguiente();
			else
				ant.setSiguiente(n.getSiguiente());
			this.tamanio--;

			return true;
		}
	}

	@Override
	public boolean eliminarEn(int pos) {
		if (pos < 0 || pos > this.tamanio() - 1) // posicion no valida
			return false;
		this.tamanio--;
		if (pos == 0) {
			this.inicio = this.inicio.getSiguiente();
			return true;
		}
		NodoEntero n = this.inicio;
		NodoEntero ant = null;
		while (!(n == null) && (pos > 0)) {
			pos--;
			ant = n;
			n = n.getSiguiente();
		}
		ant.setSiguiente(n.getSiguiente());
		if (ant.getSiguiente() == null)
			this.fin = ant;
		return true;
	}

	@Override
	public boolean incluye(Integer elem) {
		NodoEntero n = this.inicio;
		while (!(n == null) && !(n.getDato().equals(elem)))
			n = n.getSiguiente();
		return !(n == null);
	}

	@Override
	public String toString() {
		String str = "";
		NodoEntero n = this.inicio;
		while (n != null) {
			str = str + n.getDato() + " -> ";
			n = n.getSiguiente();
		}
		if (str.length() > 1)
			str = str.substring(0, str.length() - 4);
		return str;
	}

	@Override
	public int tamanio() {
		return this.tamanio;
	}

	@Override
	public boolean esVacia() {
		return this.tamanio() == 0;
	}

	public int Menor(int n1, int n2) {
		if (n1 < n2) {
			return n1;
		}
		return n2;
	}

	public boolean MenorQue(int a, int b) {
		if (a < b) {
			return true;
		}
		return false;
	}

	/*
	 * public ListaDeEnterosEnlazada ordenar() {
	 * ListaDeEnterosEnlazada lo= new ListaDeEnterosEnlazada();
	 * int i=0;
	 * Integer aux, max=99999;
	 * lo.comenzar();
	 * lo.agregarInicio(max);
	 * int tam=this.tamanio();
	 * while(i<tam) {
	 * 
	 * aux=this.elemento(i);
	 * if(MenorQue(aux, lo.elemento(i))) {
	 * lo.agregarFinal(aux);
	 * }
	 * else {
	 * lo.agregarInicio(aux);
	 * }
	 * i++;
	 * }
	 * return lo;
	 * }
	 * public ListaDeEnterosEnlazada ordenar5() {
	 * ListaDeEnterosEnlazada lo= this;
	 * int aux, tam=this.tamanio();
	 * for(int i=0; i<tam; i++) {
	 * for(int j=0; j<tam-i;j++) {
	 * if(lo.elemento(j)>lo.elemento(j+1)) {
	 * aux=this.elemento(j);
	 * lo.agregarEn(lo.elemento(j+1), j);
	 * lo.agregarEn(aux, j+1);
	 * }
	 * }
	 * }
	 * return lo;
	 * }
	 * 
	 * public ListaDeEnterosEnlazada ordenar2() {
	 * int i, temp, j, tam;
	 * ListaDeEnterosEnlazada array=this;
	 * tam=this.tamanio();
	 * for (i = 0; i < tam; i++) {
	 * temp = array.elemento(i);
	 * j = i+1;
	 * while ( (array.elemento(j) > temp) && (j >= 0) ) {
	 * array.agregarEn(array.elemento(j), j+1);
	 * j--;
	 * }
	 * array.agregarEn(temp,j+1);
	 * }
	 * return array;
	 * }
	 */

	public ListaDeEnterosEnlazada ordenar() { // Solucionado
		ListaDeEnterosEnlazada res = new ListaDeEnterosEnlazada();
		Integer aux1, ctrl;
		ctrl = 0;
		for (int i = 0; i < this.tamanio(); i++) {
			Integer aux2 = 9999;
			this.comenzar();
			while (!this.fin()) {
				aux1 = this.proximo();
				if ((aux1 < aux2) && (aux1 > ctrl))
					aux2 = aux1;
			}
			res.agregarInicio(aux2);
			ctrl = aux2;
		}
		return res;
	}

	public ListaDeEnterosEnlazada combinarOrdenado(ListaDeEnterosEnlazada listaParam) {
		ListaDeEnterosEnlazada lnueva = new ListaDeEnterosEnlazada();
		int i = 0;
		/*
		 * this.comenzar();
		 * listaParam.comenzar();
		 */
		int min = Menor(this.elemento(i), listaParam.elemento(i));

		while (i < this.tamanio()) {
			lnueva.agregarFinal(min);
			min = Menor(this.elemento(i), listaParam.elemento(i));
			i++;
		}
		return lnueva;
	}
}
