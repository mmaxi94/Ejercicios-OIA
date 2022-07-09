package unlam.progava.oia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Grafo {

	private static final int INF = 99999;
	private int cantidadNodos;
	private List<Nodo>[] listaAdy;
	private int[][] matAdy;
	private ArrayList<Integer> listaDragones;
	private int nodoPrincesa;
	private int nodoPrincipe;
	private ArrayList<Integer> listaCaminofinal;
	private String mensaje="";
	
	public Grafo(int cantNodos,int nodoPrincesa, int nodoPrincipe) {
		this.listaAdy = new LinkedList[cantNodos];
		
		for (int i = 0; i < cantNodos; i++) {
			listaAdy[i] = new LinkedList<Nodo>();
		}
		
		listaDragones = new ArrayList<Integer>();
		this.cantidadNodos=cantNodos;
		this.nodoPrincesa=nodoPrincesa;
		this.nodoPrincipe=nodoPrincipe;
		this.matAdy = new int[cantNodos][cantNodos];
		inicializarMatriz();
	}
	
	public void inicializarMatriz() {
		for (int i = 0; i < listaAdy.length; i++) {
			Arrays.fill(matAdy[i], INF);
		}	
	}
	
	public void addArista(int src, int des, int cost) {
		this.matAdy[src][des]=cost;
		this.matAdy[des][src]=cost;
	}
	
	public void addEdge(int src, int des, int cost) {
		this.listaAdy[src].add(new Nodo(des,cost));
		this.listaAdy[des].add(new Nodo(src,cost));
	}
	
	public void addDragon(int pos) {
		this.listaDragones.add(pos);
	}
	
	public NodoGanador dijkstra(int src, String entidad) {
		//antes devolvia int y no tenia entidad
		int[] distancia = new int[this.cantidadNodos];
		Arrays.fill(distancia, INF);
		
		boolean[] visitados = new boolean[this.cantidadNodos];
		Arrays.fill(visitados, false);
		
		int[] predecesores = new int[this.cantidadNodos];
		Arrays.fill(predecesores, src);
		
		distancia=matAdy[src];
		
		distancia[src]=0;
		visitados[src]=true;
		
		for (int count = 0; count < this.cantidadNodos -1; count++) {
			int w = minimaDistancia(distancia,visitados);
			visitados[w]=true;
			
			for (int i = 0; i < this.cantidadNodos; i++) {
				if((distancia[w]+matAdy[w][i]) < distancia[i] && visitados[i]==false) {
					distancia[i] = distancia[w]+matAdy[w][i];	
					predecesores[i]=w;
				}
			}
		}
		
		NodoGanador ganador = new NodoGanador(src, entidad, predecesores,distancia[this.nodoPrincesa]);
		//return distancia[this.nodoPrincesa];
		return ganador;
		
	}
	
	private int minimaDistancia(int[] distancia, boolean[] visitado) {
		int min = Integer.MAX_VALUE;
		int min_index=0;
		
		for (int i = 0; i < distancia.length; i++) {
			if(min > distancia[i] && visitado[i]==false) {
				min=distancia[i];
				min_index=i;
			}
		}		
		return min_index;
	}
	
	public void ejecutar() {
		ArrayList<NodoGanador> entidades2 = new ArrayList<NodoGanador>();
		entidades2.add(new NodoGanador(this.nodoPrincipe, "principe", null,-1));
		
		for (Integer elemento : listaDragones) {
			entidades2.add(new NodoGanador(elemento, "dragon", null,-1));
		}
		
		int min = INF;
		int entidadMinima=INF;
		
		int nroNodo = 0;
		String tipo_entidad = null;
		int[] predecesores = null;
		int caminoMinimo = 0;
		
		for (int i = 0; i < entidades2.size(); i++) {
			NodoGanador aux = dijkstra(entidades2.get(i).getNroNodo(), entidades2.get(i).getTipo_entidad());
			int valor = aux.getCaminoMinimo();
			if(min > valor) {
				min = valor;
				nroNodo=aux.getNroNodo();
				tipo_entidad=aux.getTipo_entidad();
				predecesores=aux.getPredecesores();
				caminoMinimo=aux.getCaminoMinimo();
			}
		}
		
		switch(tipo_entidad) {
			case "dragon":
				this.mensaje="INTERCEPTADO";
				break;
			case "principe":
				break;
			default:
				this.mensaje="NO HAY CAMINO";
				break;
		}
		
		
		printCaminoAristas(predecesores,nroNodo,this.nodoPrincesa);
		
	}
	
	void printCaminoAristas(int[] vecPred, int src, int des) {
		
		listaCaminofinal = new ArrayList<Integer>();
		System.out.println("Camino desde nodo origen "+src+" a destino "+des);
		listaCaminofinal.add(des);
		
		while(vecPred[des]!=src) {
			int aux=vecPred[des];
			listaCaminofinal.add(vecPred[des]);
			des=aux;	
		}
		listaCaminofinal.add(src);
		
		for (int i = listaCaminofinal.size()-1; i >=0 ; i--) {
			System.out.print(listaCaminofinal.get(i)+" ");
		}
	}
	
	public ArrayList<Integer> getListaCaminofinal() {
		return listaCaminofinal;
	}

	public String getMensaje() {
		return mensaje;
	}
}
