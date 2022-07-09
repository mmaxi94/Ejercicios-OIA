import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import Mesada.Deposito;
import Mesada.Mesada;
import Mesada.Main;


public class MesadaTest {

	@Test
	public void caso_01_mesadas_iguales() {
		
		Deposito deposito = new Deposito(3);
		
		deposito.agregarMesada(new Mesada(3,3));
		deposito.agregarMesada(new Mesada(3,3));
		deposito.agregarMesada(new Mesada(3,3));
		
		assertEquals(1, deposito.getMinPilasMesadas());
		
		//con archivos
		String rutaIN="src/test/resources/Lote_de_Prueba/caso_01_mesadas_iguales/entrada/";
		String rutaOUT="src/test/resources/Lote_de_Prueba/caso_01_mesadas_iguales/salida/";
		
		try {
			Main.ejecutar(rutaIN, rutaOUT);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void caso_02_unaSolaMesada() {
		
		Deposito deposito = new Deposito(1);
		
		deposito.agregarMesada(new Mesada(3,3));
		
		assertEquals(1, deposito.getMinPilasMesadas());
		
		//con archivos
		String rutaIN="src/test/resources/Lote_de_Prueba/caso_02_unaSolaMesada/entrada/";
		String rutaOUT="src/test/resources/Lote_de_Prueba/caso_02_unaSolaMesada/salida/";
		
		try {
			Main.ejecutar(rutaIN, rutaOUT);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void caso_03_flujo_normal() {
		
		Deposito deposito = new Deposito(6);
		
		deposito.agregarMesada(new Mesada(4,5));
		deposito.agregarMesada(new Mesada(9,3));
		deposito.agregarMesada(new Mesada(2,2));
		deposito.agregarMesada(new Mesada(1,2));
		deposito.agregarMesada(new Mesada(1,12));
		deposito.agregarMesada(new Mesada(2,7));
		
		assertEquals(3, deposito.getMinPilasMesadas());
	}

	@Test
	public void caso_04_borde_MesadasExtremos() {
		
		Deposito deposito = new Deposito(5);
		
		deposito.agregarMesada(new Mesada(4,4));
		deposito.agregarMesada(new Mesada(1,15));
		deposito.agregarMesada(new Mesada(2,14));
		deposito.agregarMesada(new Mesada(3,13));
		deposito.agregarMesada(new Mesada(4,4));
		
		assertEquals(4, deposito.getMinPilasMesadas());
	}
	
	@Test
	public void caso_05_MesadasSinDimension() {
		
		Deposito deposito = new Deposito(2);
		
		deposito.agregarMesada(new Mesada(0,0));
		deposito.agregarMesada(new Mesada(0,0));
		
		assertEquals(0, deposito.getMinPilasMesadas());
	}
	
	@Test
	public void caso_06_MesadaNoRota() {
		
		Deposito deposito = new Deposito(2);
		
		deposito.agregarMesada(new Mesada(2,5));
		deposito.agregarMesada(new Mesada(5,2));
		
		assertEquals(1, deposito.getMinPilasMesadas());
	}
	
	@Test
	public void caso_07_CantidadMaximaPila() {
		
		Deposito deposito = new Deposito(6);
		
		deposito.agregarMesada(new Mesada(4,5));
		deposito.agregarMesada(new Mesada(9,3));
		deposito.agregarMesada(new Mesada(2,2));
		deposito.agregarMesada(new Mesada(1,2));
		deposito.agregarMesada(new Mesada(1,12));
		deposito.agregarMesada(new Mesada(2,7));
		
		assertEquals(3, deposito.getMinPilasMesadas());
	}
	
	@Test
	public void caso_09_EmpateMesadas() {
		
		Deposito deposito = new Deposito(6);
		
		deposito.agregarMesada(new Mesada(1,49));
		deposito.agregarMesada(new Mesada(3,37));
		deposito.agregarMesada(new Mesada(5,25));
		deposito.agregarMesada(new Mesada(4,30));
		deposito.agregarMesada(new Mesada(10,10));
		deposito.agregarMesada(new Mesada(7,13));
		
		assertEquals(6, deposito.getMinPilasMesadas());
	}
	
	@Test
	public void caso_10_MesadaSinDimensionSobreMesadaNormal() {
		
		Deposito deposito = new Deposito(2);
		
		deposito.agregarMesada(new Mesada(0,0));
		deposito.agregarMesada(new Mesada(5,7));
		
		assertEquals(1, deposito.getMinPilasMesadas());
	}
}
