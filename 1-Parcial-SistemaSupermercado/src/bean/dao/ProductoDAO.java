package bean.dao;

import java.util.List;
import hbt.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.Producto;

public class ProductoDAO {
	private static ProductoDAO instancia = null;
	private static SessionFactory sf = null;

	public static ProductoDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ProductoDAO();
		} 
		return instancia;
	}

	public void grabarProductos(List<Producto> productos){
		Session session = sf.openSession();
		session.beginTransaction();
		for(Producto producto:productos)
			session.merge(producto);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public List<Producto> leerProductos(){
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Producto> list = session.createQuery("from Producto").list();
		session.close();
		return list;
	}

	public void grabarProducto(Producto p) 
	{
		Session session = sf.openSession();
		session.beginTransaction();
		session.merge(p);
		session.flush();
		session.getTransaction().commit();
		session.close();

	}

}
