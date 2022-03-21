import java.util.*;

class Main{
	public static void main(String[] args){

		Vista v = new Vista();
		MapFactory f = new MapFactory();
		Map<String, ArrayList<Objeto>> objetos = f.createMap(v.getTipo());

		try{
			objetos = v.leer(objetos);
		} catch(Exception e){
			System.out.println("xd");
		}

		v.showMap(objetos);
		

	}
}