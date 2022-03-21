import java.util.*;

class MapFactory{

	public Map<String, ArrayList<Objeto>> createMap(int sel){	

		switch(sel){
			case 1:
				return new HashMap<String, ArrayList<Objeto>>();
			case 2:
				return new TreeMap<String, ArrayList<Objeto>>();
			case 3:
				return new LinkedHashMap<String, ArrayList<Objeto>>();
			default:
				return null;
		}

	}

}