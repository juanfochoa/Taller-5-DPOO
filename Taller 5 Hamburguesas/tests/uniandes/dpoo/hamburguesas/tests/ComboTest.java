package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ComboTest {
	private Combo combo1;
	
	@BeforeEach
	void setUp() throws Exception {
		ProductoMenu producto1 = new ProductoMenu("corral",14000);
		ProductoMenu papas = new ProductoMenu("papas medianas",5500);
		
		ArrayList<ProductoMenu> productos = new ArrayList<>();
		productos.add(producto1);
		productos.add(papas);
		
		combo1 = new Combo("combo corral",0.1,productos);
	}
	
	@AfterEach
	void tearDown() throws Exception{
	}
	
	@Test
	void testCalcularPrecio() {
		assertEquals(17550,combo1.getPrecio(),0.01);
	}
	
	@Test
	void testGenerarTextoFactura() {
		String factura = combo1.generarTextoFactura();
		assertTrue(factura.contains("Descuento: 10%"));
	}
}
