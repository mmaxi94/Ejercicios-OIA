package unlam.progava.oia;

import java.util.Objects;

public class Aventurero {

	private int posicion;

	public int getPosicion() {
		return posicion;
	}

	public Aventurero(int posicion) {
		this.posicion = posicion;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(posicion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aventurero other = (Aventurero) obj;
		return posicion == other.posicion;
	}
	
	
	
}
