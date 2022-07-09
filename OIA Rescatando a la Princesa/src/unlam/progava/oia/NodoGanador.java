package unlam.progava.oia;

public class NodoGanador {

	private int nroNodo;
	private String tipo_entidad;
	private int[] predecesores;
	private int caminoMinimo;
	

	public NodoGanador(int nroNodo, String tipo_entidad, int[] predecesores,int caminoMinimo) {
		this.nroNodo = nroNodo;
		this.tipo_entidad = tipo_entidad;
		this.predecesores = predecesores;
		this.caminoMinimo=caminoMinimo;
	}

	public int getNroNodo() {
		return nroNodo;
	}

	public String getTipo_entidad() {
		return tipo_entidad;
	}

	public int[] getPredecesores() {
		return predecesores;
	}
	public int getCaminoMinimo() {
		return caminoMinimo;
	}

	
}
