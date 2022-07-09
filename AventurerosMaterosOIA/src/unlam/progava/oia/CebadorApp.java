package unlam.progava.oia;

import java.util.ArrayList;
import java.util.LinkedList;

public class CebadorApp {

	private LinkedList<Aventurero> lista;
	private ArrayList<Integer> listaPasadas;
	private ArrayList<Aventurero> listaResultado;

	private Aventurero cebadorFinal;
	
	public CebadorApp() {
		this.lista = new LinkedList<Aventurero>();
		this.listaPasadas = new ArrayList<Integer>();
		this.listaResultado = new ArrayList<Aventurero>();
	}
	
	public void agregarAventurero(Aventurero participante) {
		this.lista.add(participante);
	}
	
	public void agregarPasadas(int nro) {
		this.listaPasadas.add(nro);
	}
	
	public void calcular() {
		
		int contador=0;
		int indiceActual=0;
		while(contador < listaPasadas.size()) {
			
			int pasada = listaPasadas.get(contador);
			indiceActual = (pasada + indiceActual) % lista.size();
			
			Aventurero eliminado = lista.remove(indiceActual);
			listaResultado.add(eliminado);
			
			contador++;
		}
		if (lista.isEmpty()) {
			this.cebadorFinal = new Aventurero(0);
		}
		else
			this.cebadorFinal = lista.get(0);	
		
	}
	/*
	public void calcular() {
		
		Aventurero pivote = lista.getFirst();
		for (int i = 0; i < listaPasadas.size(); i++) {
			int contador=0;
			
			while(contador < listaPasadas.get(i)) { //mover pivote o sea, el que tenga el mate
				contador++;
				if (!pivote.equals(lista.getLast()))
					pivote = lista.get(lista.indexOf(pivote)+1);	
				else
					pivote = lista.getFirst();
			}
			
			this.listaResultado.add(pivote);
			
			Aventurero pivoteAux = pivote;
			if (pivote.equals(lista.getLast()))
				pivote = lista.getFirst();
			else
				pivote = lista.get(lista.indexOf(pivote)+1);
		
			this.lista.remove(lista.indexOf(pivoteAux));			
		}
		if (lista.isEmpty()) {
			this.cebadorFinal = new Aventurero(0);
		}
		else
			this.cebadorFinal = pivote;	
	}*/
	
	
	public Aventurero getCebadorFinal() {
		return cebadorFinal;
	}

	public ArrayList<Aventurero> getListaResultado() {
		return listaResultado;
	}
	
}
