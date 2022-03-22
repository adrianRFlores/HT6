import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.text.Normalizer;

/**
 * Clase para manejar la mayoria de los procesos IO
 */

class Vista{
	
	Scanner scan = new Scanner(System.in);

	/**
	 * Metodo para leer el archivo y pasar los datos a un hashmap
	 * 
	 * @param map el mapa a utilizar
	 * @return un mapa con los contenidos del archivo
	 */
	public Map<String, ArrayList<Objeto>> leer(Map<String, ArrayList<Objeto>> map){
		try{
			Scanner read = new Scanner(new File("ListadoProducto.txt"));
			while(read.hasNextLine()){
				String data = read.nextLine();
				data = clean(data);
				String cat = data.substring(0, data.indexOf("|")-1);
				String prod = data.substring(data.indexOf("|")+2); //Separa el producto de su categoria
				if(map.get(cat) != null){ //Si la llave existe en el mapa, se crea un nuevo objeto y se agrega al arraylist de la llave
					map.get(cat).add(new Objeto(prod, 1, cat)); 
				} else{ //Si no existe, se crea una nueva entrada en el mapa
					ArrayList<Objeto> temp = new ArrayList<Objeto>();
					temp.add(new Objeto(prod, 1, cat));
					map.put(cat, temp);
				}
			}

		} catch(FileNotFoundException e){
			e.printStackTrace();
		}

		return map; //Retorna el mapa
	}

	/**
	 * Metodo para quitar las tildes de los strings
	 * 
	 * @param s el string "sucio" ewwww 
	 * @return el string despues de un buen baño
	 */
	public String clean(String s) {
		String norm = Normalizer.normalize(s, Normalizer.Form.NFD);   
		return norm.replaceAll("[^\\p{ASCII}]", ""); //Utiliza Normalizer para pasar todos los caracteres a un formato ascii

	}

	/**
	 * Metodo para mostrar los tipos de mapa y devolver un entero que represente la opcion seleccionada
	 * 
	 * @return entero de 1 a 3 que representa la seleccion
	 */
	public int getTipo(){
		int num;
		System.out.println("Ingrese el tipo de mapa a utilizar: ");
		System.out.println("1. HashMap\n2. TreeMap\n3. LinkedHashMap");
		while(true){
			num = 0;
			try{
				num = scan.nextInt();
				if(num > 0 && num < 4){
					return num;
				} else{
					System.out.println("Ingrese una opcion valida");
				}
			} catch(Exception e){
				System.out.println("Ingrese un entero");
			}
			
		}
		
	}

	/**
	 * Metodo para mostrar las opciones del menu y devolver un entero que represente la opcion seleccionada
	 * 
	 * @return entero de 1 a 7 que representa la seleccion
	 */
	public int getMenu(){
		int num;
		System.out.println("\n" + "-".repeat(30) + "MENU" + "-".repeat(30));
		System.out.println("1. Agregar un articulo a la coleccion\n2. Mostrar categoria de un producto\n3. Mostrar productos en la coleccion");
		System.out.println("4. Mostrar productos en la coleccion ordenados\n5. Mostrar inventario\n6. Mostrar inventario ordenado");
		System.out.println("7. Salir");
		while(true){
			try{
				num = scan.nextInt();
				if(num > 0 && num < 8){
					return num;
				} else{
					System.out.println("Ingrese una opcion valida");
				}
			} catch(Exception e){
				System.out.println("Ingrese un entero");
			}
			
		}
		
	}

	/**
	 * Metodo para mostrar todas las entradas de un set y devolver la opcion seleccionada en forma de un entero
	 * 
	 * @param c el set a mostrar
	 * @return un entero que represente la opcion del set seleccionada
	 */
	public int getCat(Set<String> c){
		int temp = 1;
		int num;
		System.out.println("\nEscoja una categoria: ");
		for(String s : c){
			System.out.println(temp + ". " + s);
			temp++;
		}
		System.out.println(temp + ". Regresar");
		while(true){
			num = 0;
			try{
				num = scan.nextInt();
				if(num > 0 && num <= c.size()+1){
					return num;
				} else{
					System.out.println("Ingrese una opcion valida");
				}
			} catch(Exception e){
				System.out.println("Ingrese un entero");
			}
			
		}
	}

	/**
	 * Metodo para mostrar todas las entradas de un arraylist y devolver la opcion seleccionada en forma de un entero
	 * 
	 * @param arr el arraylist a mostrar
	 * @return un entero que represente la opcion del arraylist seleccionada
	 */
	public int getProd(ArrayList<Objeto> arr){
		int temp = 1;
		int num;
		System.out.println("\nEscoja un producto a agregar: ");
		for(Objeto s : arr){
			System.out.println(temp + ". " + s.getNombre());
			temp++;
		}
		System.out.println(temp + ". Regresar");
		while(true){
			num = 0;
			try{
				num = scan.nextInt();
				if(num > 0 && num <= arr.size()+1){
					return num;
				} else{
					System.out.println("Ingrese una opcion valida");
				}
			} catch(Exception e){
				System.out.println("Ingrese un entero");
			}
			
		}
	}

	/**
	 * Metodo para mostrar todas las entradas de un arraylist
	 * 
	 * @param arr el arraylist a mostrar
	 */
	public void mostrarCol(ArrayList<Objeto> arr){
		System.out.println("\nColeccion: ");
		for(Objeto s : arr){
			System.out.println(s);
		}
		
	}

	/**
	 * Metodo para mostrar todas las entradas de un arraylist con nombre y categoria
	 * 
	 * @param arr el arraylist a mostrar
	 */
	public void mostrarInv(ArrayList<Objeto> arr){
		int a = 1;
		for(Objeto s : arr){
			System.out.println(a + ". " + s.getNombre() + " | " + s.getCategoria());
			a++;
		}
		
	}

	/**
	 * Metodo para mostrar todas las entradas de un mapa ordenadas por llaves
	 * 
	 * @param map el mapa a mostrar
	 */
	public void showMap(Map<String, ArrayList<Objeto>> map){
		for(String key : map.keySet()){
			System.out.println(key);
			for(int i = 0; i<map.get(key).size(); i++){
				System.out.println("	" + map.get(key).get(i).getCantidad() + " - " + map.get(key).get(i).getNombre());
			}
		}
	}

	/**
	 * Metodo para mostrar todas las entradas de un mapa ordenadas por llaves (Cambia la forma en la que se meustran los productos)
	 * 
	 * @param map el mapa a mostrar
	 */
	public void showInv(Map<String, ArrayList<Objeto>> map){
		for(String key : map.keySet()){
			System.out.println(key);
			for(int i = 0; i<map.get(key).size(); i++){
				System.out.println("	" + (i+1) + ". " + map.get(key).get(i).getNombre());
			}
		}
	}

	/**
	 * All Good.
	 * 
	 */
	public void allGood(){
		System.out.println("Producto agregado exitosamente");
	}

	/**
	 * Consigue una entrada del usuario y le da un bañito caliente 
	 * 
	 * @return la entrada del usuario sin tildes
	 */
	public String getCleanInput(){
		System.out.println("Ingrese el nombre del producto a buscar (Tome en cuenta las mayusculas y tildes): ");
		scan.nextLine();
		String s = scan.nextLine();
		return clean(s);
	}

}