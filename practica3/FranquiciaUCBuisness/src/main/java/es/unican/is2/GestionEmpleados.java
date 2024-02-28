package es.unican.is2;

import es.unican.is2.DAO.IEmpleadosDAO;
import es.unican.is2.DAO.ITiendasDAO;
import es.unican.is2.IGestion.IGestionAltasBajas;
import es.unican.is2.IGestion.IGestionEmpleados;
import es.unican.is2.clases.DataAccessException;
import es.unican.is2.clases.Empleado;
import es.unican.is2.clases.OperacionNoValidaException;

public class GestionEmpleados implements IGestionEmpleados, IGestionAltasBajas {
	
	private ITiendasDAO tiendasDAO;
	private IEmpleadosDAO empleadosDAO;
	
	public GestionEmpleados(ITiendasDAO tiendasDAO, IEmpleadosDAO empleadosDAO){
		this.tiendasDAO = tiendasDAO;
		this.empleadosDAO = empleadosDAO;
	}
	
	@Override
	public boolean bajaMedica(String dni) throws DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean altaMedica(String dni) throws DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Empleado nuevoEmpleado(Empleado e, String nombre) throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado eliminarEmpleado(String dni, String nombre) throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean trasladarEmpleado(String dni, String actual, String destino)
			throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Empleado empleado(String dni) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
