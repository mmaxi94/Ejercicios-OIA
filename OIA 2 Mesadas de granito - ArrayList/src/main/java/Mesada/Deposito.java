package Mesada;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Deposito{

	private LinkedList<Mesada> mesadas;
	private int cantidadMesadas;
	
	public Deposito(int cant) {
		this.cantidadMesadas=cant;
		mesadas = new LinkedList<Mesada>();		
	}
	

	
	public int getMinPilasMesadas() {
		int acum = 0;
		boolean huboCambio=false;
		
		Collections.sort(mesadas);

		//al pedo, con el comparable anda
		/*Collections.sort(this.mesadas, new Comparator<Mesada>() {
			public int compare(Mesada o1, Mesada o2) {
				if(o1.getAncho() > o2.getAncho() && o1.getLargo()==o2.getLargo()) return -1;
				else if(o1.getAncho() < o2.getAncho() && o1.getLargo()==o2.getLargo()) return 1;
				else return 0;
			}
		});	*/		
		
		//esto anda ordenando de mayor a menor
		/*
		for (int i = 0; i <this.mesadas.size();) {
			huboCambio=false;
			Mesada pivote = mesadas.getFirst();

				for (int j =0; j < this.mesadas.size();) {

						if (mesadas.get(j).sePuedeApilarA(pivote)) {
							pivote = mesadas.get(j);
							mesadas.remove(j);
							huboCambio=true;
						}
						else j++;
				}					
				if (huboCambio)
					acum++;	
				else
					i++;			
		}
		*/
		//esto anda ordenando de menor a mayor
		
		int cantidadPilas=mesadas.size();
		
		for (int i = 0; i <this.mesadas.size(); i++) {
			Mesada pivote = mesadas.getLast();

				for (int j = this.mesadas.size() -2; j >=0; j--) {

						if (mesadas.get(j).sePuedeApilarA(pivote)) {
							pivote = mesadas.get(j);
							mesadas.remove(j);
							cantidadPilas--;
						}
				}
				this.mesadas.removeLast();
		
		}
		acum=cantidadPilas;
		
		return acum;
		
	}
	
	public void agregarMesada(Mesada mesada) {
		this.mesadas.add(mesada);
	}
	
	public List<Mesada> getMesadas() {
		return mesadas;
	}



}
