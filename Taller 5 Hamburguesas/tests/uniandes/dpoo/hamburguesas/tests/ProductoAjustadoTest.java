package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;

public class ProductoAjustadoTest {
	private ProductoAjustado productoAjustado1;
	private ProductoMenu productoBase;

	
	@BeforeEach
	void setUp() throws Exception{
		productoBase = new ProductoMenu("Hamburguesa sencilla",8000);
		productoAjustado1 = new ProductoAjustado(productoBase);
	}
	
	@AfterEach
    void tearDown( ) throws Exception
    {
    }
	
	@Test
	void testGetNombre() {
		assertEquals("Hamburguesa sencilla", productoAjustado1.getNombre(), "El nombre del producto ajustado debería ser el del producto base.");
	}
	
	@Test
	void testGetPrecio() {
		assertEquals(8000,productoAjustado1.getPrecio(),"El precio del producto ajustado debería ser 8000 sin ingredientes adicionales.");
		Ingrediente queso = new Ingrediente("Queso", 1500);
		productoAjustado1.agregarIngrediente(queso);
		assertEquals(9500,productoAjustado1.getPrecio(),"El precio debería ser 9500 después de añadir ingredientes adicionales.");
	}
	
	@Test
	void testGenerarTextoFactura() {
		String textoFactura = productoAjustado1.generarTextoFactura();
		assertTrue(textoFactura.contains("Hamburguesa sencilla"), "La factura debería contener 'Hamburguesa sencilla' como nombre del producto");
				
		String expectedPrecio = "8000";
		assertTrue(textoFactura.contains(expectedPrecio),"La factura debería incluir el precio total ajustado.");
	}
}
