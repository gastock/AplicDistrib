package cliente;

import interfaz.TDAManejoDatos;
import views.MenuInicialConsola;
import views.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import bean.Cliente;
import bean.ItemVenta;
import bean.ListVentas;
import bean.Producto;
import bean.Venta;


public class Admin_Cliente {

	private static TDAManejoDatos manejoDatos;

	public static void main(String[] args) throws RemoteException {
		new Admin_Cliente();

	}

	public boolean getStub() {

		try {
			manejoDatos = (TDAManejoDatos) Naming.lookup("//localhost/GestionDatos");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Admin_Cliente() throws RemoteException {
		if (getStub()) {

			MenuInicialConsola menu = new MenuInicialConsola(manejoDatos);

			List<Venta> listadoVentas = new ArrayList<Venta>();
			List<ItemVenta> listadoItemVenta = new ArrayList<ItemVenta>();
			List<Producto> listadoProductos = new ArrayList<Producto>();
			List<bean.Cliente> listadoClientes = new ArrayList<bean.Cliente>();


			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("-----------------------------------------");
			System.out.println("        - Bienvenido a Super - ");
			System.out.println("-----------------------------------------");
			System.out.println();
			System.out.print("Desea Cargar Tablas(Y/N)?  ");
			String opcion;
			try {
				opcion = reader.readLine();

				if (opcion.equalsIgnoreCase("Y")){	
					menu.cargarTablas(manejoDatos);
					System.out.println("-----------------------------------------");
					System.out.println("        - Tablas Cargadas - ");
					System.out.println("-----------------------------------------");					
					menu.salir();
				}

				listadoVentas = manejoDatos.obtenerVentas();
				listadoProductos = manejoDatos.obtenerProductos();
				listadoClientes = manejoDatos.obtenerClientes();

//				menu.mostrarMenu();
				MenuInicialPantallas ventana = new MenuInicialPantallas(manejoDatos);
				ventana.setVisible(true);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}


	}


	public static TDAManejoDatos getInstancia() {
		return manejoDatos;
	}

}
