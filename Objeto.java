/**
 * Clase para almacenar los datos de cada objeto
 * 
 */

class Objeto{
	String nombre;
	int cantidad;
	String categoria;

	/**
	* Constructor
	* 
	* @param nombre nombre del objeto
	* @param cantidad cantidad del objeto 
	* @param categoria categoria del objeto
	*/
	public Objeto(String nombre, int cantidad, String categoria){
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.categoria = categoria;
	}

	/**
	 * getter para el nombre
	 * 
	 * @return el nombre del objeto
	 */
	public String getNombre(){
		return nombre;
	}

	/**
	 * getter para la cantidad
	 * 
	 * @return la cantidad del objeto
	 */
	public int getCantidad(){
		return cantidad;
	}

	/**
	 * getter para la categoria
	 * 
	 * @return la categoria del objeto
	 */
	public String getCategoria(){
		return categoria;
	}

	/**
	 * Incrementa la cantidad del objeto por 1
	 * 
	 */
	public void agregar(){
		cantidad++;
	}

	/**
	 * Override de toString para mostrar todos los atributos del objeto
	 * 
	 * @return un string con todos los atributos del objeto
	 */
	@Override
	public String toString(){
		return nombre + " | " + categoria + " | Cantidad: " + cantidad; 
	}
}