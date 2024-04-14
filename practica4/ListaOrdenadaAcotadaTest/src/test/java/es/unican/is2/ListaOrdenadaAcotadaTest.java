package es.unican.is2;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ListaOrdenadaAcotadaTest {

    @BeforeEach
    public void setUp() {
    	ListaOrdenadaAcotada<Integer> listaLlena = new ListaOrdenadaAcotada<>(2);
    	ListaOrdenadaAcotada<Integer> listaElem = new ListaOrdenadaAcotada<>(2);
    	ListaOrdenadaAcotada<Integer> listaVacia= new ListaOrdenadaAcotada<>(2);
    	
       	listaLlena.add(1);
    	listaLlena.add(2);
    	listaElem.add(2);
    	
    }
    
    @Test
    public void testListaOrdenadaAcotada() {
       
    }

    @Test
    public void testAdd() {
        // Prueba agregar elementos a la lista
        // Asegúrate de probar con diferentes casos, incluyendo límites
    }

    @Test
    public void testGet() {
        // Prueba obtener elementos de la lista
        // Asegúrate de probar con diferentes índices, incluyendo límites
    }

    @Test
    public void testRemove() {
        // Prueba eliminar elementos de la lista
        // Asegúrate de probar con diferentes índices, incluyendo límites
    }

    @Test
    public void testSize() {
    	assertEquals(2, listaLlena.size());
    	assertEquals(1, listaElem.size());
    	assertEquals(0, listaVacia.size());
    }

    @Test
    public void testClear() {
    	assertEquals(listaVacia, listaLlena.clear());
    	assertEquals(listaVacia, listaElem.clear());
    	assertEquals(listaVacia, listaVacia.clear());
    }
}
