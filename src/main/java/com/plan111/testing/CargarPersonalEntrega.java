package com.plan111.testing;

import com.plan111.dao.imp.PersonalEntregaDAO;
import com.plan111.modelo.EstadoPersonalEntrega;
import com.plan111.modelo.PersonalEntrega;
import com.plan111.modelo.Vehiculo;

import java.util.*;

/**
 * @author Guido
 */

public class CargarPersonalEntrega {
  public static void main(String[] args) {

    Calendar fecha = new GregorianCalendar(1991, 5, 2);
    Date fechaNacimientoCadeteFull = fecha.getTime();

    Calendar fecha2 = new GregorianCalendar(2020, 0, 1);
    Date fechaVencimientoCarnetCadeteFull = fecha2.getTime();

    //TODO preguntar porque da error al querer guardar los objetos en la base de datos
//    Vehiculo vehiculoCadeteFull = new Vehiculo();
//    vehiculoCadeteFull.setMarca("Honda");
//
//    List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
//    listaVehiculos.add(vehiculoCadeteFull);
//
//    EstadoPersonalEntrega estadoCadeteFull = new EstadoPersonalEntrega();
//    estadoCadeteFull.setNombre("Disponible");

    PersonalEntrega cadete1 = new PersonalEntrega(
        null,
        "Guido",
        "Cavallo",
        35638764,
        154228287,
        123456,
        fechaNacimientoCadeteFull,
        fechaVencimientoCarnetCadeteFull,
        null,
        null
    );

    PersonalEntrega cadete2 = new PersonalEntrega(
        null,
        "Pablo",
        "Cruciani",
        35638765,
        154228287,
        123456,
        fechaNacimientoCadeteFull,
        fechaVencimientoCarnetCadeteFull,
        null,
        null
    );

    PersonalEntregaDAO nuevoCadete = new PersonalEntregaDAO();
    nuevoCadete.registrarPersonalEntrega(cadete1);
    nuevoCadete.registrarPersonalEntrega(cadete2);
  }
}
