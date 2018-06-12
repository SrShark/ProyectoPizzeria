/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan111.modelo;

import com.plan111.maps.Geocoding;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

/**
 *
 * @author Nicolas Oliva
 */
public class PruebaGeo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException, MalformedURLException {
        // TODO code application logic here
        
        Geocoding geo = new Geocoding();
        System.out.println(geo.getCoordinates("Periodistas Argentinos 431, Villa Maria"));
    }
    
}
