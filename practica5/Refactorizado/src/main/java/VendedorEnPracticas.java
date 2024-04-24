public class VendedorEnPracticas extends Vendedor {
	
	/**
	 * Retorna un nuevo vendedor en practicas
	 * @param nombre
	 * @param dni
	 */
	public VendedorEnPracticas(String nombre, String id, String dni) {	//WMC 1	//CCOG 0
		super(nombre, id, dni);
	}
	

	@Override
	public boolean equals(Object obj) {	//WMC 2	//CCOG 1
		if (!(obj instanceof VendedorEnPracticas)) //+1	//+1
			return false;
		VendedorEnPracticas v = (VendedorEnPracticas) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni()));
	}
}
