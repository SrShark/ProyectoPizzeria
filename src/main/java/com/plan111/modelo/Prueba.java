/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan111.modelo;

import com.plan111.dao.imp.PersonalEntregaDAO;

/**
 *
 * @author Nicolas Oliva
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        PersonalEntrega cadete1 = new PersonalEntrega();
        cadete1.setNombre("Juan");
        cadete1.setNumeroCarnet(123456);

        PersonalEntregaDAO nuevoCadete = new PersonalEntregaDAO();
        nuevoCadete.registrarPersonalEntrega(cadete1);
    }

}
