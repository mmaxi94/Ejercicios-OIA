package unlam.progava.oia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GestorArchivo {

	
	public static Evaluador leerArchivo(String path) throws FileNotFoundException {
		
		Scanner file = new Scanner(new File(path));
		
		Evaluador evaluador = new Evaluador(file.nextLine().toCharArray(),file.nextLine().toCharArray());
		
		file.close();
		
		return evaluador;
	}
	
	public static void escribirArchivo(String path, int cantidadMov) throws IOException {
		
		FileWriter fw = new FileWriter(new File(path));
		PrintWriter pw = new PrintWriter(fw);
		
		pw.println(cantidadMov);
		
		pw.close();
		
	}
}
