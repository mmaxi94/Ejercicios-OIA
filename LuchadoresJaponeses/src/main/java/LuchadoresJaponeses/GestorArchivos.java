package LuchadoresJaponeses;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GestorArchivos {

	private String rutaIN;
	private String rutaOUT;
	
	public GestorArchivos(String strIN, String strOUT) {
		this.rutaIN=strIN;
		this.rutaOUT=strOUT;
	}
	
	public Torneo leerArchivo() throws FileNotFoundException {
		Scanner scanner = null;
		Torneo torneo = null;

		scanner = new Scanner(new File(this.rutaIN + "sumo.in"));

		int cantLuchadores = scanner.nextInt();
		torneo = new Torneo(cantLuchadores);

		while (scanner.hasNextLine()) {
			Luchador luchador = new Luchador(scanner.nextInt(), scanner.nextInt());
			torneo.agregarLuchador(luchador);
		}
		scanner.close();
		
		return torneo;
	}
	
	public void guardarArchivo(Torneo torneo, int[] dominados) throws IOException {
		FileWriter archivo = null;
		PrintWriter pw = null;

		archivo = new FileWriter(this.rutaOUT + "sumo.out");
		pw = new PrintWriter(archivo);

		for (int i = 0; i < dominados.length; i++) {
			pw.println(dominados[i]);
		}

		archivo.close();
			
	}
}
