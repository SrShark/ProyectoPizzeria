package com.plan111.dao.imp;

import com.plan111.hibernate.HibernateUtil;
import com.plan111.modelo.PersonalEntrega;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Guido
 */

public class PersonalEntregaDAO {
  public void registrarPersonalEntrega(PersonalEntrega cadete) {
    Transaction transaction = null;
    Session session = HibernateUtil.getSessionFactory().openSession();

    try {
      transaction = session.beginTransaction();
      session.save(cadete);
      session.getTransaction().commit();
    } catch (Exception error) {
      error.printStackTrace();
      if (transaction != null) {
        transaction.rollback();
      }
    } finally {
      session.flush();
      session.close();
    }
  }
}
