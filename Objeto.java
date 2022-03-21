class Objeto{
	String nombre;
	int cantidad;
	String categoria;

	public Objeto(String nombre, int cantidad, String categoria){
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.categoria = categoria;
	}

	public String getNombre(){
		return nombre;
	}

	public int getCantidad(){
		return cantidad;
	}

	public String getCategoria(){
		return categoria;
	}

	//@Override
	//public String toString(){
		//return nombre + " | " + categoria + " | Cantidad: " + cantidad; 
	//}
}