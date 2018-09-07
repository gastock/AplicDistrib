package bean.dao;

import java.util.List;
import hbt.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.ProductoComp;

public class ProductoCompDAO {
	private static ProductoCompDAO instancia = null;
	private static SessionFactory sf = null;

	public static ProductoCompDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ProductoCompDAO();
		} 
		return instancia;
	}

	public void grabarProductosComp(List<ProductoComp> productos){
		Session session = sf.openSession();
		session.beginTransaction();
		for(ProductoComp productoComp:productos)
			session.merge(productoComp);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public List<ProductoComp> leerProductosComp(){
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<ProductoComp> list = session.createQuery("from ProductoComp").list();
		session.close();
		return list;
	}

	public void grabarProductoComp(ProductoComp p) 
	{
		Session session = sf.openSession();
		session.beginTransaction();
		session.merge(p);
		session.flush();
		session.getTransaction().commit();
		session.close();

	}

}
