package bean.dao;

import java.util.List;
import hbt.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.ProductoSimple;

public class ProductoSimpleDAO {
	private static ProductoSimpleDAO instancia = null;
	private static SessionFactory sf = null;

	public static ProductoSimpleDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ProductoSimpleDAO();
		} 
		return instancia;
	}

	public void grabarProductosSimple(List<ProductoSimple> productos){
		Session session = sf.openSession();
		session.beginTransaction();
		for(ProductoSimple productoComp:productos)
			session.merge(productoComp);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public List<ProductoSimple> leerProductosSimple(){
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<ProductoSimple> list = session.createQuery("from ProductoSimple").list();
		session.close();
		return list;
	}

	public void grabarProductoSimple(ProductoSimple p) 
	{
		Session session = sf.openSession();
		session.beginTransaction();
		session.merge(p);
		session.flush();
		session.getTransaction().commit();
		session.close();

	}

}
