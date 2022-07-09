package Mesada;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GestorArchivo {

	private String rutaIN;
	private String rutaOUT;
	
	public GestorArchivo(String rutaIN,String rutaOUT) {
		this.rutaIN=rutaIN;
		this.rutaOUT=rutaOUT;
	}
	
	public Deposito leerArchivo() throws FileNotFoundException {
		
		Scanner archivo = new Scanner(new File(this.rutaIN + "mesadas.in"));
		
		int cantidadMesadas = archivo.nextInt();
		
		Deposito deposito = new Deposito(cantidadMesadas);
		
		while(archivo.hasNext()) {
			deposito.agregarMesada(new Mesada(archivo.nextInt(),archivo.nextInt()));
		}
		
		archivo.close();
		
		return deposito;	
	}
	
	public void guardarArchivo(int cantPilas) throws IOException {
		
		FileWriter fw = new FileWriter(new File(this.rutaOUT + "mesadas.out"));
		PrintWriter pw = new PrintWriter(fw);
		
		pw.println(cantPilas);
		
		pw.close();
		
	}
}
