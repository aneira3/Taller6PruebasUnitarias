package hamburguesas.modelo;

import java.util.HashMap;
import java.util.Map;

abstract class HamburguesaException {
	
	void detectarErrorP(HashMap<String, ProductoMenu> mapa, String nombre) throws Exception{
		
	}

	void detectarErrorI(HashMap<String, ingrediente> mapaProductos, String nombre) throws Exception{
		
	}
	
	void detectarErrorC(int precio) throws Exception {
		
	}

	

	

}
