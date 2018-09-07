package views;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import bean.Cliente;
import bean.ItemVenta;
import bean.ListClientes;
import bean.ListProductosComp;
import bean.ListProductosSimple;
import bean.ListVentas;
import bean.ProductoComp;
import bean.ProductoSimple;
import bean.Venta;
import interfaz.*;

public class MenuInicialConsola {
	TDAManejoDatos manejoDatos;

	public MenuInicialConsola(TDAManejoDatos manejoDatos){
		this.manejoDatos = manejoDatos;
	}
	public void mostrarMenu() 
	{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		//Imprimo menu de opciones
		System.out.println("-------------------------------------------------------");
		System.out.println("MENU DE OPCIONES");
		System.out.println("-------------------------------------------------------");
		System.out.println("1.- Crear Cliente");
		System.out.println("2.- Crear Producto Simple");
		System.out.println("3.- Crear Producto Combo");
		System.out.println("4.- Crear Venta");
		System.out.println("5.- Listar Clientes");
		System.out.println("6.- Listar Productos");
		System.out.println("7.- Listar Ventas");
		System.out.println("8.- Obtener Items Venta");
		System.out.println("9.- Salir");
		System.out.println("-------------------------------------------------------");
		System.out.print("Opcion: ");
		try
		{
			char s = (char)reader.read();

			switch (s)
			{
			case '1' : 
			{
				this.crearCliente();
				break;
			}
			case '2' : 
			{
				this.crearProductoSimple();
				break;
			}
			case '3' : 
			{
				this.crearProductoComp();
				break;
			}
			case '4' : 
			{
				this.crearVenta();
				break;
			}
			case '5' : 
			{
				this.listarClientes();
				break;
			}
			case '6' : 
			{
				this.listarProductos();
				break;
			}

			case '7' : 
			{
				this.listarVentas();
				break;
			}
			case '8' : 
			{
				this.obtenerDetalleVenta();
				break;
			}
			case '9' : 
			{
				this.salir();
				break;
			}
			}
		}
		catch (Exception e)
		{
		}
	}


	public void crearCliente() 
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion
			System.out.println("---------------");
			System.out.println("CREAR CLIENTE");
			System.out.println("---------------");
			System.out.print("Ingrese nombre:");
			String nombre = reader.readLine();
			System.out.print("Ingrese dni:");
			String dni = reader.readLine();
			System.out.print("Ingrese domicilio:");
			String domicilio = reader.readLine();
			System.out.print("Ingrese telefono:");
			int telefono = Integer.parseInt(reader.readLine());

			manejoDatos.crearCliente(dni, domicilio, nombre, telefono);

			System.out.println();
			System.out.println();
			this.mostrarMenu();
		}
		catch(Exception e){}

	}


	public void crearProductoSimple() 
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion
			System.out.println("-----------------------");
			System.out.println("CREAR PRODUCTO SIMPLE");
			System.out.println("-----------------------");
			System.out.print("Ingrese codigo:");
			String codigo = reader.readLine();
			System.out.print("Ingrese nombre:");
			String nombre = reader.readLine();
			System.out.print("Ingrese precio:");
			float precio = Float.parseFloat(reader.readLine());
			System.out.print("Ingrese stock:");
			int stock = Integer.parseInt(reader.readLine());

			int cod = Integer.parseInt(codigo);

			manejoDatos.crearProductoSimple(cod, nombre, precio, stock);
			//this.productos.ordenarPorId();
		}
		catch(Exception e){}

		;
		System.out.println();
		System.out.println();
		this.mostrarMenu();

	}

	public void crearProductoComp() 
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion
			System.out.println("---------------------");
			System.out.println("CREAR PRODUCTO COMBO");
			System.out.println("---------------------");
			System.out.print("Ingrese codigo:");
			String codigo = reader.readLine();
			System.out.print("Ingrese nombre:");
			String nombre = reader.readLine();
			System.out.print("Ingrese precio:");
			float precio = Float.parseFloat(reader.readLine());
			System.out.print("Ingrese stock:");
			int stock = Integer.parseInt(reader.readLine());

			int cod = Integer.parseInt(codigo);

			manejoDatos.crearProductoComp(cod, nombre, precio, stock);
		}
		catch(Exception e){}


		System.out.println();
		System.out.println();
		this.mostrarMenu();


	}

	private void crearVenta(){
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion
			System.out.println("---------------");
			System.out.println("CREAR VENTA");
			System.out.println("---------------");
			System.out.print("Ingrese dni cliente:");
			String dni = reader.readLine();
			int nroVenta = manejoDatos.crearVenta(dni);

			String opcion = "Y";
			while (opcion.equalsIgnoreCase("Y")){
				System.out.println();
				System.out.println("Nuevo Item de Venta ");
				System.out.print("Ingrese código de Producto: ");
				int cod = Integer.parseInt(reader.readLine());
				System.out.print("Ingrese cantidad: ");
				int cant = Integer.parseInt(reader.readLine());
				
				manejoDatos.agregarItemVenta(nroVenta, cod, cant);

				System.out.print("Desea agregar un nuevo Item(Y/N)? ");
				opcion = reader.readLine();
			}


		}
		catch(Exception e){}


		System.out.println();
		System.out.println();
		this.mostrarMenu();

	}

	private void listarClientes() 
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion
			System.out.println("------------------");
			System.out.println("LISTAR CLIENTES");
			System.out.println("------------------");

			List<Cliente> listaCliente = manejoDatos.obtenerClientes();
			for(Cliente cli : listaCliente)
			{
				System.out.println("DNI: "+cli.getDni()+" - "+cli.getNombre());
			}
			System.out.println();
			System.out.println();
			mostrarMenu();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	private void listarProductos() 
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion
			System.out.println("------------------");
			System.out.println("LISTAR PRODUCTOS");
			System.out.println("------------------");

			ListProductosSimple listaProductosSimple = manejoDatos.getProductosSimple();
			for(ProductoSimple p : listaProductosSimple.getProductosSimple())
			{
				System.out.println("CodProd: "+p.getCodigo()+" - Nombre: "+p.getNombre()+" - Precio: "+p.getPrecio()+" - Stock: "+p.getCantStock());
			}
			ListProductosComp listaProductosComp = manejoDatos.getProductosComp();
			for(ProductoComp p : listaProductosComp.getProductosComp())
			{
				System.out.println("CodProd: "+p.getCodigo()+" - Nombre: "+p.getNombre()+" - Precio: "+p.getPrecio()+" - Stock: "+p.getCantStock());

				for (ProductoSimple ps : p.getProductosCompuestos()){
					System.out.println("	CodProd: "+ps.getCodigo()+" - Nombre: "+ps.getNombre()+" - Precio: "+ps.getPrecio()+" - Stock: "+ps.getCantStock());
				}
			}
			System.out.println();
			System.out.println();
			mostrarMenu();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	private void listarVentas() 
	{
		try
		{	
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion
			System.out.println("------------------");
			System.out.println("LISTAR VENTAS");
			System.out.println("------------------");

			List<Venta> listaVentas = manejoDatos.obtenerVentas();
			for(Venta v : listaVentas)
			{
				System.out.println("CodVenta: "+v.getCodigo()+" - Cliente: DNI "+v.getCliente()+ " - TotalVenta:"+v.getTotal());
			}
			System.out.println();
			System.out.println();
			mostrarMenu();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	private void obtenerDetalleVenta() 
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion
			System.out.println("------------------");
			System.out.println("LISTAR ITEMS VENTA");
			System.out.println("------------------");
			System.out.print("Ingrese codigo de venta: ");
			int cod = Integer.parseInt(reader.readLine());

			Venta venta = manejoDatos.obtenerVenta(cod);
			List<ItemVenta> listaItemVenta = venta.getItemsVenta();

			for(ItemVenta iv : listaItemVenta)
			{
				System.out.println("Numero: "+iv.getNumero()+" - Producto: "+iv.getProducto().getNombre()+ " - Precio: "+iv.getProducto().getPrecio()+ " - Cantidad:"+iv.getCantidad());

			}
			System.out.println();
			System.out.println();
			mostrarMenu();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	public void salir() throws RemoteException 
	{	System.out.println("- BYE BYE -");
	manejoDatos.actualizarBD();
	System.exit(0);
	}


	public void cargarTablas(TDAManejoDatos manejoDatos){
		this.manejoDatos = manejoDatos;
		
		//TODO Auto-generated method stub
		ListProductosSimple listaProductosSimple = new ListProductosSimple();
		ListProductosComp listaProductosComp = new ListProductosComp();
		ListClientes listaClientes = new ListClientes();
		ListVentas   listaVentas   = new ListVentas();

		// Se crean Productos
		// Productos Simples
		ProductoSimple pera    = new ProductoSimple(1, "pera", 2, 50);
		ProductoSimple manzana = new ProductoSimple(2, "manzana", 3, 50);
		ProductoSimple banana  = new ProductoSimple(3, "banana", 4, 50);

		listaProductosSimple.addProducto(pera);
		listaProductosSimple.addProducto(manzana);
		listaProductosSimple.addProducto(banana);

		// Productos Compuestos
		ProductoComp combo1  = new ProductoComp();
		ProductoComp combo2  = new ProductoComp();
		int cod = 0;
		try{
			int index = listaProductosSimple.getProductosSimple().size() - 1;
			int ultimoCodigo = listaProductosSimple.getProductosSimple().get(index).getCodigo();
			cod = ultimoCodigo + 1;
		}catch (Exception e){}

		combo1.setNombre("Combo1");
		combo1.setCodigo(cod);
		combo1.setCantStock(25);
		combo1.setPrecioCombo(10);
		combo1.setDescuento(1);
		combo1.agregarProductosSimple(pera);
		combo1.agregarProductosSimple(manzana); 

		cod++;
		combo2.setNombre("Combo2");
		combo2.setCodigo(cod);
		combo2.setCantStock(25);
		combo2.setPrecioCombo(15);
		combo2.setDescuento(2);
		combo2.agregarProductosSimple(pera);
		combo2.agregarProductosSimple(manzana);
		combo2.agregarProductosSimple(banana);

		//CreoProductos
		listaProductosComp.addProducto(combo1);
		listaProductosComp.addProducto(combo2);

		// Se crean Clientes
		Cliente cliente1 = new Cliente();
		cliente1.setDatos("11", "casa1", "Juan Casas", 12322144);
		Cliente cliente2 = new Cliente();
		cliente2.setDatos("22", "casa2", "Ale Perez", 12221112);
		Cliente cliente3 = new Cliente();
		cliente3.setDatos("33", "casa3", "Carlos Sanchez", 14444444);

		listaClientes.addCliente(cliente1);
		listaClientes.addCliente(cliente2);
		listaClientes.addCliente(cliente3);

		// Creo una venta
		ItemVenta item1 = new ItemVenta(pera, 2);
		ItemVenta item2 = new ItemVenta(manzana, 5);
		ItemVenta item3 = new ItemVenta(banana, 5);
		ItemVenta item4 = new ItemVenta(combo1, 2);

		List<ItemVenta>lista = new ArrayList<ItemVenta>();
		lista.add(item1);
		lista.add(item2);
		lista.add(item3);
		lista.add(item4);
		Venta venta1 = new Venta();
		venta1.setCliente(cliente1);
		venta1.setItemsVenta(lista);
		venta1.actualizarStockProductos();
		listaVentas.addVenta(venta1);

		Venta venta2 = new Venta();
		venta2.setCliente(cliente3);
		List<ItemVenta>lista2 = new ArrayList<ItemVenta>();
		lista2.add(item3);
		lista2.add(item4);
		venta2.setItemsVenta(lista2);
		venta2.actualizarStockProductos();
		listaVentas.addVenta(venta2);
	}


}
