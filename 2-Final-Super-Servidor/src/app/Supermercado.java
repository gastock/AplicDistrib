package app;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import bean.*;

public class Supermercado{
	private Supermercado instancia;

	private ListClientes   clientes;
	private ListProductos  productos;
	private ListProductosSimple productosSimples;
	private ListProductosComp productosComp; 
	private ListVentas     ventas;

	public Supermercado(){

		this.clientes   = new ListClientes();
		this.productos  = new ListProductos();
		this.productosSimples = new ListProductosSimple();
		this.productosComp = new ListProductosComp();
		this.ventas     = new ListVentas();
	}
	Supermercado(ListClientes c, ListProductosSimple p, ListProductosComp pc,  ListVentas v ){
		this.clientes = c;
		this.productosSimples = p;
		this.productosComp = pc;
		this.ventas = v;
	}


	public Supermercado getInstance(){
		if (this.instancia == null){
			this.instancia  = new Supermercado();}

		return this.instancia;
	}

	public ListVentas getVentas() {
		return ventas;
	}
	public void setVentas(ListVentas ventas) {
		this.ventas = ventas;
	}
	public ListProductosSimple getProductosSimple() {
		return productosSimples;
	}
	public ListProductosComp getProductosComp() {
		return productosComp;
	}
	
	public ListProductos getProductos() {
		return productos;
	}
	public void setProductos(ListProductos productos) {
		this.productos = productos;
	}
	public ListProductosSimple getProductosSimples() {
		return productosSimples;
	}
	public void setProductosSimples(ListProductosSimple productos) {
		this.productosSimples = productos;
	}
	public void setProductosComp(ListProductosComp productos) {
		this.productosComp = productos;
	}

	public void crearCliente(String nombre, String dni,int telefono, String domicilio){
		Cliente c = buscarCliente(dni);
		if (c==null)
		{
			c = new Cliente();
			c.setDatos(dni, domicilio, nombre, telefono);
			clientes.addCliente(c);
		}
	}
	public void crearProductoSimple(int cod, String nombre, float precio, int stock){
		ProductoSimple p = buscarProductoSimple(nombre);
		if (p == null){
			p = new ProductoSimple();
			p.setDatos(cod, nombre, precio, stock);
			productosSimples.addProducto(p);
		}
	}
	public void crearProductoComp(int cod, String nombre, float precio, int stock){
		ProductoComp p = this.buscarProductoComp(nombre);
		if (p == null){
			p = new ProductoComp();
			p.setDatos(cod, nombre, precio, stock);
			productosComp.addProducto(p);
		}
	}
	public int crearVenta(String dni)
	{
		Cliente cli = buscarCliente(dni);
		if (cli!=null)
		{
			Venta v = new Venta();
			int codigo = 0;
			try{
				int ultimaPos = this.getVentas().size() - 1;
				codigo = this.getVentas().getVentaPorPos(ultimaPos).getCodigo();
			}catch(Exception e){
	
			}
	
			v.setCodigo(++codigo);
			v.setCliente(cli);
			
			ventas.addVenta(v);
			return v.getCodigo();
		}
		return 0;
	}
	Cliente buscarCliente(String dni)
	{
		return clientes.getClientePorId(dni);
	}
	
	Venta buscarVenta(int codVenta){
		return ventas.getVentaPorId(codVenta);
	}
	
	private ProductoSimple buscarProductoSimple(int cod)
	{
		return productosSimples.getProductoPorId(cod);
	}
	private ProductoSimple buscarProductoSimple(String nombre)
	{
		return productosSimples.getProductoPorNombre(nombre);
	}
	private ProductoComp buscarProductoComp(int  cod)
	{
		return productosComp.getProductoPorId(cod);
	}
	private ProductoComp buscarProductoComp(String nombre)
	{
		return productosComp.getProductoPorNombre(nombre);
	}
	Producto buscarProducto (int  codigo ){
		if (productosSimples.getProductoPorId(codigo) != null){
			return productosSimples.getProductoPorId(codigo);
		}else if (productosComp.getProductoPorId(codigo) !=null ){
			return productosComp.getProductoPorId(codigo);
		}
		return null;
	}

	public void modificarCliente (String nombre, String dni, int telefono,
			String domicilio)
	{
		Cliente c = buscarCliente(dni);
		if (c!=null)
		{
			c.setNombre(nombre);
			c.setTelefono(telefono);
			c.setDomicilio(domicilio);
		}
	}

	public void eliminarCliente(String dni)
	{
		Cliente c = buscarCliente(dni);
		clientes.removeCliente(c);
	}

	public ListClientes getClientes() {
		return clientes;
	}
	public void setClientes(ListClientes clientes) {
		this.clientes = clientes;
	}

	public void actualizarBD()
	{
		clientes.actualizarBD();
		productos.actualizarBD();
		//ventas.actualizarBD();
	}
	public void agregarItem(int nroVenta, int cod, int cant) 
	{
		Venta v = ventas.getVentaPorId(nroVenta);
		Producto p = buscarProducto(cod);
		if (v!=null && p!=null)
		{
			v.agregarItemVenta(p,cant);
		}
		
	}

	
}
;