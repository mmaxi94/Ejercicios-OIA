package LuchadoresJaponeses;

public class Luchador {

	private double peso;
	private double altura;
	
	public Luchador(double peso, double altura) {
		this.peso = peso;
		this.altura = altura;
	}
	
	public boolean dominaA(Luchador otroLuchador) {
		
		boolean loDomina=false;
		
		if((this.altura>otroLuchador.altura && this.peso>otroLuchador.peso)
				|| (this.altura==otroLuchador.altura && this.peso>otroLuchador.peso)
					|| (this.altura>otroLuchador.altura && this.peso==otroLuchador.peso))
				loDomina=true;
		
		return loDomina;
	}	
}
