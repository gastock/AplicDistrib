package bean.srv;

import java.util.List;

import bean.dao.*;
import bean.*;


public class VentaSRV {
	private static VentaDAO dao;

	static {
		dao = VentaDAO.getInstancia();
	}

	public static void grabarVenta(Venta v){
		dao.grabarVenta(v);
	}
/*
	public static void grabarVentas(List<Venta> ventas){
		dao.grabarVentas(ventas);
	}
*/
	public static List<Venta>leerVentas()
	{
		return dao.leerVentas();
	}

}
