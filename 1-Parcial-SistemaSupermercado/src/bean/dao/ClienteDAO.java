package bean.dao;

import java.util.List;
import hbt.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.Cliente;

public class ClienteDAO {
	private static ClienteDAO instancia = null;
	private static SessionFactory sf = null;

	public static ClienteDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ClienteDAO();
		} 
		return instancia;
	}

	public void grabarClientes(List<Cliente> clientes){
		Session session = sf.openSession();
		session.beginTransaction();
		for(Cliente cliente:clientes)
			session.merge(cliente);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public List<Cliente> leerClientes(){
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Cliente> list = session.createQuery("from Cliente").list();
		session.close();
		return list;
	}

	public void grabarCliente(Cliente cli) 
	{
		Session session = sf.openSession();
		session.beginTransaction();
		session.merge(cli);
		session.flush();
		session.getTransaction().commit();
		session.close();

	}

}
