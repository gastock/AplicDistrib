package bean;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ProductoComp")
public class ProductoComp extends Producto implements Serializable{

	private static final long serialVersionUID = 1L;

	@OneToMany (cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="codigoCombo")
	private List<ProductoSimple> productosCompuestos;
	@Column (name = "precioCombo")
	private float precioCombo;


	public ProductoComp(){
		this.productosCompuestos= new ArrayList<ProductoSimple>();

	}

	public void setDatos(int cod, String nombre, float precio, int stock){
		this.setCodigo(cod);
		this.nombre= nombre;
		this.precioCombo = precio;
		this.cantStock = stock;
	}

	//	void agregarProductoCompuesto(ProductoSimple p){
	//		productosCompuestos.add(p);
	//	}	

	public float calcularPrecio(){
		return this.getPrecio();
	}

	public List<ProductoSimple> getProductosCompuestos() {
		return productosCompuestos;
	}

	public void setProductosSimple(List<ProductoSimple> productosCompuestos) {
		this.productosCompuestos = productosCompuestos;
	}

	public void agregarProductosSimple(ProductoSimple p){
		this.productosCompuestos.add(p);
	}

	@Override
	public float getPrecio() {
		// TODO Auto-generated method stub
		float precio = 0;
		for (Producto producto:productosCompuestos){
			precio = precio + producto.getPrecio();
		}
		return precio-this.getDescuento();
	}



	public float getPrecioCombo() {
		return precioCombo;
	}

	public void setPrecioCombo(float precioCombo) {
		this.precioCombo = precioCombo;
	}



	public int getCantStock() {
		return cantStock;
	}


	public void setCantStock(int cantStock) {
		this.cantStock = cantStock;
	}



}
