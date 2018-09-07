package bean;

import java.util.ArrayList;
import java.util.List;

import bean.srv.ProductoCompSRV;


public class ListProductosComp 
{
	private List<ProductoComp> productos;

	public ListProductosComp()
	{
		productos= new ArrayList<ProductoComp>();
		productos = ProductoCompSRV.leerProductosComp();
	}

	public List<ProductoComp> getProductosComp() {
		return productos;
	}

	public void setProductos(List<ProductoComp> productos) {
		this.productos = productos;
	}

	public void addProducto(ProductoComp producto){
		productos.add(producto);
		ProductoCompSRV.grabarProductoComp(producto);
	}

	public boolean removeProducto(ProductoComp producto) {

		return productos.remove(producto);
	}

	public List<ProductoComp> getProductos(){
		return productos;
	}

	public ProductoComp getProductoPorId(int id){
		for(ProductoComp p : this.getProductosComp()){
			if(id == p.getCodigo())
				return p;
		}
		return null;
	}
	public ProductoComp getProductoPorNombre(String nombre){
		for(ProductoComp p : this.getProductosComp()){
			if(nombre == p.getNombre())
				return p;
		}
		return null;
	}

	public int size(){
		return productos.size();
	}

	public void actualizarBD() 
	{
		ProductoCompSRV.grabarProductosComp(productos);

	}
}
