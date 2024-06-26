package es.unican.is2.clases;



import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/**
 * Clase que representa un empleado de la franquicia, 
 * con sus datos personales 
 * y su estado en la franquicia (baja y categoria)
 */
public class Empleado {
	
	private String DNI;
	private String nombre;
	private Categoria categoria;
	private LocalDate fechaContratacion;
	private boolean baja = false;
	
	public Empleado() {	}
	
	/**
	 * Constructor del empleado con DNI, nombre, categoria y fecha de contratacion.
	 * Por defecto, baja se inicializa a false. 
	 * @param DNI
	 * @param nombre
	 * @param categoria
	 * @param fechaContratacion
	 */
	public Empleado(String DNI, String nombre, Categoria categoria, LocalDate fechaContratacion)throws DatoNoValido {
		if (nombre == null || nombre.isBlank()) {
			throw new DatoNoValido();
		}
		this.nombre = nombre;
		if (DNI == null || DNI.isBlank()) {
			throw new DatoNoValido();
		}
		this.DNI=DNI;
		if (categoria == null) {
			throw new DatoNoValido();
		}
		this.categoria=categoria;
		if (fechaContratacion.isAfter(LocalDate.now())) {
			throw new DatoNoValido();
		}
		this.fechaContratacion=fechaContratacion;
	}
	
	/**
	 * Retorna el sueldo bruto del empleado
	 */
	public double sueldoBruto() {
		int sueldoBruto;
		
		int sueldoBase;
		switch (categoria) {
		case ENCARGADO:
			sueldoBase = 2000;
			break;
		case VENDEDOR:
			sueldoBase = 1500;
					break;
		case AUXILIAR:
			sueldoBase = 1000;
			break;
		default:
			sueldoBase = 1000;
			break;
		
		}
		int complemento;
		long antiguedad = ChronoUnit.YEARS.between(fechaContratacion, LocalDate.now());
        if (antiguedad > 5 && antiguedad <= 10) {
        	complemento = 50;
        } else if (antiguedad > 10 && antiguedad <= 20) {
        	complemento = 100;
        } else if (antiguedad > 20) {
        	complemento = 200;
        } else {
        	complemento = 0;
        }
        
        sueldoBruto = sueldoBase + complemento;
        
        if (baja) {
			sueldoBruto *= 0.75;
		}
		
		return sueldoBruto;
	}
	
	/** 
	 * Dar de baja al empleado
	 */
	public void darDeBaja() {
		this.baja=true;
	}
	
	/**
	 * Dar de alta al empleado
	 */
	public void darDeAlta() {
		this.baja=false;
	}
	
	
	/**
	 * Retorna el dni del vendedor
	 * @return id
	 */
	public String getDNI() {
		return DNI;
	}
	
	/**
	 * Retorna el nombre del vendedor
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Retorna la categoria del empleado
	 *  @return categoria
	 */
	public Categoria getCategoria () {
		return categoria;
	}
	
	/**
	 * Retorna la fecha de contrato
	 * @return Fecha de contratacion
	 */
	public LocalDate getFechaContratacion() {
		return fechaContratacion;
	}
	
	/**
	 * Retorna si el empleado est� de baja
	 * @return true si esta de baja
	 *         false si no lo esta
	 */
	public boolean getBaja() {
		return baja;
	}
		
	
	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setFechaContratacion(LocalDate fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
	
	public void setBaja(boolean baja) {
		this.baja = baja;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
