package es.unican.is2;

import org.fest.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VistaGerenteTest {
	private FrameFixture demo;

	@BeforeEach
	public void setUp() {
		TiendasDAO tiendasDAO = new TiendasDAO();
		EmpleadosDAO empleadosDAO = new EmpleadosDAO();
		GestionTiendas gTiendas = new GestionTiendas(tiendasDAO);
		GestionEmpleados gEmpleados = new GestionEmpleados(tiendasDAO, empleadosDAO);
		VistaGerente gui = new VistaGerente(gTiendas, gEmpleados);
		demo = new FrameFixture(gui);
		gui.setVisible(true);	
	}
	
	@AfterEach
	public void tearDown() {
		demo.cleanUp();
	}
	
	@Test
	public void testBuscarTiendaExistente() {
	    demo.button("btnBuscar").requireText("Buscar");
	    demo.textBox("txtNombreTienda").enterText("Tienda A");
	    demo.button("btnBuscar").click();
	    demo.textBox("txtDireccionTienda").requireText("Dirección A");
	    try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}

	@Test
	public void testBuscarTiendaNoExistente() {
	    demo.button("btnBuscar").requireText("Buscar");
	    demo.textBox("txtNombreTienda").enterText("Tienda");
	    demo.button("btnBuscar").click();
	    demo.textBox("txtDireccionTienda").requireText("Tienda No Existe");
	    try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}

	@Test
	public void testBuscarTiendaSinTexto() {
	    demo.button("btnBuscar").requireText("Buscar");
	    demo.textBox("txtNombreTienda").enterText("");
	    demo.button("btnBuscar").click();
	    demo.textBox("txtDireccionTienda").requireText("Tienda No Existe");
	    try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}

	@Test
	public void testBuscarTiendaNull() {
	    demo.button("btnBuscar").requireText("Buscar");
	    demo.textBox("txtNombreTienda").enterText(null);
	    demo.button("btnBuscar").click();
	    demo.textBox("txtDireccionTienda").requireText("Tienda No Existe");
	    try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}

}
