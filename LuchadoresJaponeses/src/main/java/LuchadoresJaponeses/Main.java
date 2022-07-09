package LuchadoresJaponeses;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
	
		String ruta = "src/main/resources/";
		String ruta2 = "src/main/resources/";
		try {
			ejecutar(ruta, ruta2);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public static void ejecutar(String rutaIN,String rutaOUT) throws IOException  {
		
		GestorArchivos archivo = new GestorArchivos(rutaIN, rutaOUT);
		Torneo torneo = archivo.leerArchivo();
		
		torneo.calcularDuelos();
		
		archivo.guardarArchivo(torneo, torneo.getDominados());
	}
}
