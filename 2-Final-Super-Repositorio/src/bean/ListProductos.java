package bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import bean.srv.ProductoSRV;


public class ListProductos
{
	private List<Producto> productos;

	public ListProductos()
	{
		productos= new ArrayList<Producto>();
		productos = ProductoSRV.leerProductos();
	}

	public List<Producto> getProductos() {
		return productos;
	}
	public List<Producto> ordenarPorId() {
		Collections.sort(productos, new SortbyCod());
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public void addProducto(Producto producto){
		productos.add(producto);
		ProductoSRV.grabarProducto(producto);
	}

	public boolean removeProducto(Producto producto) {
		return productos.remove(producto);
	}

	public Producto getProductoPorId(int id){
		for(Producto p : productos){
			if(id == p.getCodigo())
				return p;
		}
		return null;
	}


	public int size(){
		return productos.size();
	}

	public void actualizarBD() 
	{
		ProductoSRV.grabarProductos(productos);

	}
}
class SortbyCod implements Comparator<Producto>
{
	// Used for sorting in ascending order of
	// roll number
	public int compare(Producto a, Producto b)
	{
		return a.getCodigo() - b.getCodigo();
	}
}