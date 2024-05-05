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
	public static void main(String[] args) { //WMC 16  //CCOG 33
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

<<<<<<< HEAD
				} catch (DataAccessException e) {	//+1	//+3
					mensaje("ERROR", "No se pudo acceder a los datos");
=======
				} catch (DataAccessException e) {	//+1	//+2
					mensaje(ERROR, "No se pudo acceder a los datos");
>>>>>>> practica5
				}
				break;

			case VENDEDORES:
				try {
<<<<<<< HEAD
					vendedores = tienda.vendedores();
					System.out.println(vendedores.size());
					Collections.sort(vendedores, new Comparator<Vendedor>() {
						public int compare(Vendedor o1, Vendedor o2) {
							if (o1.getTotalVentas() > o2.getTotalVentas())	//+1	//+3
								return -1;
							else if (o1.getTotalVentas() < o2.getTotalVentas())	//+1	//+1
								return 1;
							return 0;
						}
					});
					msj = "";
					for (Vendedor vn : vendedores) {	//+1	//+3
						msj += vn.getNombre() + " (" + vn.getId()+ ") "+vn.getTotalVentas() + "\n";
					}
					mensaje("VENDEDORES", msj);
				} catch (DataAccessException e) {	//+1	//+3
					mensaje("ERROR", "No se pudo acceder a los datos");
=======
					tienda.vendedoresPorVentas();
				} catch (DataAccessException e) {	//+1	//+2
					mensaje(ERROR, "No se pudo acceder a los datos");
>>>>>>> practica5
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
