package com.plan111.testing;

import com.plan111.dao.BussinessException;
import com.plan111.dao.imp.PersonalEntregaDAO;
import com.plan111.hibernate.HibernateUtil;
import com.plan111.modelo.EstadoPersonalEntrega;
import com.plan111.modelo.PersonalEntrega;
import com.plan111.modelo.Vehiculo;

import java.util.*;

/**
 * @author Guido
 */

public class CargarPersonalEntrega {
  public static void main(String[] args) throws BussinessException {
    HibernateUtil.buildSessionFactory();
    HibernateUtil.openSessionAndBindToThread();

    Calendar fecha = new GregorianCalendar(1991, 5, 2);
    Date fechaNacimientoCadete = fecha.getTime();

    Calendar fecha2 = new GregorianCalendar(2020, 0, 1);
    Date fechaVencimientoCarnetCadete = fecha2.getTime();

    Vehiculo vehiculo1 = new Vehiculo(null);
    vehiculo1.setMarca("Honda");
    vehiculo1.setModelo("Biz");
    vehiculo1.setPatente("asd 123");

    Vehiculo vehiculo2 = new Vehiculo(null);
    vehiculo2.setMarca("Yamaha");
    vehiculo2.setModelo("FZ");
    vehiculo2.setPatente("awd 456");

    List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
    listaVehiculos.add(vehiculo1);
    listaVehiculos.add(vehiculo2);

    EstadoPersonalEntrega estadoCadeteFull = new EstadoPersonalEntrega();
    estadoCadeteFull.setNombre("Disponible");

    EstadoPersonalEntrega estadoCadeteFull2 = new EstadoPersonalEntrega();
    estadoCadeteFull.setNombre("No Disponible");

    PersonalEntrega cadete1 = new PersonalEntrega(
        null,
        "Guido",
        "Cavallo",
        99888777,
        154154154,
        123456,
        fechaNacimientoCadete,
        fechaVencimientoCarnetCadete,
        listaVehiculos,
        estadoCadeteFull
    );

    PersonalEntrega cadete2 = new PersonalEntrega(
        null,
        "Pablo",
        "Cruciani",
        88777666,
        154154154,
        123456,
        fechaNacimientoCadete,
        fechaVencimientoCarnetCadete,
        listaVehiculos,
        estadoCadeteFull2
    );

    // le establezco a cada personal un vehiculo;
    vehiculo1.setPersonalEntrega(cadete1);
    vehiculo2.setPersonalEntrega(cadete2);

    PersonalEntregaDAO nuevoCadete = new PersonalEntregaDAO();
    nuevoCadete.saveOrUpdate(cadete1);
    nuevoCadete.saveOrUpdate(cadete2);
    nuevoCadete.buscarPorTipoVehiculo(vehiculo1);
  }
}
