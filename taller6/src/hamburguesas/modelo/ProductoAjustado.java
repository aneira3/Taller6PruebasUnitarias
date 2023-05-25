package hamburguesas.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class ProductoAjustado implements Producto , Serializable{
	
	private String nombre;
	
	private int precioOriginal;
	
	private List<ingrediente> agregados;
	
	private List<ingrediente> eliminados;
	private ProductoMenu base;
	
	
	
	
	
	
	
	

	public ProductoAjustado(ProductoMenu base) {
		this.base = base;
		this.nombre = base.getNombre();
		this.precioOriginal = base.getPrecio();
		this.agregados = new ArrayList<ingrediente>();
		this.eliminados = new ArrayList<ingrediente>();
		
	}
	
	public List<ingrediente> getAgregados() {
		return agregados;
		
	}
	
	public List<ingrediente> getEliminados() {
		return eliminados;
		
	}
	
	public void addIngrediente(ingrediente elemento) {
		agregados.add(elemento);
		PrecioPedidoException excepcion = new PrecioPedidoException();
		try {
			excepcion.detectarErrorC(getPrecio());
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("\nATENCIÓN, HA HABIDO UN PROBLEMA CON SU PEDIDO:\n");
			System.out.print(e.getMessage());
			System.out.print("\n");
			System.out.print("No se ha podido agregar el ingrediente.");
			System.out.print("\n");
			e.printStackTrace();
			agregados.remove(0);
		}
		
		
	}
	
	public void removeIngrediente(ingrediente elemento) {
		eliminados.add(elemento);
		PrecioPedidoException excepcion = new PrecioPedidoException();
		try {
			excepcion.detectarErrorC(getPrecio());
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("\nATENCIÓN, HA HABIDO UN PROBLEMA CON SU PEDIDO:\n");
			System.out.print(e.getMessage());
			System.out.print("\n");
			System.out.print("No se ha podido registrar el pedido.");
			System.out.print("\n");
			e.printStackTrace();
		
			
		}
		
	}
	
	
	public int getPrecioBase() {
		return precioOriginal;
	}

	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		int resultado = precioOriginal;
		for (ingrediente elemento:agregados){
			resultado += elemento.getCostoAdicional();
		}
		for (ingrediente elemento:eliminados) {
			resultado -= elemento.getCostoAdicional();
		}
		return resultado;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		String elementosAgregados = "Adiciones: ";
		String elementosEliminados = "Eliminaciones: ";
		if (agregados.size() > 0){
			for (ingrediente elemento:agregados) {
					elementosAgregados += elemento.getNombre() + " ";
				}
			
			}
			else {
				elementosAgregados = "0 Elementos agregados";
			}
		if (eliminados.size()>0) {
			for (ingrediente elemento:eliminados) {
				elementosEliminados += elemento.getNombre() + " ";
			}

			}
		else {
			elementosEliminados = "0 Elementos eliminados";
		}
		
		return nombre + " " + elementosAgregados + " " + elementosEliminados + "\n";
		
	}
		
		
}
