import java.util.*;

class Main{
	public static void main(String[] args){

		Vista v = new Vista();
		MapFactory f = new MapFactory();
		int tipo = v.getTipo();
		Map<String, ArrayList<Objeto>> objetos = f.createMap(tipo);
		ArrayList<Objeto> carrito = new ArrayList<Objeto>();
		int menu = 0;
		int menu1 = 0;
		int menu2 = 0;

		try{
			objetos = v.leer(objetos);

		} catch(Exception e){
			System.out.println("xd");
		}

		//v.showMap(objetos);
		
		while(menu != 7){
			menu = v.getMenu();
			switch(menu){
				case 1:
					menu1 = 0;
					menu2 = 0;
					while(menu1 != objetos.keySet().size()+1){
						menu1 = v.getCat(objetos.keySet());
						if(menu1 != objetos.keySet().size()+1){
							while(menu2 != objetos.get(objetos.keySet().toArray(new String[0])[menu1-1]).size()+1){
								menu2 = v.getProd(objetos.get(objetos.keySet().toArray(new String[0])[menu1-1]));
								if(menu2 != objetos.get(objetos.keySet().toArray(new String[0])[menu1-1]).size()+1){
									Objeto obj = objetos.get(objetos.keySet().toArray(new String[0])[menu1-1]).get(menu2-1);
									if(!carrito.isEmpty()){
										int t = carrito.size();
										for(int i = 0; i<t; i++){
											if(obj.getNombre().equals(carrito.get(i).getNombre())){
												carrito.get(i).agregar();
												v.allGood();
												break;
											} else if(i==t-1){
												carrito.add(obj);
												v.allGood();
											}
										}
									} else {
										carrito.add(obj);
										v.allGood();
									}
									

									
								}
							}
						}
					}
					break;

				case 2:
					String search = v.getCleanInput();
					boolean fl = true;
					for(String k : objetos.keySet()){
						for(Objeto m : objetos.get(k)){
							if(m.getNombre().equals(search)){
								System.out.println(m.getCategoria());
								fl = false;
							}
						}
					}
					if(fl){
						System.out.println("Ese producto no existe en el inventario");
					}
					break;

				case 3:
					if(!carrito.isEmpty()){
						v.mostrarCol(carrito);
					} else{
						System.out.println("No hay ningun articulo en su coleccion");
					}
					break;
					

				case 4:
					Map<String, ArrayList<Objeto>> cTemp = f.createMap(tipo);
					if(!carrito.isEmpty()){
						for(Objeto s : carrito){
							if(cTemp.containsKey(s.getCategoria())){
								cTemp.get(s.getCategoria()).add(s);
							} else{
								ArrayList<Objeto> obj = new ArrayList<Objeto>();
								obj.add(s);
								cTemp.put(s.getCategoria(), obj);
							}
						}
						v.showMap(cTemp);
					} else {
						System.out.println("No hay ningun articulo en su coleccion");
					}
					break;

				case 5:
					ArrayList<Objeto> tempInv = new ArrayList<Objeto>();
					for(String k : objetos.keySet()){
						for(Objeto m : objetos.get(k)){
							tempInv.add(m);
						}
					}
					v.mostrarInv(tempInv);
					break;

				case 6:
					v.showInv(objetos);
					break;
			}
		}

	}
}