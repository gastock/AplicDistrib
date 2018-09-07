package bean;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ItemVenta")
public class ItemVenta implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numero;
	@OneToOne (cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="codProducto")
	private Producto producto;
	@Column (name = "cantidad")
	private int cantidad;


	public ItemVenta()
	{

	}
	public ItemVenta(Producto p,int cant)
	{

		this.producto = p;
		this.cantidad = cant;
	}


	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String toString(){
		return "CodItem: "+this.numero+" -CodProd: "+this.getProducto().getCodigo()+" - "+this.getProducto().getNombre()
				+" - Precio: "+this.getProducto().getPrecio()+"Cantidad:"+this.getCantidad();
	}
}
