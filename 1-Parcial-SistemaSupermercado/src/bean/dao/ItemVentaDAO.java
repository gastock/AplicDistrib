package bean.dao;

import java.util.List;
import hbt.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.ItemVenta;


public class ItemVentaDAO {
	private static ItemVentaDAO instancia = null;
	private static SessionFactory sf = null;

	public static ItemVentaDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ItemVentaDAO();
		} 
		return instancia;
	}

	public void grabarItemVentas(List<ItemVenta> itemsVenta){
		Session session = sf.openSession();
		session.beginTransaction();
		for(ItemVenta itemVenta:itemsVenta)
			session.merge(itemVenta);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public List<ItemVenta> leerItemsVenta(){
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<ItemVenta> list = session.createQuery("from ItemVenta").list();
		session.close();
		return list;
	}

	public void grabarItemVenta(ItemVenta i) 
	{
		Session session = sf.openSession();
		session.beginTransaction();
		session.merge(i);
		session.flush();
		session.getTransaction().commit();
		session.close();

	}

}
