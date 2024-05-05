import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import fundamentos.Lectura;

import fundamentos.Mensaje;

/**
 * Clase que representa una tienda con un conjunto de vendedores. Gestiona las
 * ventas realizadas y las comisiones asignadas a cada vendedor. Los datos de la
 * tienda se almacenan en un fichero de texto que se pasa como parametro al
 * crear la tienda
 */
public class Tienda {

	private static final String DNI = " DNI: ";
	private static final String ID = " Id: ";
	private static final String NOMBRE = "  Nombre: ";
	private static final double COMISIONSENIOR = 0.01;
	private static final double COMISIONJUNIOR = 0.005;
	private List<Vendedor> lista = new LinkedList<Vendedor>();
	private String direccion;
	private String nombreTienda;
	private String datos;

	private static final String ERROR = "ERROR";
	
	/**
	 * Crea la tienda cargando los datos desde el fichero indicado
	 * @param datos Path absoluto del fichero de datos
	 */
	public Tienda(String datos) {	//WMC 1	//CCOG 0
		this.datos = datos;
	}

	/**
	 * Retorna la direccion de la tienda
	 * @return Direccion de la tienda
	 */
	public String direccion() {	//WMC 1	//CCOG 0
		return direccion;
	}

	/**
	 * Retorna el nombre de la tienda
	 * @return Nombre de la tienda
	 */
	public String nombre() {	//WMC 1	//CCOG 0
		return nombreTienda;
	}

	/**
	 * Anhade un nuevo vendedor a la tienda
	 * @param nuevo El vendedor a anhadir
	 * @return true si el vendedor se ha anhadido 
	 *         false si ya existe el vendedor
	 */
	public boolean anhade(Vendedor nuevo) throws DataAccessException {	//WMC 2	//CCOG 1
		Vendedor v = buscaVendedor(nuevo.getId());
		if (v != null) {	//+1	//+1
			return false;
		}
		lista.add(nuevo);
		vuelcaDatos();
		return true;
	}

	/**
	 * Elimina el vendedor cuyo id se pasa como argumento
	 * @param id
	 * @return true si se elimina el vendedor false si no existe el vendedor
	 */
	public boolean eliminaVendedor(String id) throws DataAccessException {	//WMC 2	//CCOG 1
		Vendedor v = buscaVendedor(id);
		if (v == null) {	//+1	//+1
			return false;
		}
		lista.remove(v);
		vuelcaDatos();
		return true;
	}

	/**
	 * Anhade una venta a un vendedor
	 * @param id      Id del vendedor
	 * @param importe Importe de la venta
	 * @return true si se anhade la venta false si no se encuentra el vendedor
	 */
	public boolean anhadeVenta(String id, double importe) throws DataAccessException {
	    Vendedor v = buscaVendedor(id);

	    if (v == null) {
	        return false;
	    }

	    double comision = 0;

	    if (v instanceof VendedorEnPlantilla) {
	        VendedorEnPlantilla vep = (VendedorEnPlantilla) v;
	        if (vep.tipo() == TipoVendedor.JUNIOR) {
	            comision = importe * COMISIONJUNIOR;
	        } else if (vep.tipo() == TipoVendedor.SENIOR) {
	            comision = importe * COMISIONSENIOR;
	        }
	        vep.anhade(importe);
	        double currentComision = vep.getComision();
	        vep.setComision(currentComision + comision);
	       
	        vuelcaDatos();
	        return true;
	    }
	    return false;
	}


	/**
	 * Retorna el vendedor con el id indicado
	 * 
	 * @param id Id del vendedor
	 * @return vendedor con ese dni o null si no existe ninguno
	 */
	public Vendedor buscaVendedor(String id) throws DataAccessException {	//WMC 5	//CCOG 5

		lista = new LinkedList<Vendedor>();
		Scanner in = null;
		try {
			// abre el fichero
			in = new Scanner(new FileReader(datos));
			// configura el formato de numeros
			in.useLocale(Locale.ENGLISH);
			nombreTienda = in.nextLine();
			direccion = in.nextLine();
			in.next();
			leerVendedores(in);
		} catch (FileNotFoundException e) {	//+1	//+1
			throw new DataAccessException();	
		} finally {
			if (in != null) {	//+1	//+1
				in.close();
			}
		} // try

		for (Vendedor v : lista) {	//+1	//+1
			if (v.getId().equals(id)) {	//+1	//+2
				return v;
			}
		}
		return null;
	}

	/**
	 * Retorna la lista de vendedores actuales de la tienda
	 * 
	 * @return La lista de vendedores
	 */
	public List<Vendedor> vendedores() throws DataAccessException {	//WMC 3	//CCOG 2
		lista = new LinkedList<Vendedor>();

		Scanner in = null;
		try {
			// abre el fichero
			in = new Scanner(new FileReader(datos));
			// configura el formato de numeros
			in.useLocale(Locale.ENGLISH);
			nombreTienda = in.nextLine();
			direccion = in.nextLine();
			in.next();
			leerVendedores(in);
		} catch (FileNotFoundException e) {	//+1	//+1
			throw new DataAccessException();
		} finally {
			if (in != null) {	//+1	//+1
				in.close();
			}
		} // try

		return lista;

	}

	private void leerVendedores(Scanner in) {	//WMC 6	//CCOG 5
		Vendedor ven;
		while (in.hasNext() && !in.next().equals("Junior")) {	//+2	//+2
			String nombre = in.next();
			in.next();
			String idIn = in.next();
			in.next();
			String dni = in.next();
			in.next();
			double totalVentas = in.nextDouble();
			in.next();
			double totalComision = in.nextDouble();
			ven = new VendedorEnPlantilla(nombre, idIn, dni, TipoVendedor.SENIOR);
			ven.setTotalVentas(totalVentas);
			ven.setComision(totalComision);
			lista.add(ven);
		}
		// lee los vendedores junior
		while (in.hasNext() && !in.next().equals("Practicas")) {	//+2	//+2
			String nombre = in.next();
			in.next();
			String idIn = in.next();
			in.next();
			String dni = in.next();
			in.next();
			double totalVentas = in.nextDouble();
			in.next();
			double totalComision = in.nextDouble();
			ven = new VendedorEnPlantilla(nombre, idIn, dni, TipoVendedor.JUNIOR);
			ven.setTotalVentas(totalVentas);
			ven.setComision(totalComision);
			lista.add(ven);
		}
		while (in.hasNext()) {	//+1	//+1
			in.next();
			String nombre = in.next();
			in.next();
			String idIn = in.next();
			in.next();
			String dni = in.next();
			in.next();
			double totalVentas = in.nextDouble();
			ven = new VendedorEnPracticas(nombre, idIn, dni);
			ven.setTotalVentas(totalVentas);
			lista.add(ven);
		}
	}

	/**
	 * Actualiza el fichero datosTienda.txt con los datos actualizados de
	 * los vendedores
	 */
	private void vuelcaDatos() throws DataAccessException {	//WMC 10	//CCOG	13
		PrintWriter out = null;
		List<Vendedor> senior = new LinkedList<Vendedor>();
		List<Vendedor> junior = new LinkedList<Vendedor>();
		List<Vendedor> practicas = new LinkedList<Vendedor>();

		for (Vendedor v : lista) {	//+1	//+1
			if (v instanceof VendedorEnPracticas) {	//+1	//+2
				practicas.add(v);
			} else if (v instanceof VendedorEnPlantilla) {	//+1	//+1
				VendedorEnPlantilla vp = (VendedorEnPlantilla) v;
				if (vp.tipo().equals(TipoVendedor.JUNIOR))	//+1	//+3
					junior.add(vp);
				else	//+1
					senior.add(vp);
			}
		}

		try {

			out = new PrintWriter(new FileWriter(datos));

			out.println(nombreTienda);
			out.println(direccion);
			out.println();
			out.println("Senior");
			for (Vendedor v : senior) {	//+1	//+1
				VendedorEnPlantilla v1 = (VendedorEnPlantilla) v;
				out.println(NOMBRE + v1.getNombre() + ID + v1.getId() + DNI + v1.getDni()
						+ " TotalVentasMes: " + v1.getTotalVentas() + " TotalComision: "+ v1.getComision());
			}
			out.println();
			out.println("Junior");
			for (Vendedor v : junior) {	//+1	//+1
				VendedorEnPlantilla v2 = (VendedorEnPlantilla) v;
				out.println(NOMBRE + v2.getNombre() + ID + v2.getId() + DNI + v2.getDni()
						+ " TotalVentasMes: " + v2.getTotalVentas() + " TotalComision: "+ v2.getComision());
			}
			out.println();
			out.println("Practicas");
			for (Vendedor v : practicas) {	//+1	//+1
				VendedorEnPracticas v3 = (VendedorEnPracticas) v;
				out.println(NOMBRE + v3.getNombre() + ID + v3.getId() + DNI + v3.getDni()
						+ " TotalVentasMes: " + v3.getTotalVentas());
			}
		} catch (IOException e) {	//+1	//+1
			throw new DataAccessException();

		} finally {
			if (out != null)	//+1		//+1
				out.close();
		}
	}
	
	public void vendedoresPorVentas() throws DataAccessException {
		List<Vendedor> vendedores;
		String msj;
		vendedores = vendedores();
		System.out.println(vendedores.size());
		Collections.sort(vendedores, new Comparator<Vendedor>() {
			public int compare(Vendedor o1, Vendedor o2) {
				if (o1.getTotalVentas() > o2.getTotalVentas())	//+1	//+2
					return -1;
				else if (o1.getTotalVentas() < o2.getTotalVentas())	//+1	//+1
					return 1;
				return 0;
			}
		});
		msj = "";
		for (Vendedor vn : vendedores) {	//+1	//+2
			msj += vn.getNombre() + " (" + vn.getId()+ ") "+vn.getTotalVentas() + "\n";
		}
		mensaje("VENDEDORES", msj);
	}

	public void vendedorDelMes() throws DataAccessException {
		List<Vendedor> vendedores;
		List<Vendedor> resultado;
		String msj;
		vendedores = vendedores();
		resultado = new LinkedList<Vendedor>();
		double maxVentas = 0.0;
		for (Vendedor v : vendedores) {	//+1	//+3
			if (v.getTotalVentas() > maxVentas) { //+1	//+4
				maxVentas = v.getTotalVentas();
				resultado.clear();
				resultado.add(v);
			} else if (v.getTotalVentas() == maxVentas) {	//+1 //+1
				resultado.add(v);
			}
		}

		msj = "";
		for (Vendedor vn : resultado) {	//+1 	//+3
			msj += vn.getNombre() + "\n";
		}
		mensaje("VENDEDORES DEL MES", msj);
	}

	public void nuevaVenta() {
		String dni;
		Lectura lect;
		lect = new Lectura("Datos Venta");
		lect.creaEntrada("ID Vendedor", "");
		lect.creaEntrada("Importe", "");
		lect.esperaYCierra();
		dni = lect.leeString("ID Vendedor");
		double importe = lect.leeDouble("Importe");
		try {
			if (!anhadeVenta(dni, importe)) {	//+1 //+3
				mensaje(ERROR, "El vendedor no existe");
			}
		} catch (DataAccessException e) {	//+1	//+3
			mensaje(ERROR, "No se pudo guardar el cambio");
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
