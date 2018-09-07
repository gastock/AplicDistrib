package bean.srv;

import java.util.List;

import bean.dao.*;
import bean.*;


public class ProductoSimpleSRV {
	private static ProductoSimpleDAO dao;

	static {
		dao = ProductoSimpleDAO.getInstancia();
	}

	public static void grabarProductoSimple(ProductoSimple p){
		dao.grabarProductoSimple(p);
	}

	public static void grabarProductosSimple(List<ProductoSimple> productos){
		dao.grabarProductosSimple(productos);
	}

	public static List<ProductoSimple>leerProductosSimple()
	{
		return dao.leerProductosSimple();
	}

}
