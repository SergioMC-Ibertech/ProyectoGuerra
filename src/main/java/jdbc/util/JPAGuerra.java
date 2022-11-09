package jdbc.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAGuerra {
	private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();
	
	private static EntityManagerFactory buildEntityManagerFactory() {
		 return Persistence.createEntityManagerFactory("guerra");
	}
	
	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
