package bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="Producto")
public abstract class Producto implements Serializable{

	@Id 
	@Column (name = "codProducto", nullable = false, length = 10)
	private int codProducto;
	@Column (name = "nombre")
	protected String nombre; 
	@Column (name = "descuento")
	private float descuento;
	@Column (name = "cantStock")
	protected int cantStock;


	public Producto(){
	}


	public int getCodigo() {
		return codProducto;
	}

	public void setCodigo(int codigo) {
		this.codProducto = codigo;
	}

	public abstract float getPrecio();


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}


	public int getCodProducto() {
		return codProducto;
	}


	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}


	public int getCantStock() {
		return cantStock;
	}


	public void setCantStock(int cantStock) {
		this.cantStock = cantStock;
	}

	
	public String toString(){
		return "Cod"+this.getCodigo()+"-"+this.getNombre()+"-Stock: "+this.getCantStock();
	}
}
