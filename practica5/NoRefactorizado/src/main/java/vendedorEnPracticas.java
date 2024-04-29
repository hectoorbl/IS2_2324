public class vendedorEnPracticas extends Vendedor {
	
	private String dni;
	
	/**
	 * Retorna un nuevo vendedor en practicas
	 * @param nombre
	 * @param dni
	 */
	public vendedorEnPracticas(String nombre, String id, String dni) {	//WMC 1	//CCOG 0
		super(nombre, id);
		this.dni= dni;
	}
	
	public String getDni() {	//WMC 1	//CCOG 0
		return dni;
	}

	@Override
	public boolean equals(Object obj) {	//WMC 2	//CCOG 1
		if (!(obj instanceof vendedorEnPracticas)) //+1	//+1
			return false;
		vendedorEnPracticas v = (vendedorEnPracticas) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni()));	
	}
}
