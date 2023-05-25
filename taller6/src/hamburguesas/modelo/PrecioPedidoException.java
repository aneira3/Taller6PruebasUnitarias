package hamburguesas.modelo;

public class PrecioPedidoException extends HamburguesaException {
	
	
	
	
	void detectarErrorC(int precio) throws Exception {
		if (precio > 150000) {
			throw new Exception("El precio del pedido excede los 150000 pesos.");
			
		}
	}
	

}
