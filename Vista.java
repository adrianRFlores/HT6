import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.text.Normalizer;

class Vista{
	
	Scanner scan = new Scanner(System.in);

	public Map<String, ArrayList<Objeto>> leer(Map<String, ArrayList<Objeto>> map){
		try{
			Scanner read = new Scanner(new File("ListadoProducto.txt"));
			while(read.hasNextLine()){
				String data = read.nextLine();
				data = clean(data);
				String cat = data.substring(0, data.indexOf("|")-1);
				String prod = data.substring(data.indexOf("|")+2);
				if(map.get(cat) != null){
					map.get(cat).add(new Objeto(prod, 1, cat));
				} else{
					ArrayList<Objeto> temp = new ArrayList<Objeto>();
					temp.add(new Objeto(prod, 1, cat));
					map.put(cat, temp);
				}
			}

		} catch(FileNotFoundException e){
			e.printStackTrace();
		}

		return map;
	}

	public String clean(String s) {
		String norm = Normalizer.normalize(s, Normalizer.Form.NFD);   
		return norm.replaceAll("[^\\p{ASCII}]", "");

	}

	public int getTipo(){
		int num;
		System.out.println("Ingrese el tipo de mapa a utilizar: ");
		System.out.println("1. HashMap\n2. TreeMap\n3. LinkedHashMap");
		while(true){
			num = scan.nextInt();
			if(num > 0 && num < 4){
				return num;
			} else{
				System.out.println("Ingrese un entero");
			}
		}
		
	}

	public void showMap(Map<String, ArrayList<Objeto>> map){
		for(String key : map.keySet()){
			System.out.println(key);
			for(int i = 0; i<map.get(key).size(); i++){
				System.out.println("	" + (i+1) + ". " + map.get(key).get(i).getNombre());
			}
		}
	}

}