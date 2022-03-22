/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructura de Datos
 * Seccion 20
 * Hoja de Trabajo 6
 * 
 * Adrian Ricardo Flores Trujillo 21500
 */

import java.util.*;

/**
 * Clase Main
 */

class Main{
	public static void main(String[] args){

		Vista v = new Vista();
		MapFactory f = new MapFactory();
		int tipo = v.getTipo();
		Map<String, ArrayList<Objeto>> objetos = f.createMap(tipo); //Llama al factory para crear un mapa
		ArrayList<Objeto> carrito = new ArrayList<Objeto>();
		int menu = 0;
		int menu1 = 0;
		int menu2 = 0;

		try{
			objetos = v.leer(objetos); //Realiza la lectura del archivo

		} catch(Exception e){}
		
		while(menu != 7){ //Loop principal
			menu = v.getMenu(); //Muestra el menu y consigue la eleccion del usuario
			switch(menu){
				case 1: //Agregar un articulo al carrito
					menu1 = 0;
					menu2 = 0;
					while(menu1 != objetos.keySet().size()+1){ //Menu de categorias
						menu1 = v.getCat(objetos.keySet());
						if(menu1 != objetos.keySet().size()+1){ //Si no se escogió la opcion para regresar, avanza a los articulos
							while(menu2 != objetos.get(objetos.keySet().toArray(new String[0])[menu1-1]).size()+1){ //Menu de articulos
								menu2 = v.getProd(objetos.get(objetos.keySet().toArray(new String[0])[menu1-1]));
								if(menu2 != objetos.get(objetos.keySet().toArray(new String[0])[menu1-1]).size()+1){ //Si no se escogió la opcion para regresar, agrega el objeto al carrito
									Objeto obj = objetos.get(objetos.keySet().toArray(new String[0])[menu1-1]).get(menu2-1);
									if(!carrito.isEmpty()){ //Si el carrito no está vacio se debe revisar si ya está el producto en el carrito para poder aumentar su cantidad en vez de agregar un repetido
										int t = carrito.size();
										for(int i = 0; i<t; i++){
											if(obj.getNombre().equals(carrito.get(i).getNombre())){
												carrito.get(i).agregar(); 
												v.allGood(); //Todo bien :)
												break;
											} else if(i==t-1){
												carrito.add(obj); //Si ya iteró sobre todos los objetos y no consiguió ningun match agrega el objeto al carrito
												v.allGood(); //Todo bien :)
											}
										}
									} else {
										carrito.add(obj); //Si el carrito está vacio solo se argega el objeto
										v.allGood(); //Todo bien :)
									}
									

									
								}
							}
						}
					}
					break;

				case 2: //Mostrar categoria de un objeto
					String search = v.getCleanInput(); //Consigue un input sin tildes
					boolean fl = true;
					for(String k : objetos.keySet()){ //Itera sobre cada objeto en el arraylist para cada llave para buscar
						for(Objeto m : objetos.get(k)){
							if(m.getNombre().equals(search)){
								System.out.println(m.getCategoria());
								fl = false; //Cambia el valor del flag para indicar que sí se encontró
							}
						}
					}
					if(fl){
						System.out.println("Ese producto no existe en el inventario");
					}
					break;

				case 3: //Mostrar carrito
					if(!carrito.isEmpty()){
						v.mostrarCol(carrito);
					} else{
						System.out.println("No hay ningun articulo en su coleccion");
					}
					break;
					

				case 4: //Mostrar carrito ordenado
					Map<String, ArrayList<Objeto>> cTemp = f.createMap(tipo); //Crea un mapa temporal
					if(!carrito.isEmpty()){ //Si el carrito no está vacio, itera sobre cada objeto en este.
						for(Objeto s : carrito){
							if(cTemp.containsKey(s.getCategoria())){ //Revisa si la categoria del objeto ya existe entre las llaves del mapa
								cTemp.get(s.getCategoria()).add(s); //Si sí existe, llama al arraylist asociado a la llave para agregar el objeto
							} else{
								ArrayList<Objeto> obj = new ArrayList<Objeto>();
								obj.add(s);
								cTemp.put(s.getCategoria(), obj); //Si no existe crea un arraylist nuevo y agrega el objeto, para despues crear una nueva entrada en el mapa
							}
						}
						v.showMap(cTemp); //Muestra el carrito
					} else {
						System.out.println("No hay ningun articulo en su coleccion");
					}
					break;

				case 5: //Mostrar inventario
					ArrayList<Objeto> tempInv = new ArrayList<Objeto>(); //Arraylist temporal para almacenar todos los objetos
					for(String k : objetos.keySet()){
						for(Objeto m : objetos.get(k)){
							tempInv.add(m); //agrega todos los objetos del inventario para mostrarlos de manera "desordenada"
						}
					}
					v.mostrarInv(tempInv);
					break;

				case 6: //Mostrar inventario ordenado
					v.showInv(objetos);
					break;
			}
		}

	}
}