package bean.srv;

import java.util.List;

import bean.dao.*;
import bean.*;


public class ItemVentaSRV {
	private static ItemVentaDAO dao;

	static {
		dao = ItemVentaDAO.getInstancia();
	}

	public static void grabarItemVenta(ItemVenta i){
		dao.grabarItemVenta(i);
	}

	public static void grabarItemVentas(List<ItemVenta> itemVentas){
		dao.grabarItemVentas(itemVentas);
	}

	public static List<ItemVenta> leerItemVentas()
	{
		return dao.leerItemsVenta();
	}

}
