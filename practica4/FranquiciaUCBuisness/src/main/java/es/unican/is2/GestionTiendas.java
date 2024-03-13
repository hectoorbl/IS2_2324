package es.unican.is2;

import es.unican.is2.DAO.ITiendasDAO;
import es.unican.is2.IGestion.IGestionTiendas;
import es.unican.is2.clases.DataAccessException;
import es.unican.is2.clases.OperacionNoValidaException;
import es.unican.is2.clases.Tienda;

public class GestionTiendas implements IGestionTiendas {
    private ITiendasDAO tiendasDAO;

    public GestionTiendas(ITiendasDAO tiendasDAO) {
        this.tiendasDAO = tiendasDAO;
    }

    @Override
    public Tienda nuevaTienda(Tienda t) throws DataAccessException {
        Tienda tiendaExistente = tiendasDAO.tiendaPorNombre(t.getNombre());
        if (tiendaExistente != null) {
            return null;
        } else {
            Tienda nuevaTienda = tiendasDAO.crearTienda(t);
            return nuevaTienda;
        }
    }

    @Override
    public Tienda eliminarTienda(String nombre) throws OperacionNoValidaException, DataAccessException {
        Tienda tiendaAEliminar = tiendasDAO.tiendaPorNombre(nombre);
        if (tiendaAEliminar != null) {
            if (!tiendaAEliminar.getEmpleados().isEmpty()) {
                throw new OperacionNoValidaException("No se puede eliminar la tienda porque tiene empleados.");
            }
            return tiendasDAO.eliminarTienda(tiendaAEliminar.getId());
        } else {
            return null;
        }
    }

    @Override
    public Tienda tienda(String nombre) throws DataAccessException {
        return tiendasDAO.tiendaPorNombre(nombre);
    }

}
