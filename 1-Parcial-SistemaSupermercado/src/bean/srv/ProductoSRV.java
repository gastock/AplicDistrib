package bean.srv;

import java.util.List;

import bean.dao.*;
import bean.*;


public class ProductoSRV {
	private static ProductoDAO dao;

	static {
		dao = ProductoDAO.getInstancia();
	}

	public static void grabarProducto(Producto p){
		dao.grabarProducto(p);
	}

	public static void grabarProductos(List<Producto> productos){
		dao.grabarProductos(productos);
	}

	public static List<Producto>leerProductos()
	{
		return dao.leerProductos();
	}

}
