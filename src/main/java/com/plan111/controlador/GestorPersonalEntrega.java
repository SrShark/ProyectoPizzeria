package com.plan111.controlador;

import com.plan111.dao.BussinessException;
import com.plan111.dao.imp.PersonalEntregaDAO;
import com.plan111.modelo.PersonalEntrega;
import com.plan111.modelo.Vehiculo;
import com.plan111.vista.frmPersonalEntrega;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Guido Cavallo
 */

public class GestorPersonalEntrega {
  private PersonalEntrega personalEntrega;
  private List listaPersonal;
  private final SessionFactory sessionFactory;
  private final PersonalEntregaDAO personalEntregaDAO;

  public GestorPersonalEntrega(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
    this.personalEntregaDAO = new PersonalEntregaDAO();
  }

  public void registrarPersonalEntrega(PersonalEntrega personal) throws BussinessException {
    personalEntregaDAO.saveOrUpdate(personal);
  }

  public void actualizarPersonalEntrega(PersonalEntrega personal) throws BussinessException {
    personalEntregaDAO.saveOrUpdate(personal);
  }

  public void eliminarPersonalEntrega(PersonalEntrega personal) throws BussinessException {
    personalEntregaDAO.delete(personal.getIdPersonalEntrega());
  }

  public PersonalEntrega traerPersonalEntrega(PersonalEntrega personal) throws BussinessException {
    this.personalEntrega = personalEntregaDAO.get(personal.getIdPersonalEntrega());

    return this.personalEntrega;
  }

  public List<PersonalEntrega> listarPersonalEntrega() throws BussinessException {
    return personalEntregaDAO.findAll();
  }

  public void listarPersonalPorVehiculo(Vehiculo vehiculo) {
    // es buena práctica instanciar la lista dentro del metodo, para asegurarse de que este vacia al momento de asignar algo.
    this.listaPersonal = new ArrayList<PersonalEntrega>();
    this.listaPersonal = personalEntregaDAO.buscarPorVehiculo(vehiculo);
  }

  public void run() throws BussinessException {
    // le paso al constructor del frmPersonalEntrega el gestor para tener acceso.
    new frmPersonalEntrega(this);
  }
}
