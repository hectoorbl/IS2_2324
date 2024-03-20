package es.unican.is2.clases;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;


class EmpleadoTest {

	@Test
	void testEmpleado() {
		assertDoesNotThrow(() -> new Empleado("1", "Hector", Categoria.ENCARGADO, LocalDate.now()));
        assertDoesNotThrow(() -> new Empleado("1", "Hector", Categoria.VENDEDOR, LocalDate.now().minusDays(5)));
        assertDoesNotThrow(() -> new Empleado("1", "Hector", Categoria.AUXILIAR, LocalDate.now()));
		
		assertThrows(DatoNoValido.class, () -> new Empleado("", "Hector", Categoria.ENCARGADO, LocalDate.now()));
		assertThrows(DatoNoValido.class, () -> new Empleado(null, "Hector", Categoria.VENDEDOR, LocalDate.now().minusDays(5)));
		assertThrows(DatoNoValido.class, () -> new Empleado("1", "", Categoria.AUXILIAR, LocalDate.now()));
		assertThrows(DatoNoValido.class, () -> new Empleado("", null, Categoria.ENCARGADO, LocalDate.now()));
		assertThrows(DatoNoValido.class, () -> new Empleado("", "Hector", null, LocalDate.now().minusDays(5)));
		assertThrows(DatoNoValido.class, () -> new Empleado("", "Hector", Categoria.VENDEDOR, null));
		assertThrows(DatoNoValido.class, () -> new Empleado("", "Hector", Categoria.AUXILIAR, LocalDate.now().plusDays(5)));		
	}

	@Test
	void testSueldoBruto() throws DatoNoValido {
		Empleado e;
		 e = new Empleado("1", "Hector", Categoria.ENCARGADO, LocalDate.now());
		 assertEquals(2000, e.sueldoBruto());
		 e = new Empleado("1", "Hector", Categoria.VENDEDOR, LocalDate.now().minusYears(2));
		 assertEquals(1500, e.sueldoBruto());
		 e = new Empleado("1", "Hector", Categoria.AUXILIAR, LocalDate.now().minusYears(5));
		 assertEquals(1000, e.sueldoBruto());
		 e = new Empleado("1", "Hector", Categoria.ENCARGADO, LocalDate.now().minusYears(6));
		 assertEquals(2050, e.sueldoBruto());
		 e = new Empleado("1", "Hector", Categoria.VENDEDOR, LocalDate.now().minusYears(7));
		 assertEquals(1550, e.sueldoBruto());
		 e = new Empleado("1", "Hector", Categoria.AUXILIAR, LocalDate.now().minusYears(10));
		 assertEquals(1050, e.sueldoBruto());
		 e = new Empleado("1", "Hector", Categoria.ENCARGADO, LocalDate.now().minusYears(11));
		 assertEquals(2100, e.sueldoBruto());
		 e = new Empleado("1", "Hector", Categoria.VENDEDOR, LocalDate.now().minusYears(15));
		 assertEquals(1600, e.sueldoBruto());
		 e = new Empleado("1", "Hector", Categoria.AUXILIAR, LocalDate.now().minusYears(20));
		 assertEquals(1100, e.sueldoBruto());
		 e = new Empleado("1", "Hector", Categoria.ENCARGADO, LocalDate.now().minusYears(21));
		 assertEquals(2200, e.sueldoBruto());
		 e = new Empleado("1", "Hector", Categoria.VENDEDOR, LocalDate.now().minusYears(30));
		 assertEquals(1700, e.sueldoBruto());
	}

}
