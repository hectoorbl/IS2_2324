package es.unican.is2;

import es.unican.is2.DAO.IEmpleadosDAO;
import es.unican.is2.DAO.ITiendasDAO;
import es.unican.is2.IGestion.IGestionAltasBajas;
import es.unican.is2.IGestion.IGestionEmpleados;
import es.unican.is2.clases.DataAccessException;
import es.unican.is2.clases.Empleado;
import es.unican.is2.clases.OperacionNoValidaException;
import es.unican.is2.clases.Tienda;

public class GestionEmpleados implements IGestionEmpleados, IGestionAltasBajas {
	
	private ITiendasDAO tiendasDAO;
	private IEmpleadosDAO empleadosDAO;
	
	public GestionEmpleados(ITiendasDAO tiendasDAO, IEmpleadosDAO empleadosDAO){
		this.tiendasDAO = tiendasDAO;
		this.empleadosDAO = empleadosDAO;
	}
	
	@Override
    public boolean bajaMedica(String dni) throws DataAccessException {
        Empleado empleado = empleadosDAO.empleado(dni);
        if (empleado != null) {
            empleado.darDeBaja();
            empleadosDAO.modificarEmpleado(empleado);
            return true;
        }
        return false;
    }

    @Override
    public boolean altaMedica(String dni) throws DataAccessException {
        Empleado empleado = empleadosDAO.empleado(dni);
        if (empleado != null) {
            empleado.darDeAlta();
            empleadosDAO.modificarEmpleado(empleado);
            return true;
        }
        return false;
    }

    @Override
    public Empleado nuevoEmpleado(Empleado e, String nombre) throws OperacionNoValidaException, DataAccessException {
        Tienda tienda = tiendasDAO.tiendaPorNombre(nombre);
        if (tienda == null) {
            return null;
        }
        Empleado empleadoExistente = empleadosDAO.empleado(e.getDNI());
        if (empleadoExistente != null) {
            throw new OperacionNoValidaException("El empleado ya existe.");
        }
        tiendasDAO.modificarTienda(tienda);
        return empleadosDAO.crearEmpleado(e);
    }

    @Override
    public Empleado eliminarEmpleado(String dni, String nombre) throws OperacionNoValidaException, DataAccessException {
        Tienda tienda = tiendasDAO.tiendaPorNombre(nombre);
        Empleado empleado = empleadosDAO.empleado(dni);
        if (tienda == null || empleadosDAO.empleado(dni) == null) {
            return null; 
        }
        if (!tienda.getEmpleados().contains(empleado)) {
            throw new OperacionNoValidaException("El empleado no pertenece a la tienda indicada.");
        }
        tienda.getEmpleados().remove(empleado);
        tiendasDAO.modificarTienda(tienda);
        return empleadosDAO.eliminarEmpleado(dni);
    }

    @Override
    public boolean trasladarEmpleado(String dni, String actual, String destino)
            throws OperacionNoValidaException, DataAccessException {
        Tienda tiendaActual = tiendasDAO.tiendaPorNombre(actual);
        Tienda tiendaDestino = tiendasDAO.tiendaPorNombre(destino);
        if (tiendaActual == null || tiendaDestino == null) {
            return false;
        }
        Empleado empleado = empleadosDAO.empleado(dni);
        if (empleado == null) {
            return false;
        }
        if (!tiendaActual.getEmpleados().contains(empleado)) {
            throw new OperacionNoValidaException("El empleado no pertenece a la tienda actual.");
        }
        tiendaActual.getEmpleados().remove(empleado);
        tiendaDestino.getEmpleados().add(empleado);
        tiendasDAO.modificarTienda(tiendaActual);
        tiendasDAO.modificarTienda(tiendaDestino);

        return true;
    }

    @Override
    public Empleado empleado(String dni) throws DataAccessException {
        return empleadosDAO.empleado(dni);
    }
}