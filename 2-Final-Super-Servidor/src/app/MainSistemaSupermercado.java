package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.GarbageCollectorMXBean;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import bean.*;
import bean.srv.VentaSRV;
import interfaz.TDAManejoDatos;

public class MainSistemaSupermercado extends UnicastRemoteObject implements TDAManejoDatos
{	
	static TDAManejoDatos manejoDatos;

	private Supermercado supermercado; 

	public MainSistemaSupermercado() throws RemoteException{
		
		supermercado = new Supermercado();
	}




	@Override
	public Cliente getCliente() throws RemoteException {
		
		return null;
	}

	@Override
	public void setCliente(Cliente cliente) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float calcularTotal() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void actualizarStockProductos() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCodigo() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCodigo(int codigo) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ItemVenta> getItemsVenta(int codVenta) throws RemoteException {
		// TODO Auto-generated method stub
//		return this.supermercado.getVenta(v).getItemsVenta();
		return this.supermercado.buscarVenta(codVenta).getItemsVenta(); 
	}

	@Override
	public void setItemsVenta(List<ItemVenta> itemsVenta) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getTotal() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTotal(float total) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public VentaView getView() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venta obtenerVenta(int i) throws RemoteException {
		// TODO Auto-generated method stub
		return supermercado.getVentas().getVentaPorId(i);
	}

	@Override
	public List<Cliente> obtenerClientes() throws RemoteException {
		// TODO Auto-generated method stub
		return supermercado.getClientes().getClientes();
	}
	
	@Override
	public List<Producto> obtenerProductos() throws RemoteException {
		// TODO Auto-generated method stub
//		List<Producto> listadoProductos = new ArrayList<Producto>(); 
//		List<ProductoSimple> listadoProductosSimple = supermercado.getProductosSimple().getProductosSimple();
//		List<ProductoComp>   listadoProductosComp   = supermercado.getProductosComp().getProductosComp();
//		listadoProductos.addAll(listadoProductosSimple);
//		listadoProductos.addAll(listadoProductosComp);
//		return listadoProductos;
		return supermercado.getProductos().getProductos();
	}
	
	@Override
	public List<Venta> obtenerVentas() throws RemoteException {
		// TODO Auto-generated method stub
		return this.supermercado.getVentas().getVentas();
	}

	@Override
	public int cantidadClientes() throws RemoteException {
		// TODO Auto-generated method stub
		return supermercado.getClientes().getClientes().size() + 1;
	}

	@Override
	public int cantidadProductos() throws RemoteException {
		// TODO Auto-generated method stub
		return supermercado.getProductosSimple().getProductosSimple().size() + 1 
				+ supermercado.getProductosComp().getProductosComp().size() + 1;
	}

	@Override
	public int cantidadVentas() throws RemoteException {
		// TODO Auto-generated method stub
		return supermercado.getVentas().getVentas().size() + 1;
	}

	@Override
	public void crearCliente(String dni, String domicilio, String nombre, int telefono) throws RemoteException {
		// TODO Auto-generated method stub
		supermercado.crearCliente(nombre, dni, telefono, domicilio);
	}

	@Override
	public void crearProductoSimple(int cod, String nombre, float precio, int stock) {
		// TODO Auto-generated method stub
		supermercado.crearProductoSimple(cod, nombre, precio, stock);
	}

	@Override
	public void crearProductoComp(int cod, String nombre, float precio, int stock) {
		// TODO Auto-generated method stub
		supermercado.crearProductoSimple(cod, nombre, precio, stock);
	}

	@Override
	public void agregarProductoAProdComp(int codProd, int codProdAgregado) throws RemoteException {
		// TODO Auto-generated method stub
		ProductoComp prodComp = new ProductoComp();
		prodComp = (ProductoComp) this.supermercado.getProductos().getProductoPorId(codProd);
		ProductoSimple prodSimple = this.supermercado.getProductosSimples().getProductoPorId(codProdAgregado);
		prodComp.agregarProductosSimple(prodSimple);
	}

	@Override
	public void agregarItemVenta(int codVenta, int codProd, int cant) throws RemoteException {
		// TODO Auto-generated method stub
//		Venta v  = this.supermercado.getVentas().getVentaPorId(codVenta);
//		this.supermercado.getVentas().removeVenta(v);
//		v.agregarItemVenta(supermercado.getProductos().getProductoPorId(codProd), cant);
//		this.supermercado.getVentas().addVenta(v);
		
		 ItemVenta iv = new ItemVenta(this.supermercado.getProductos().getProductoPorId(codProd), cant);
		 List<ItemVenta> listaItemsVenta = new ArrayList<ItemVenta>();
		 listaItemsVenta = this.supermercado.getVentas().getVentaPorId(codVenta).getItemsVenta();
		 listaItemsVenta.add(iv);
		this.supermercado.getVentas().getVentaPorId(codVenta).setItemsVenta(listaItemsVenta);
		
		Venta v = this.supermercado.getVentas().getVentaPorId(codVenta);
		v.setItemsVenta(listaItemsVenta);
		VentaSRV.grabarVenta(v);
	}

	@Override
	public int crearVenta(String dni) throws RemoteException {
		// TODO Auto-generated method stub
		int codVenta = this.supermercado.crearVenta(dni);
		return codVenta;
	}


	@Override
	public void cargarTablas() throws RemoteException {
		// TODO Auto-generated method stub
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


	@Override
	public ListProductosSimple getProductosSimple() throws RemoteException {
		// TODO Auto-generated method stub
		return this.supermercado.getProductosSimples();
	}


	@Override
	public ListProductosComp getProductosComp() throws RemoteException {
		// TODO Auto-generated method stub
		return this.supermercado.getProductosComp();
	}


	@Override
	public void actualizarBD() throws RemoteException {
		// TODO Auto-generated method stub
		this.supermercado.actualizarBD();
	}




	@Override
	public List<Cliente> getClientes() {
		// TODO Auto-generated method stub
		return this.supermercado.getClientes().getClientes();
	}




	@Override
	public List<Venta> getVentas() throws RemoteException {
		// TODO Auto-generated method stub
		return this.supermercado.getVentas().getVentas();
	}



}




