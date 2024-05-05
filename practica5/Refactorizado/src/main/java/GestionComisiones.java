import fundamentos.Menu;

import fundamentos.Mensaje;

/**
 * Gestion de las comisiones de vendedores de una tienda
 */
public class GestionComisiones {

	private static final String ERROR = "ERROR";

	/**
	 * Programa principal basado en menu
	 */
	public static void main(String[] args) { //WMC 16  //CCOG 29
		// opciones del menu
		final int NUEVA_VENTA = 0, VENDEDOR_DEL_MES = 1, VENDEDORES = 2;

		// crea la tienda
		Tienda tienda = new Tienda("C:\\Users\\hecto\\Escritorio\\Clase\\3º\\SW2\\IS2_2324\\practica5\\Refactorizado\\datosTienda.txt");

		// crea la ventana de menu
		Menu menu = new Menu("Comisiones tienda");
		menu.insertaOpcion("Anhadir venta", NUEVA_VENTA);
		menu.insertaOpcion("Vendedor del mes", VENDEDOR_DEL_MES);
		menu.insertaOpcion("Vendedores por ventas", VENDEDORES);
		int opcion;

		// lazo de espera de comandos del usuario
		while (true) {	//+1	//+1
			opcion = menu.leeOpcion();

			// realiza las acciones dependiendo de la opcion elegida
			switch (opcion) {	//+3	//+2
			case NUEVA_VENTA:
				tienda.nuevaVenta();
				break;

			case VENDEDOR_DEL_MES:
				try {
					tienda.vendedorDelMes();

				} catch (DataAccessException e) {	//+1	//+2
					mensaje(ERROR, "No se pudo acceder a los datos");
				}
				break;

			case VENDEDORES:
				try {
					tienda.vendedoresPorVentas();
				} catch (DataAccessException e) {	//+1	//+2
					mensaje(ERROR, "No se pudo acceder a los datos");
				}
				break;
			default:
				break;
			}
		}
	}



	/**
	 * Metodo auxiliar que muestra un ventana de mensaje
	 * @param titulo Titulo de la ventana
	 * @param txt    Texto contenido en la ventana
	 */
	private static void mensaje(String titulo, String txt) {	//WMC 1	//CCOG 0
		Mensaje msj = new Mensaje(titulo);
		msj.escribe(txt);

	}

}
