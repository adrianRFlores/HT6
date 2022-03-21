import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.text.Normalizer;

class Vista{
	
	Scanner scan = new Scanner(System.in);

	public void leer(){
		try{
			Scanner read = new Scanner(new File("ListadoProducto.txt"));
			while(read.hasNextLine()){
				String data = read.nextLine();
				System.out.println(clean(data));
			}

		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}

	public String clean(String s) {
    	//s = Normalizer.normalize(s, Normalizer.Form.NFD);
    	//s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    	//return s;
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

}