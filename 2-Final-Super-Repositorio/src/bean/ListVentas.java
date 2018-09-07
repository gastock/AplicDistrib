package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import bean.srv.VentaSRV;


public class ListVentas implements Serializable
{
	private List<Venta> ventas;

	public ListVentas()
	{
		ventas= new ArrayList<Venta>();
		ventas = VentaSRV.leerVentas();
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public void addVenta(Venta venta){
		ventas.add(venta);
		VentaSRV.grabarVenta(venta);
	}

	public boolean removeVenta(Venta venta) {
		return ventas.remove(venta);
	}

	public Venta getVentaPorId(int id){
		for(Venta v : ventas){
			if(id == v.getCodigo() )
				return v;
		}
		return null;
	}
	
	
	public Venta getVentaPorPos(int pos){
		return ventas.get(pos);
	}


	public int size(){
		return ventas.size();
	}
/*
	public void actualizarBD() 
	{
		VentaSRV.grabarVentas(ventas);

	}*/
}
