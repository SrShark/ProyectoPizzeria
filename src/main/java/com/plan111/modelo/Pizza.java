/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan111.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author USUARIO
 */
@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="pizza")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column
    private String nombre;
    @Column
    private double precio;
    @Column
    private TipoPizza tipo;
    @Column
    private VariedadPizza variedad;
    @Column
    private TamañoPizza tamaño;

}
