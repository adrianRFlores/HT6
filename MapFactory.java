import java.util.*;

/**
 * Patrón de diseño Factory para crear mapas en base a lo que escoja el usuario
 */

class MapFactory{

	/**
	 * Metodo para crear un mapa y devolverlo
	 * 
	 * @param sel un entero 1-3 el cual representa el tipo de mapa a crear
	 * @return un mapa <String, ArrayList> del tipo especificado
	 */
	public Map<String, ArrayList<Objeto>> createMap(int sel){	

		switch(sel){
			case 1: //HashMap
				return new HashMap<String, ArrayList<Objeto>>();
			case 2: //TreeMap
				return new TreeMap<String, ArrayList<Objeto>>();
			case 3: //LinkedHashMap
				return new LinkedHashMap<String, ArrayList<Objeto>>();
			default:
				return null;
		}

	}

}