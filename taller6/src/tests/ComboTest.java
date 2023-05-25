package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hamburguesas.modelo.Combo;
import hamburguesas.modelo.ProductoMenu;

public class ComboTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCombo() {
		Combo combo = new Combo("Combo x", 12000);
		Assert.assertEquals("Combo x", combo.getNombre());
	}

	@Test
	public void testItemsComboOriginales() {
		ProductoMenu producto = new ProductoMenu("Papas", 1000);
		Combo combo = new Combo("Combo x", 12000);
		combo.itemsComboOriginales(producto);
		int tamaño = combo.getelementosCombo().size();
		Assert.assertEquals(1, tamaño);
	}

	@Test
	public void testGetelementosCombo() {
		ProductoMenu producto = new ProductoMenu("Papas", 1000);
		Combo combo = new Combo("Combo x", 12000);
		combo.itemsComboOriginales(producto);
		combo.itemsComboOriginales(producto);
		combo.itemsComboOriginales(producto);
		int tamaño = combo.getelementosCombo().size();
		Assert.assertEquals(3, tamaño);
	}

	@Test
	public void testAgregarItemACombo() {
		ProductoMenu producto = new ProductoMenu("Papas", 1000);
		Combo combo = new Combo("Combo x", 12000);
		combo.agregarItemACombo(producto);
		int tamaño = combo.getItemsCombo().size();
		Assert.assertEquals(1, tamaño);
	}
	
	@Test
	public void testGetItemsCombo() {
		ProductoMenu producto = new ProductoMenu("Papas", 1000);
		Combo combo = new Combo("Combo x", 12000);
		combo.agregarItemACombo(producto);
		combo.agregarItemACombo(producto);
		combo.agregarItemACombo(producto);
		combo.agregarItemACombo(producto);
		int tamaño = combo.getItemsCombo().size();
		Assert.assertEquals(4, tamaño);
	}
	
	

	@Test
	public void testGetPrecio() {
		Combo combo = new Combo("Combo x", 10);
		ProductoMenu producto = new ProductoMenu("Papas", 1000);
		combo.itemsComboOriginales(producto);
		Assert.assertEquals(900,combo.getPrecio());
		combo.agregarItemACombo(producto);
		Assert.assertEquals(1900, combo.getPrecio());
	}

	@Test
	public void testGetNombre() {
		Combo combo = new Combo("Combo x", 10);
		Assert.assertEquals("Combo x", combo.getNombre());
	}

	@Test
	public void testGenerarTextoFactura() {
		Combo combo = new Combo("Combo x", 10);
		combo.generarTextoFactura();
		Assert.assertEquals("Combo x" + "\n", combo.generarTextoFactura());
		ProductoMenu producto = new ProductoMenu("Papas", 1000);
		combo.agregarItemACombo(producto);
		combo.agregarItemACombo(producto);
		combo.agregarItemACombo(producto);
		Assert.assertEquals( "Combo x"+ " con adición de " + "Papas Papas Papas "  + "\n",combo.generarTextoFactura());
	}
	


}
