public class VendedorEnPlantilla extends Vendedor {
	
	private TipoVendedor tipo;
	private String dni;
	
	/**
	 * Retorna un nuevo vendedor en plantilla del tipo que se indica
	 * @param nombre
	 * @param dni
	 * @param tipo
	 */
	public VendedorEnPlantilla(String nombre, String id, String dni, TipoVendedor tipo) {	//WMC 1	//CCOG 0
		super(nombre, id);
		this.tipo = tipo;
		this.dni=dni;
	}
	
	public TipoVendedor tipo() {	//WMC 1	//CCOG 0
		return tipo;
	}
	
	public String dni() {	//WMC 1	//CCOG 0
		return dni;
	}
	
	@Override
	public boolean equals(Object obj) {	//WMC 2	//CCOG 1
		if (!(obj instanceof VendedorEnPlantilla))	//+1	//+1
			return false;
		VendedorEnPlantilla v = (VendedorEnPlantilla) obj;
		return (v.getId().equals(getId()) && v.dni().equals(dni()));
	}
}
