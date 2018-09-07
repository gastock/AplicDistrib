package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import bean.Cliente;
import bean.ItemVenta;
import bean.ListProductos;
import bean.ListProductosComp;
import bean.ListProductosSimple;
import bean.ListVentas;
import bean.Producto;
import bean.Venta;
import bean.VentaView;


public interface TDAManejoDatos extends Remote 
{


//  obtener cliente de venta	
	public Cliente getCliente() throws RemoteException;
	
//  setear Cliente de venta
	public void setCliente(Cliente cliente) throws RemoteException;

//	calcula el total de la venta
	public float calcularTotal()  throws RemoteException;

//	actualiza stock en productos
	public void actualizarStockProductos() throws RemoteException;

//  obtener codigo de venta	
	public int getCodigo()  throws RemoteException;

//  seetear codigo de venta	
	public void setCodigo(int codigo)  throws RemoteException;

//	obtener listado de items de venta
	public List<ItemVenta> getItemsVenta(int codVenta)  throws RemoteException;
	
//  setear listado de items de venta
	public void setItemsVenta(List<ItemVenta> itemsVenta) throws RemoteException;
	
//	obtiene el total de la venta
	public float getTotal()  throws RemoteException;
	
//	setea el total de la venta
	public void setTotal(float total)  throws RemoteException;

	public VentaView getView() throws RemoteException;

	public Venta obtenerVenta(int i) throws RemoteException;

	public  List<Venta> obtenerVentas()throws RemoteException;
	
	public  List<Producto> obtenerProductos()throws RemoteException;

	public int cantidadClientes() throws RemoteException;
	
	public int cantidadVentas()throws RemoteException;
	
	public int cantidadProductos()throws RemoteException;

	public List<Cliente> obtenerClientes() throws RemoteException;

	public void crearCliente(String dni, String domicilio, String nombre, int telefono) throws RemoteException;

	public void crearProductoSimple(int cod, String nombre, float precio, int stock)throws RemoteException;

//  Se crea producto Compuesto
	void crearProductoComp(int cod, String nombre, float precio, int stock)throws RemoteException;
	
//	Se agrega producto a Producto Compuesto
	void agregarProductoAProdComp(int codProd, int codProdAgregado) throws RemoteException;
	
//  Se crea venta y se devuelve el còdigo asociado
	int crearVenta(String dni) throws RemoteException;
	
//  Se agrega item a venta
	void agregarItemVenta(int codVenta, int codProd, int cant) throws RemoteException;
	
//	Se cargan tablas de BD
	void cargarTablas() throws RemoteException;

//	Se obtienen los productos Simples
	public ListProductosSimple getProductosSimple()throws RemoteException;
	
//	Se obtienen los productos Combo
	public ListProductosComp getProductosComp()throws RemoteException;
	
//  Se actualiza BD
	public void actualizarBD()throws RemoteException;

//	Se obtienen los clientes
	public List<Cliente>  getClientes()throws RemoteException;

//	Se obtienen las ventas
	public List<Venta> getVentas()throws RemoteException;

////  Se obtiene lista de Ventas	
//	public ListVentas obtenerListVentas();
}
