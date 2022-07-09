package LuchadoresJaponeses;
public class Torneo {

	private Luchador[] luchadores;
	private int[] dominados;
	
	public Torneo(int cantidadLuchadores) {
		this.luchadores = new Luchador[cantidadLuchadores];
		this.dominados = new int[cantidadLuchadores];
	}
	
	public void agregarLuchador(Luchador unLuchador) {
		boolean seguir=true;
		
		for (int i = 0; i < luchadores.length && seguir; i++) {
			if(luchadores[i]==null) {
				luchadores[i]=unLuchador;
				seguir=false;
			}
		}
	}
	
	public void calcularDuelos() {
		
		for (int i = 0; i < luchadores.length; i++) {
			
			for (int j = 0; j < luchadores.length; j++) {
				if(luchadores[i]!=luchadores[j] && luchadores[i].dominaA(luchadores[j])) {
					dominados[i]++;
				}			
			}
		}	
	}
	
	public Luchador[] getLuchadores() {
		return this.luchadores;
	}
	
	public int[] getDominados() {
		return this.dominados;
	}
}
