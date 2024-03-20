package es.unican.is2;

import static org.junit.jupiter.api.Assertions.*;

import org.fest.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VistaGerenteTest {
	private FrameFixture demo;

	@BeforeEach
	public void setUp() {
		EjemploFEST gui = new EjemploFEST();
		demo = new FrameFixture(gui);
		gui.setVisible(true);	
	}
	
	@AfterEach
	public void tearDown() {
		demo.cleanUp();
	}
	
	@Test
	public void test() {
		// Comprobamos que la interfaz tiene el aspecto deseado
		demo.button("btnPulsar").requireText("ˇPulsa!");
		
		//  Prueba de saludo con nombre
		// Escribimos un nombre
		demo.textBox("txtNombre").enterText("Patri");
		// Pulsamos el botón
		demo.button("btnPulsar").click();		
		// Comprobamos la salida
		demo.textBox("txtSaludo").requireText("ˇHola Patri!");
		
		// Prueba de saludo sin nombre
		demo.textBox("txtNombre").setText("");
		demo.button("btnPulsar").click();
		demo.textBox("txtSaludo").requireText("ˇHola!");
		
		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
