package bean;

import java.util.List;

public class VentaView {

	private int codigo;
	protected String cliente;
	private List<ItemVenta> itemsVenta;
	private float totalVenta;

	public VentaView(String nombreCliente, float total) {
		this.cliente = nombreCliente;
		this.totalVenta = total;
	}

	public float getTotal() {
		return this.totalVenta ;
	}

	public List<ItemVenta> getItemsVenta() {
		return this.itemsVenta;
	}

	public String  getCliente() {
		return this.cliente;
	}

	public int getCodigo() {
		return codigo;
	}



}
