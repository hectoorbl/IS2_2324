package es.unican.is2.listaOrdenadaAcotada;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import es.unican.is2.listaOrdenadaAcotada.ListaOrdenadaAcotada;

public class ListaOrdenadaAcotadaTest {
    ListaOrdenadaAcotada<Integer> listaLlena;
    ListaOrdenadaAcotada<Integer> listaElem;
    ListaOrdenadaAcotada<Integer> listaVacia;
    
    @BeforeEach
    public void setUp() {
        listaLlena = new ListaOrdenadaAcotada<>(2);
        listaElem = new ListaOrdenadaAcotada<>(2);
        listaVacia= new ListaOrdenadaAcotada<>(2);
        
        listaLlena.add(1);
        listaLlena.add(2);
        listaElem.add(2);
    }
    
    @Test
    public void testListaOrdenadaAcotada() {
        assertDoesNotThrow(() -> new ListaOrdenadaAcotada<Integer>(1));
        assertDoesNotThrow(() -> new ListaOrdenadaAcotada<Integer>(0));
        assertThrows(NegativeArraySizeException.class, () -> new ListaOrdenadaAcotada<Integer>(-1));
    }


    @Test
    public void testAdd() {
        listaElem.add(1);
        assertEquals(2, listaElem.size());
        assertEquals(1, listaElem.get(0));
        
        listaVacia.add(2);
        assertEquals(1, listaVacia.size());
        assertEquals(2, listaVacia.get(0));
        
        assertThrows(NullPointerException.class, () -> listaLlena.add(null));
        assertThrows(IllegalStateException.class, () -> listaLlena.add(3));
        assertEquals(2, listaLlena.size());

    }

    @Test
    public void testGet() {
        assertEquals(2, listaLlena.get(1));
        assertEquals(2, listaElem.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> listaVacia.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> listaLlena.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> listaLlena.get(2));
    }

    @Test
    public void testRemove() {
    	assertEquals(2, listaLlena.remove(1));
        assertEquals(1, listaLlena.size());
        assertEquals(1, listaLlena.get(0));
        
        assertEquals(2, listaElem.remove(0));
        assertEquals(0, listaElem.size());
        
        assertThrows(IndexOutOfBoundsException.class, () -> listaVacia.remove(0));
        assertThrows(IndexOutOfBoundsException.class, () -> listaLlena.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> listaLlena.remove(2));
    }

    @Test
    public void testSize() {
        assertEquals(2, listaLlena.size());
        assertEquals(1, listaElem.size());
        assertEquals(0, listaVacia.size());
    }

    @Test
    public void testClear() {
        listaLlena.clear();
        assertEquals(0, listaLlena.size());
        listaElem.clear();
        assertEquals(0, listaElem.size());
        listaVacia.clear();
        assertEquals(0, listaVacia.size());
    }
    
}
