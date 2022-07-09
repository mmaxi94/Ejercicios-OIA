package Mesada;

import java.util.Comparator;

public class ComparatorLargo implements Comparator<Mesada>{

	public int compare(Mesada o1, Mesada o2) {
		return o1.getLargo() - o2.getLargo();
	}

}
