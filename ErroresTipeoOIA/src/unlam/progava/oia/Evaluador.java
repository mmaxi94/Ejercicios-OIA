package unlam.progava.oia;

public class Evaluador {

	char[] texto;
	char[] prueba;
	int cantidadMovimientos;
	


	public Evaluador(char[] texto, char[] prueba) {
		this.texto = texto;
		this.prueba = prueba;
	}
	
	public void procesador() {
		
		int j=0;
		char aux;
		for (int i = 0; i < texto.length; i++) {
			j=i; //para que busque en prueba a partir de i
			while(texto[i] != prueba[j]) {
				j++;			
			}
			
			while(j!=i) {
				prueba[j]=prueba[j-1];
				j--;
				cantidadMovimientos++;
			}
			prueba[j]=texto[i];
		}
	}
	
	public int getCantidadMovimientos() {
		return cantidadMovimientos;
	}
}
