package es.unican.is2.clases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ITiendaTest {

	@Test
	void testTiendaStringString() {
		assertDoesNotThrow(() -> new Tienda("T", "D"));
		
		assertThrows(DatoNoValido.class, () -> new Tienda("", "D"));
		assertThrows(DatoNoValido.class, () -> new Tienda(null, "D"));
		assertThrows(DatoNoValido.class, () -> new Tienda("T", ""));
		assertThrows(DatoNoValido.class, () -> new Tienda("T", null));
	}

	@Test
	void testGastoMensualSueldos() {
		Tienda t = null;
		try {
			t = new Tienda("T", "D");
		} catch (DatoNoValido e) {
			e.printStackTrace();
		}
		assertEquals(0.0, t.gastoMensualSueldos());
		//añadiria casos con empleados en la tienda, pero no se como añadirlos
	}

}
