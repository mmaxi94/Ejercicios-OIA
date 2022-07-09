package unlam.progava.oia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorArchivo {

	public static Grafo leerArchivo(String path) throws FileNotFoundException {
		Scanner archivo = new Scanner(new File(path));
		
		int cantidadNodos = archivo.nextInt();
		int cantSenderos = archivo.nextInt();
		int cantDragones = archivo.nextInt();
		
		int nodoPrincesa = archivo.nextInt()-1;
		int nodoPrincipe = archivo.nextInt()-1;
		
		Grafo grafo = new Grafo(cantidadNodos, nodoPrincesa,nodoPrincipe);
		
		for (int i = 0; i < cantDragones; i++) {
			grafo.addDragon(archivo.nextInt()-1);
		}
		
		for (int i = 0; i < cantSenderos; i++) {
			//grafo.addEdge(archivo.nextInt(), archivo.nextInt(), archivo.nextInt());
			grafo.addArista(archivo.nextInt()-1, archivo.nextInt()-1, archivo.nextInt());
		}
		
		return grafo;
	}
	
	public static void escribirArchivo(String path, ArrayList<Integer> lista, String mensaje) throws IOException {
		FileWriter fw = new FileWriter(new File(path));
		PrintWriter pw = new PrintWriter(fw);

		if (mensaje.equals("INTERCEPTADO"))
			pw.print(mensaje);
		else if (mensaje.equals("NO HAY CAMINO"))
			pw.print(mensaje);
		else {
			for (Integer elemento : lista) {
				pw.print(elemento + " ");
			}
		}

		pw.close();
	}
}
