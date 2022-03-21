import java.util.*;

class Main{
	public static void main(String[] args){

		Vista v = new Vista();
		MapFactory f = new MapFactory();
		Map<String, Objeto> objetos = f.createMap(v.getTipo());

		try{
			v.leer();
		} catch(Exception e){
			System.out.println("xd");
		}
		

	}
}