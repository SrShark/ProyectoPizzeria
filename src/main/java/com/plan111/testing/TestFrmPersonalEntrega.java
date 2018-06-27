package com.plan111.testing;

import com.plan111.controlador.GestorPersonalEntrega;
import com.plan111.dao.BussinessException;
import com.plan111.hibernate.HibernateUtil;
import com.plan111.vista.frmPizza;

/**
 * @author Guido Cavallo
 */

public class TestFrmPersonalEntrega {
  public static void main(String[] args) throws BussinessException {
    HibernateUtil.buildSessionFactory();
    HibernateUtil.openSessionAndBindToThread();

    // instancio un gestor de personal de entrega
    GestorPersonalEntrega gestorPersonalEntrega = new GestorPersonalEntrega(HibernateUtil.getSessionFactory());

    // inicializo con el metodo run la ventana de personal de entrega.
    gestorPersonalEntrega.run();

//    frmPizza ventana = new frmPizza();
//    FrmPersonalEntrega ventana1 = new FrmPersonalEntrega();
  }

}
