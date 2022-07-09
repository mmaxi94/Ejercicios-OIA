import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import LuchadoresJaponeses.Luchador;
import LuchadoresJaponeses.Torneo;
import LuchadoresJaponeses.Main;


public class SumoTest {

	@Test
	public void caso_01_no_considera_superarAmbasMedidas() throws IOException {
		
		Luchador luchador1 = new Luchador(300, 1500);
		Luchador luchador2 = new Luchador(299, 1499);
		
		//assertEquals(true, luchador1.dominaA(luchador2));
		assertTrue(luchador1.dominaA(luchador2)); //otra forma
		
		String rutaIN = "src/test/resources/Lote_de_prueba/caso_01_no_considera_superarAmbasMedidas/entrada/";
		String rutaOUT = "src/test/resources/Lote_de_prueba/caso_01_no_considera_superarAmbasMedidas/salida/";
		Main.ejecutar(rutaIN, rutaOUT);
	}
	
	@Test
	public void caso_02_no_considera_igualPesoSuperaAltura() throws IOException {
		
		Luchador luchador1 = new Luchador(300, 1500);
		Luchador luchador2 = new Luchador(300, 1499);
		
		assertTrue(luchador1.dominaA(luchador2)); 
		
		String rutaIN = "src/test/resources/Lote_de_prueba/caso_02_no_considera_igualPesoSuperaAltura/entrada/";
		String rutaOUT = "src/test/resources/Lote_de_prueba/caso_02_no_considera_igualPesoSuperaAltura/salida/";
		Main.ejecutar(rutaIN, rutaOUT);
	}
	
	@Test
	public void caso_03_no_considera_igualAlturaSuperaPeso() throws IOException {
		
		Luchador luchador1 = new Luchador(300, 1500);
		Luchador luchador2 = new Luchador(299, 1500);
		
		assertTrue(luchador1.dominaA(luchador2)); 
		
		String rutaIN = "src/test/resources/Lote_de_prueba/caso_03_no_considera_igualAlturaSuperaPeso/entrada/";
		String rutaOUT = "src/test/resources/Lote_de_prueba/caso_03_no_considera_igualAlturaSuperaPeso/salida/";
		Main.ejecutar(rutaIN, rutaOUT);
	}
	
	@Test
	public void caso_04_dominaPesoLoSuperaEnAltura() throws IOException {
		
		Luchador luchador1 = new Luchador(300, 1500);
		Luchador luchador2 = new Luchador(299, 1550);
		
		assertFalse(luchador1.dominaA(luchador2)); 
		
		String rutaIN = "src/test/resources/Lote_de_prueba/caso_04_dominaPesoLoSuperaEnAltura/entrada/";
		String rutaOUT = "src/test/resources/Lote_de_prueba/caso_04_dominaPesoLoSuperaEnAltura/salida/";
		Main.ejecutar(rutaIN, rutaOUT);
	}
	
	@Test
	public void caso_05_dominaAlturaLoSuperaEnPeso() throws IOException {
		
		Luchador luchador1 = new Luchador(300, 1550);
		Luchador luchador2 = new Luchador(350, 1500);
		
		assertFalse(luchador1.dominaA(luchador2)); 
		
		String rutaIN = "src/test/resources/Lote_de_prueba/caso_05_dominaAlturaLoSuperaEnPeso/entrada/";
		String rutaOUT = "src/test/resources/Lote_de_prueba/caso_05_dominaAlturaLoSuperaEnPeso/salida/";
		Main.ejecutar(rutaIN, rutaOUT);
	}
	
	@Test
	public void caso_06_borde_unSoloLuchador() throws IOException {
		//duda
		Torneo torneo = new Torneo(1);
		Luchador luchador1 = new Luchador(300, 1550);
		
		torneo.agregarLuchador(luchador1);
		torneo.calcularDuelos();
		
		assertArrayEquals(new int[] {0},torneo.getDominados()); 
		
		String rutaIN = "src/test/resources/Lote_de_prueba/caso_06_borde_unSoloLuchador/entrada/";
		String rutaOUT = "src/test/resources/Lote_de_prueba/caso_06_borde_unSoloLuchador/salida/";
		Main.ejecutar(rutaIN, rutaOUT);
	}
	
	@Test
	public void caso_07_NadieSupera_a_Nadie() throws IOException {

		Torneo torneo = new Torneo(5);
		
		torneo.agregarLuchador(new Luchador(300, 1550));
		torneo.agregarLuchador(new Luchador(300, 1550));
		torneo.agregarLuchador(new Luchador(300, 1550));
		torneo.agregarLuchador(new Luchador(300, 1550));
		torneo.agregarLuchador(new Luchador(300, 1550));
		
		torneo.calcularDuelos();
		
		assertArrayEquals(new int[] {0,0,0,0,0},torneo.getDominados()); 
		
		String rutaIN = "src/test/resources/Lote_de_prueba/caso_07_NadieSupera_a_Nadie/entrada/";
		String rutaOUT = "src/test/resources/Lote_de_prueba/caso_07_NadieSupera_a_Nadie/salida/";
		Main.ejecutar(rutaIN, rutaOUT);
	}
	
	@Test
	public void caso_08_LuchadoresExtremosSuperanResto() throws IOException {

		Torneo torneo = new Torneo(5);
		
		torneo.agregarLuchador(new Luchador(300, 1500));
		torneo.agregarLuchador(new Luchador(200, 1200));
		torneo.agregarLuchador(new Luchador(200, 1200));
		torneo.agregarLuchador(new Luchador(200, 1200));
		torneo.agregarLuchador(new Luchador(300, 1500));
		
		torneo.calcularDuelos();
		
		assertArrayEquals(new int[] {3,0,0,0,3},torneo.getDominados()); 
		
		String rutaIN = "src/test/resources/Lote_de_prueba/caso_08_LuchadoresExtremosSuperanResto/entrada/";
		String rutaOUT = "src/test/resources/Lote_de_prueba/caso_08_LuchadoresExtremosSuperanResto/salida/";
		Main.ejecutar(rutaIN, rutaOUT);
	}
	
	

}
