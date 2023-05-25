package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hamburguesas.modelo.Pedido;
import hamburguesas.modelo.ProductoMenu;

public class PedidoTest {

	@Before
	public void setUp() throws Exception {
	}



	@Test
	public void testGetIdPedido() {
		Pedido pedido = new Pedido("andres", "122");
		Assert.assertNotNull(pedido.getIdPedido());
	}

	@Test
	public void testAgregarProducto() {
		Pedido pedido = new Pedido("andres", "122");
		ProductoMenu producto = new ProductoMenu("Papas", 1000);
		pedido.agregarProducto(producto);
		Assert.assertEquals(1, pedido.getItems().size());
		ProductoMenu producto2 = new ProductoMenu("Papas", 200000);
		pedido.agregarProducto(producto2);
		Assert.assertEquals(1, pedido.getItems().size());
	}

	@Test
	public void testGetItems() {
		Pedido pedido = new Pedido("andres", "122");
		ProductoMenu producto = new ProductoMenu("Papas", 1000);
		pedido.agregarProducto(producto);
		pedido.agregarProducto(producto);
		pedido.agregarProducto(producto);
		Assert.assertEquals(3, pedido.getItems().size());
	}

	@Test
	public void testGenerarTextoFactura() {
		Pedido pedido = new Pedido("andres", "122");
		ProductoMenu producto = new ProductoMenu("Papas", 1000);
		pedido.agregarProducto(producto);
		int id = pedido.getIdPedido();
		String string = "Nombre del cliente: " + "andres" + " Dirección del cliente: " + "122" + " ID del pedido: " + 
			    Integer.toString(id) + "\n" + "Papas" + "\n" + "Precio Neto del pedido: " + "1000" + "$" + "\n" + "IVA del 19% aplicado: " + "190"
				+ "$" + "\n" + "Precio total facturado: " + "1190" + "$";
		Assert.assertEquals(string, pedido.generarTextoFactura()); 
	}

	@Test
	public void testGuardarFactura() {
		fail("Not yet implemented");
	}

}
