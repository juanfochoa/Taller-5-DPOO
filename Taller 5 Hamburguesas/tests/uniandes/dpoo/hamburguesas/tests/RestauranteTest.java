package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Restaurante;
import uniandes.dpoo.hamburguesas.excepciones.*;

import java.io.File;
import java.io.IOException;

public class RestauranteTest {
	private Restaurante restaurante1;
	
	@BeforeEach
	void setUp() {
		restaurante1 = new Restaurante();
	}
	
	@AfterEach
	void TearDown() {
	}
	
	@Test
	void testIniciarPedido() {
		try {
			restaurante1.iniciarPedido("Juan", "Uniandes");
			assertNotNull(restaurante1.getPedidoEnCurso());
			assertEquals("Juan",restaurante1.getPedidoEnCurso().getNombreCliente());
		} catch (YaHayUnPedidoEnCursoException e) {
			fail("No debería haber un pedido en curso al inicio.");
		}
	}
	
	@Test
	void testIniciarPedidoConExcepcion() {
		try {
			restaurante1.iniciarPedido("Juan", "Uniandes");
			restaurante1.iniciarPedido("Felipe", "127 con 7ma");
			fail("Debería lanzar una excepción YaHayUnPedidoEnCursoException.");
		} catch (YaHayUnPedidoEnCursoException e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testCerrarYGuardarPedido() {
		try {
			restaurante1.iniciarPedido("Juan", "Uniandes");
			restaurante1.cerrarYGuardarPedido();
			assertNull(restaurante1.getPedidoEnCurso());
		} catch (NoHayPedidoEnCursoException | IOException e) {
			fail("No se pudo cerrar y guardar el pedido correctamente." + e.getMessage());
		} catch (YaHayUnPedidoEnCursoException e) {
			fail("Se produjo un erro al iniciar el pedido.");
		}
	}
	
	@Test
	void testCerrarPedidosinIniciar() {
		try {
			restaurante1.cerrarYGuardarPedido();
			fail("Debería lanzar una excepción NoHayPedidoEnCursoException.");
		} catch (NoHayPedidoEnCursoException e) {
			assertTrue(true);
		} catch (IOException e) {
			fail("Error inesperado al intentar guardar.");
		}
	}
	
	@Test
	void testCargarInformacionRestaurante() {
		File archivoIngredientes = new File("data/ingredientes.txt");
		File archivoMenu = new File("data/menu.txt");
		File archivoCombos = new File("data/combos.txt");
		
		try {
			restaurante1.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);
			assertFalse(restaurante1.getIngredientes().isEmpty());
			assertFalse(restaurante1.getMenuBase().isEmpty());
			assertFalse(restaurante1.getMenuCombos().isEmpty());
		} catch (HamburguesaException | IOException | NumberFormatException e) {
			fail("Error al cargar la información del restaurante: " + e.getMessage());
		}
	}
	
	@Test
	void testGetPedidos() {
		assertNotNull(restaurante1.getPedidos());
		assertEquals(0,restaurante1.getPedidos().size());
	}
	
	@Test
	void testGetMenuBase() {
		assertNotNull(restaurante1.getMenuBase());
	}
	
	@Test
	void testGetMenuCombos() {
		assertNotNull(restaurante1.getMenuBase());
	}
	
	@Test
	void testGetIngredientes() {
		assertNotNull(restaurante1.getIngredientes());
	}
}
