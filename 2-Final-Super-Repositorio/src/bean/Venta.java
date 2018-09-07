package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Venta")
public class Venta implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "codigo")
	private int codigo;
	@OneToOne
	@JoinColumn(name="dnicliente")
	protected Cliente cliente;
	@OneToMany (cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="nroVenta")
	private List<ItemVenta> itemsVenta;
	private float totalVenta;

	public Venta(){
		this.codigo = 0;
		this.cliente = new Cliente();
		this.itemsVenta = new ArrayList<ItemVenta>();
		this.totalVenta = 0;
	}

	public void agregarItemVenta(Producto p, int cant){
		this.itemsVenta.add(new ItemVenta(p,cant));
		this.setTotal(this.calcularTotal());
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public float calcularTotal() {
		this.totalVenta = 0;

		for(ItemVenta itemVenta:itemsVenta)
			totalVenta = totalVenta + itemVenta.getCantidad()*( itemVenta.getProducto().getPrecio() 
					- itemVenta.getProducto().getDescuento());

		return totalVenta;
	}

	public void actualizarStockProductos(){
		for (ItemVenta iv: this.getItemsVenta()){
			
			int nuevaCantStock = iv.getProducto().getCantStock()-iv.getCantidad();
			iv.getProducto().setCantStock(nuevaCantStock);
		}
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public List<ItemVenta> getItemsVenta() {
		return itemsVenta;
	}

	public void setItemsVenta(List<ItemVenta> itemsVenta) {
		this.itemsVenta = itemsVenta;
		this.setTotal(this.calcularTotal());
	}

	public float getTotal() {
		return this.totalVenta ;
	}
	public void setTotal(float total) {
		this.totalVenta = total;
	}
	public VentaView getView()
	{
		return new VentaView(cliente.getNombre(),this.getTotal());

	}
	public String toString(){
		return "CodVenta: "+this.getCodigo()+"-DNI: "+this.getCliente().getDni()+" - Nombre: "+this.getCliente().getNombre();
	}
}
