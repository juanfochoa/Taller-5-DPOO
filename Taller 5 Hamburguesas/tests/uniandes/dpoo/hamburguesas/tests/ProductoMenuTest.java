package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ProductoMenuTest {
	
	private ProductoMenu productoMenu1;
	
	@BeforeEach
	void setUp() throws Exception{
		productoMenu1 = new ProductoMenu("corral",14000);	
	}
	
	@AfterEach
    void tearDown( ) throws Exception{
    }
	
	@Test
	void testGetNombre() {
		assertEquals("corral",productoMenu1.getNombre());
	}
	
	@Test
	void testGetPrecio() {
		assertEquals(14000, productoMenu1.getPrecio());
	}
	
	@Test
	void testGenerarTextoFactura() {
		String expected = "corral\n            14000\n";
		assertEquals(expected, productoMenu1.generarTextoFactura());
	}

}
