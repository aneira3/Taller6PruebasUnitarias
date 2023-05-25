package hamburguesas.modelo;

import java.util.HashMap;

public class IngredienteRepetidoException extends HamburguesaException{

	@Override
	void detectarErrorI(HashMap<String, ingrediente> mapaProductos, String nombre) throws Exception {
		// TODO Auto-generated method stub
		if(mapaProductos.containsKey(nombre)){
			throw new Exception("Hay un ingrediente repetido en los datos. " + "El ingrediente repetido es: " + nombre );
		}
	
		
	}

	
}
