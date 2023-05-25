package hamburguesas.modelo;

import java.util.HashMap;
import java.util.Map;

public class ProductoRepetidoException extends HamburguesaException{

	@Override
	void detectarErrorP(HashMap<String, ProductoMenu> mapaProductos, String nombre) throws Exception {
		// TODO Auto-generated method stub
		
		if(mapaProductos.containsKey(nombre)){
			throw new Exception("Hay un producto repetido en el menú. " + "El producto repetido es: " + nombre);
		}
	
		
	}

}
