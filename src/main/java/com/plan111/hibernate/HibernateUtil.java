package com.plan111.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;

public class HibernateUtil {

  private static SessionFactory sessionFactory;

  public static synchronized void buildSessionFactory() {
    try {
      if (sessionFactory == null) {
        Configuration configuration = new Configuration();
        configuration.configure();
        // utiliza las propiedades del archivo hibernate.properties
        sessionFactory = configuration.configure().buildSessionFactory();
      }
    } catch (Exception e) {
      throw e;
    }
  }

  public static void openSessionAndBindToThread() {
    Session session = sessionFactory.openSession();
    ThreadLocalSessionContext.bind(session);
  }

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      buildSessionFactory();
    }
    return sessionFactory;
  }

  public static void closeSessionAndUnbindFromThread() {
    Session session = ThreadLocalSessionContext.unbind(sessionFactory);
    if (session != null) {
      session.close();
    }
  }

  public static void closeSessionFactory() {
    if ((sessionFactory != null) && (!sessionFactory.isClosed())) {
      sessionFactory.close();
    }
  }
}
