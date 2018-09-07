package hbt;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import bean.*;


public class HibernateUtil
{
	private static final SessionFactory sessionFactory;
	static
	{
		try
		{

			Configuration config = new Configuration();
			config.addAnnotatedClass(Cliente.class);
			config.addAnnotatedClass(ProductoSimple.class);
			config.addAnnotatedClass(ProductoComp.class);
			config.addAnnotatedClass(ItemVenta.class);
			config.addAnnotatedClass(Venta.class);

			sessionFactory = config.buildSessionFactory();

		}
		catch (Throwable ex)
		{
			System.err.println("Initial SessionFactory creation failed." + ex);
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
}

