package es.unican.is2;

import es.unican.is2.DAO.ITiendasDAO;
import es.unican.is2.IGestion.IGestionTiendas;
import es.unican.is2.clases.DataAccessException;
import es.unican.is2.clases.OperacionNoValidaException;
import es.unican.is2.clases.Tienda;

public class GestionTiendas implements IGestionTiendas{
	private ITiendasDAO tiendasDAO;
	
	public GestionTiendas(ITiendasDAO tiendasDAO){
		this.tiendasDAO = tiendasDAO;
	}
	
	@Override
	public Tienda nuevaTienda(Tienda t) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tienda eliminarTienda(String nombre) throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tienda tienda(String nombre) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}



}
