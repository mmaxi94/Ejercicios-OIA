package unlam.progava.oia;

public class Nodo implements Comparable<Nodo>{

	private int nro;
	private int costo;
	
	public Nodo(int nro, int costo) {
		this.nro = nro;
		this.costo = costo;
	}

	public int getNro() {
		return nro;
	}

	public int getCosto() {
		return costo;
	}

	@Override
	public int compareTo(Nodo o) {
		return this.nro-o.nro;
	}
	
	
	
}
