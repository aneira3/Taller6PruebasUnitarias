package tests;

import static org.junit.Assert.*;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import hamburguesas.modelo.ProductoMenu;

public class ProductoMenuTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testProductoMenu() {
		ProductoMenu a = new ProductoMenu("papas",1000);
		a.generarTextoFactura();
		a.getPrecio();
		a.getNombre();
		Assert.assertEquals("papas" + "\n",a.generarTextoFactura());
		Assert.assertEquals(1000,a.getPrecio());
		Assert.assertEquals("papas",a.getNombre());
	}

	

}
