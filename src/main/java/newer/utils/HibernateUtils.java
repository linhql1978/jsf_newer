package newer.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

	private static SessionFactory sessionFactory;

	private HibernateUtils() {
	};

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
					.build();

			Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

			synchronized (HibernateUtils.class) {
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			}
		}
		return sessionFactory;
	}
}
