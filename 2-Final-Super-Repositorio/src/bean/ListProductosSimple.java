package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import bean.srv.ProductoSimpleSRV;


public class ListProductosSimple implements Serializable
{
	private List<ProductoSimple> productos;

	public ListProductosSimple()
	{
		productos= new ArrayList<ProductoSimple>();
		productos = ProductoSimpleSRV.leerProductosSimple();
	}

	public List<ProductoSimple> getProductosSimple() {
		return productos;
	}

	public void setProductos(List<ProductoSimple> productos) {
		this.productos = productos;
	}

	public void addProducto(ProductoSimple producto){
		productos.add(producto);
		ProductoSimpleSRV.grabarProductoSimple(producto);
	}

	public boolean removeProducto(ProductoSimple producto) {
		return productos.remove(producto);
	}

	public ProductoSimple getProductoPorId(int id){
		for(ProductoSimple p : this.getProductosSimple()){
			if(id == p.getCodigo() )
				return p;
		}
		return null;
	}
	public ProductoSimple getProductoPorNombre(String nombre){
		for(ProductoSimple p : this.getProductosSimple()){
			if(nombre == p.getNombre() )
				return p;
		}
		return null;
	}	

	public int size(){
		return productos.size();
	}

	public void actualizarBD() 
	{
		ProductoSimpleSRV.grabarProductosSimple(productos);

	}
}
