package unlam.progava.oia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GestorArchivo {

	public static CebadorApp leerArchivo(String path) {
		
		Scanner archivo = null;
		CebadorApp cebador = null;
		try {
			archivo = new Scanner(new File(path));
			
			int cantAventureros = archivo.nextInt();
			
			cebador = new CebadorApp();
			
			int pos=1;
			while(pos <= cantAventureros) {
				cebador.agregarAventurero(new Aventurero(pos));
				pos++;
			}
				
			while(archivo.hasNextInt()) {
				cebador.agregarPasadas(archivo.nextInt());	
			}
			archivo.close();
			
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		
		return cebador;	
	}
	
	public static void escribirArchivo(CebadorApp cebador, String path) {
		
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(new File(path));
			
			pw = new PrintWriter(fw);
			
			for (int i = 0; i < cebador.getListaResultado().size(); i++) {
				pw.print(cebador.getListaResultado().get(i).getPosicion());
				
				if(i!=cebador.getListaResultado().size()-1)
					pw.print(" ");
			}
			pw.println();
			pw.print(cebador.getCebadorFinal().getPosicion());
			
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		
	}
	
	
}
