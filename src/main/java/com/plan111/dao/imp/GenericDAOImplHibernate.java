/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan111.dao.imp;

import com.plan111.dao.GenericDAO;
import com.plan111.dao.BussinessMessage;
import com.plan111.dao.BussinessException;
import com.plan111.hibernate.HibernateUtil;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;

public class GenericDAOImplHibernate<T, ID extends Serializable> implements GenericDAO<T, ID> {

    SessionFactory sessionFactory;
    private final static Logger LOGGER = Logger.getLogger(GenericDAOImplHibernate.class.getName());
    public GenericDAOImplHibernate() 
    {
        sessionFactory=HibernateUtil.getSessionFactory();
    }

    @Override
    public T create() throws BussinessException {
        try {
            return getEntityClass().newInstance();
        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void saveOrUpdate(T entity) throws BussinessException {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
        } catch (javax.validation.ConstraintViolationException cve) {
            try {
                if (session.getTransaction().getStatus() != TransactionStatus.ACTIVE) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new BussinessException(cve);
        } catch (org.hibernate.exception.ConstraintViolationException cve) {
            try {
                if (session.getTransaction().getStatus() != TransactionStatus.ACTIVE) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new BussinessException(cve);
        } catch (RuntimeException ex) {
            try {
                if (session.getTransaction().getStatus() != TransactionStatus.ACTIVE) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw ex;
        } catch (Exception ex) {
            try {
                if (session.getTransaction().getStatus() != TransactionStatus.ACTIVE) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new RuntimeException(ex);
        }
    }

    @Override
    public T get(ID id) throws BussinessException {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            T entity = (T) session.get(getEntityClass(), id);
            session.getTransaction().commit();

            return entity;
        } catch (javax.validation.ConstraintViolationException cve) {
            try {
                if (session.getTransaction().getStatus() != TransactionStatus.ACTIVE) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new BussinessException(cve);
        } catch (org.hibernate.exception.ConstraintViolationException cve) {
            try {
                if (session.getTransaction().getStatus() != TransactionStatus.ACTIVE) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new BussinessException(cve);
        } catch (RuntimeException ex) {
            try {
                if (session.getTransaction().getStatus() != TransactionStatus.ACTIVE) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw ex;
        } catch (Exception ex) {
            try {
                if (session.getTransaction().getStatus() != TransactionStatus.ACTIVE) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(ID id) throws BussinessException {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            T entity = (T) session.get(getEntityClass(), id);
            if (entity == null) {
                throw new BussinessException(new BussinessMessage(null, "Los datos a borrar ya no existen"));
            }
            session.delete(entity);
            session.getTransaction().commit();
        } catch (javax.validation.ConstraintViolationException cve) {
            try {
                if (session.getTransaction().getStatus() != TransactionStatus.ACTIVE) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new BussinessException(cve);
        } catch (org.hibernate.exception.ConstraintViolationException cve) {
            try {
                if (session.getTransaction().getStatus() != TransactionStatus.ACTIVE) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new BussinessException(cve);
        } catch (BussinessException ex) {
            try {
                if (session.getTransaction().getStatus() != TransactionStatus.ACTIVE) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw ex;
        } catch (RuntimeException ex) {
            try {
                if (session.getTransaction().getStatus() != TransactionStatus.ACTIVE) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw ex;
        } catch (Exception ex) {
            try {
                if (session.getTransaction().getStatus() != TransactionStatus.ACTIVE) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<T> findAll() throws BussinessException {
        Session session = sessionFactory.getCurrentSession();
        try {

            Query query = session.createQuery("SELECT e FROM " + getEntityClass().getName() + " e");
            List<T> entities = query.list();

            return entities;
        } catch (javax.validation.ConstraintViolationException cve) {
            try {
                if (session.getTransaction().getStatus() != TransactionStatus.ACTIVE) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new BussinessException(cve);
        } catch (org.hibernate.exception.ConstraintViolationException cve) {
            try {
                if (session.getTransaction().getStatus() != TransactionStatus.ACTIVE) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new BussinessException(cve);
        } catch (RuntimeException ex) {
            try {
                if (session.getTransaction().getStatus() != TransactionStatus.ACTIVE) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw ex;
        } catch (Exception ex) {
            try {
                if (session.getTransaction().getStatus() != TransactionStatus.ACTIVE) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new RuntimeException(ex);
        }
        finally 
        {
            session.flush();
            session.close();
        }
    }

    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
