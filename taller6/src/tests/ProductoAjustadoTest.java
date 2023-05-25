package tests;

import static org.junit.Assert.*;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import hamburguesas.modelo.ProductoAjustado;
import hamburguesas.modelo.ProductoMenu;
import hamburguesas.modelo.ingrediente;

public class ProductoAjustadoTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testProductoAjustado() {
		ProductoMenu base = new ProductoMenu("Papas",1000);
		ProductoAjustado producto = new ProductoAjustado(base);
		producto.getNombre();
		producto.getPrecioBase();
	}

	@Test
	public void testAddIngrediente() {
		ProductoMenu base = new ProductoMenu("Papas",1000);
		ProductoAjustado producto = new ProductoAjustado(base);
		ingrediente Ingrediente = new ingrediente("tomate",500);
		producto.addIngrediente(Ingrediente);
		Assert.assertEquals(1, producto.getAgregados().size());
		ingrediente Ingrediente2 = new ingrediente("tomate",500000);
		producto.addIngrediente(Ingrediente2);
		Assert.assertEquals(1, producto.getAgregados().size());
		
		
	}

	@Test
	public void testRemoveIngrediente() {
		ProductoMenu base = new ProductoMenu("Papas",1000);
		ProductoAjustado producto = new ProductoAjustado(base);
		ingrediente Ingrediente = new ingrediente("tomate",500);
		producto.removeIngrediente(Ingrediente);
		producto.removeIngrediente(Ingrediente);
		Assert.assertEquals(2, producto.getEliminados().size());
		ProductoMenu base2 = new ProductoMenu("Papas",100000);
		ProductoAjustado producto2 = new ProductoAjustado(base2);
		producto.removeIngrediente(Ingrediente);
		Assert.assertEquals(1, producto.getEliminados().size());
		
		
	}

	@Test
	public void testGenerarTextoFactura() {
		ProductoMenu base = new ProductoMenu("Papas",1000);
		ProductoAjustado producto = new ProductoAjustado(base);
		ingrediente Ingrediente = new ingrediente("tomate",500);
		String string = "Papas Adiciones: tomate  Eliminaciones: tomate " + "\n";
		producto.addIngrediente(Ingrediente);
		producto.removeIngrediente(Ingrediente);
		Assert.assertEquals(string,producto.generarTextoFactura());
		ProductoMenu base2 = new ProductoMenu("Papas",1000);
		ProductoAjustado producto2 = new ProductoAjustado(base2);
		ingrediente Ingrediente2 = new ingrediente("tomate",500);
		String string2 = "Papas Adiciones: tomate  0 Elementos eliminados" + "\n";
		producto2.addIngrediente(Ingrediente2);
		Assert.assertEquals(string2,producto2.generarTextoFactura());
		ProductoMenu base3 = new ProductoMenu("Papas",1000);
		ProductoAjustado producto3 = new ProductoAjustado(base3);
		ingrediente Ingrediente3 = new ingrediente("tomate",500);
		String string3 = "Papas 0 Elementos agregados Eliminaciones: tomate " + "\n";
		producto3.removeIngrediente(Ingrediente3);
		Assert.assertEquals(string3,producto3.generarTextoFactura());
	}

}
