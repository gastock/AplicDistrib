package bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ProductoSimple")
public class ProductoSimple extends Producto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column (name = "precioSimple", nullable = false, length = 10)
	protected float precioSimple;


	public ProductoSimple(){
	}

	public ProductoSimple(int codigo, String nombre, float precio,int cantStock){
		super.setCodigo(codigo);
		this.nombre = nombre;
		this.precioSimple = precio;
		this.cantStock = cantStock;
	}

	public void setDatos(int cod, String nombre, float precio, int stock){
		this.setCodigo(cod);
		this.nombre= nombre;
		this.precioSimple = precio;
		this.cantStock = stock;
	}

	public float calcularPrecio(){
		return this.precioSimple;
	}


	public float getPrecio() {
		return precioSimple;
	}

	public void setPrecio(float precio) {
		this.precioSimple = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantStock() {
		return cantStock;
	}

	public void setCantStock(int cantStock) {
		this.cantStock = cantStock;
	}

	public float getPrecioSimple() {
		return precioSimple;
	}

	public void setPrecioSimple(float precioSimple) {
		this.precioSimple = precioSimple;
	}



}
