package com.plan111.dao.imp;

import com.plan111.modelo.PersonalEntrega;
import com.plan111.modelo.Vehiculo;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Guido
 */

public class PersonalEntregaDAO extends GenericDAOImplHibernate<PersonalEntrega, Integer>{
  public void registrarPersonalEntrega(PersonalEntrega cadete) {
    // acá van metodos propios que peguen a la base de datos.
    // El generic ya se encarga de los metodos básicos del crud.
  }

  public List buscarPorVehiculo(Vehiculo vehiculo) {
    // obtengo la sesión actual.
    Session session = sessionFactory.getCurrentSession();
    List listaPersonal = new ArrayList<PersonalEntrega>();

    try {
      // Esto es un query de hibernate que maneja objetos.
      // con ":nombreParametro" establezco los parametos para la consulta.
      Query query = session.createQuery("SELECT pe FROM PersonalEntrega pe INNER JOIN pe.vehiculo v WHERE v.idVehiculo = :idVehiculo");

      // le pasamos al parametro "?" (que se identifica con el indice 0) el id del vehiculo.
      query.setInteger("idVehiculo", vehiculo.getIdVehiculo());

      //asigno a la lista lo que se ejecuta en el query.
      listaPersonal = query.list();

    } catch (Exception e) {
      throw e;
    }

    return listaPersonal;
  }
}
