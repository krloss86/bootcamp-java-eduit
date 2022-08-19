package ar.com.educacionit.services.files;

public class Arbol {

	private Nodo root;	
	private Nodo izq;
	private Nodo der;
	
	public Arbol(Nodo root, Nodo izq, Nodo der) {
		super();
		this.root = root;
		this.izq = izq;
		this.der = der;
	}
	
	public Nodo getRoot() {
		return root;
	}
	public void setRoot(Nodo root) {
		this.root = root;
	}
	public Nodo getIzq() {
		return izq;
	}
	public void setIzq(Nodo izq) {
		this.izq = izq;
	}
	public Nodo getDer() {
		return der;
	}
	public void setDer(Nodo der) {
		this.der = der;
	}
	
	
}
