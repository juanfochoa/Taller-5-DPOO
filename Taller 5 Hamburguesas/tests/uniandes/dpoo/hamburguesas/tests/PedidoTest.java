package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;


public class PedidoTest {
	private Pedido pedido1;
	
	@BeforeEach
	void setUp() {
		pedido1 = new Pedido("Juanfe", "Uniandes");
	}
	
	@AfterEach
	void TearDown() {
	}
	
	@Test
	void testAgregarProducto() {
		ProductoMenu producto = new ProductoMenu("corral",14000);
		pedido1.agregarProducto(producto);
		assertEquals(16660,pedido1.getPrecioTotalPedido());
	}
	
	@Test
	void testGenerarTextoFactura() {
		String factura = pedido1.generarTextoFactura();
		assertTrue(factura.contains("Cliente: Juanfe"));
		assertTrue(factura.contains("Dirección: Uniandes"));
	}
}
