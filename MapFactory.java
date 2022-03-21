import java.util.*;

class MapFactory{

	public Map<String, Objeto> createMap(int sel){	

		switch(sel){
			case 1:
				return new HashMap<String, Objeto>();
			case 2:
				return new TreeMap<String, Objeto>();
			case 3:
				return new LinkedHashMap<String, Objeto>();
			default:
				return null;
		}

	}

}