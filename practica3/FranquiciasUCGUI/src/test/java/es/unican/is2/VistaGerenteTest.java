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
	public void test() {
		demo.button("btnBuscar").requireText("Buscar");

		
		demo.textBox("Nombre Tienda").enterText("Tienda A");
		demo.button("btnPulsar").click();	
		demo.textBox("Direccion").requireText("Dirección A");
		
		demo.textBox("Nombre Tienda").enterText("Tienda");
		demo.button("btnPulsar").click();	
		demo.textBox("Direccion").requireText("Tienda No Existe");
		
		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
