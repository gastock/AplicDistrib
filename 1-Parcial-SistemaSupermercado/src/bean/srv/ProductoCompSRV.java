package bean.srv;

import java.util.List;

import bean.dao.*;
import bean.*;


public class ProductoCompSRV {
	private static ProductoCompDAO dao;

	static {
		dao = ProductoCompDAO.getInstancia();
	}

	public static void grabarProductoComp(ProductoComp p){
		dao.grabarProductoComp(p);
	}

	public static void grabarProductosComp(List<ProductoComp> productos){
		dao.grabarProductosComp(productos);
	}

	public static List<ProductoComp>leerProductosComp()
	{
		return dao.leerProductosComp();
	}

}
