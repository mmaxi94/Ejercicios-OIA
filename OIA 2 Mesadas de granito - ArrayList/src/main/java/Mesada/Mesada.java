package Mesada;


public class Mesada implements Comparable<Mesada> {

	private int largo;
	private int ancho;
	
	public Mesada(int largo, int ancho) {
		this.largo = largo;
		this.ancho = ancho;

	}
	
	public boolean sePuedeApilarA(Mesada otraMesada) {	
		return ( (this.ancho <= otraMesada.ancho && this.largo<=otraMesada.largo)
				|| (this.ancho <= otraMesada.largo && this.largo<=otraMesada.ancho)) 
					&& tieneDimension(this) && tieneDimension(otraMesada); 
	}
	
	private boolean tieneDimension(Mesada unaMesada) {
		return unaMesada.ancho >0 && unaMesada.largo>0;
	}

	public int getLargo() {
		return largo;
	}

	public int getAncho() {
		return ancho;
	}
/*
	public int compareTo(Mesada o) {
		if (this.getLargo() > o.getLargo()) return -1;
		else if (this.getLargo() < o.getLargo()) return 1;
		else return 0;
	}*/
	
	public int compareTo(Mesada otro) {
		// ordeno primero por el alto, y si son iguales ordeno por ancho 
		int resultado = this.largo - otro.largo;
		if(resultado !=0)
			return resultado;
		return (int)this.ancho - otro.ancho;
			
	}
	
	
	
}
