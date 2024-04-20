/**
 * Vendedor de la tienda. 
 * Por cada vendedor se almacenan sus datos personales 
 * y sus datos sobre ventas y comisiones
 */
public abstract class Vendedor {
	
	private String id;
	private String nombre;
	private String dni;
	private double comision;
	private double totalVentas;

	
	public Vendedor(String nombre, String id, String dni) {	//WMC 1	//CCOG 0
		this.nombre = nombre;
		this.id = id;
		this.dni=dni;
	}

	/**
	 * Retorna el nombre del vendedor
	 * @return nombre
	 */
	public String getNombre() {	//WMC 1	//CCOG 0
		return nombre;
	}
	
	/**
	 * Retorna el id del vendedor
	 * @return id
	 */
	public String getId() {	//WMC 1	//CCOG 0
		return id;
	}
	
	/**
	 * Retorna el dni del vendedor
	 * @return id
	 */
	public String getDni() {
		return dni;
	}
	
	/**
	 * Retorna la comision mensual acumulada
	 * @return Comision total acumulada
	 */
	public double getComision() {	//WMC 1	//CCOG 0
		return comision;
	}
	
	/**
	 * Asigna valor a la comision mensual acumulada
	 * @param value comision a asignar
	 */
	public void setComision(double value) {	//WMC 1	//CCOG 0
		this.comision = value;
	}
	
	/**
	 * Retorna el importe total mensual de ventas
	 * @return importe total de ventas acumuladas
	 */
	public double getTotalVentas( ) {	//WMC 1	//CCOG 0
		return totalVentas;
	}
	
	/**
	 * Asigna valor al total de ventas mensual
	 * @param value total de ventas a asignar
	 */
	public void setTotalVentas(double value) {	//WMC 1	//CCOG 0
		totalVentas = value;
	}
	
	/**
	 * Anhade una nueva venta al vendedor
	 * @param importe de la venta
	 */
	public void anhade(double importe)  {	//WMC 1	//CCOG 0
		totalVentas += importe;
	}
}
