package bean.dao;

import java.util.List;
import hbt.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.Venta;


public class VentaDAO {
	private static VentaDAO instancia = null;
	private static SessionFactory sf = null;

	public static VentaDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new VentaDAO();
		} 
		return instancia;
	}

	public List<Venta> leerVentas(){
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Venta> list = session.createQuery("from Venta").list();
		session.close();
		return list;
	}

	public void grabarVenta(Venta v) 
	{
		Session session = sf.openSession();
		session.beginTransaction();
		session.merge(v);
		session.flush();
		session.getTransaction().commit();
		session.close();

	}

}
