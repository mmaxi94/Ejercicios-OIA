package Mesada;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		String ruta="src/main/resources/";
		
		try {
			ejecutar(ruta,ruta);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void ejecutar(String in, String out) throws IOException {
		GestorArchivo archivo = new GestorArchivo(in, out);
		
		Deposito deposito = archivo.leerArchivo();
		
		int cantPilas= deposito.getMinPilasMesadas();
		
		archivo.guardarArchivo(cantPilas);
	}
}
