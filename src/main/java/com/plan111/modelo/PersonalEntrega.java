package com.plan111.modelo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="personal_entrega")
public class PersonalEntrega implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idPersonalEntrega; 
  
  @Column(
      updatable = true,
      length = 25,
      nullable = false
  )
  private String nombre;

  @Column(
      updatable = true,
      length = 25,
      nullable = false
  )
  private String apellido;
  
  @Column(
      updatable = true,
      nullable = false,
      unique = true
  )
  private Integer dni;

  @Column(
      updatable = true,
      nullable = false
  )
  private Integer telefono;

  @Column(
      updatable = true,
      nullable = false
  )
  private Integer numeroCarnet;

  @Column(
      updatable = true,
      nullable = false
  )
  @Temporal(TemporalType.DATE)
  private Date fechaNacimiento;

  @Column(
      updatable = true,
      nullable = false
  )
  @Temporal(TemporalType.DATE)
  private Date fechaVencimientoCarnet;

  @OneToMany(mappedBy = "personalEntrega", cascade = CascadeType.ALL)
//  @JoinColumn(name="idVehiculo")
  private List<Vehiculo> vehiculo;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name="estado_personal_entrega")
  private EstadoPersonalEntrega estadoPersonalEntrega;

  // Una clase con muchos contructores, significa sobre carga de la clase.
  public PersonalEntrega(Integer idPersonalEntrega, String nombre, String apellido, Integer dni, Integer telefono, Integer numeroCarnet, Date fechaNacimiento, Date fechaVencimientoCarnet, List<Vehiculo> vehiculo, EstadoPersonalEntrega estadoPersonalEntrega) {
    this.idPersonalEntrega = idPersonalEntrega;
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
    this.telefono = telefono;
    this.numeroCarnet = numeroCarnet;
    this.fechaNacimiento = fechaNacimiento;
    this.fechaVencimientoCarnet = fechaVencimientoCarnet;
    this.vehiculo = vehiculo;
    this.estadoPersonalEntrega = estadoPersonalEntrega;
  }

  public PersonalEntrega(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  // Sobre escritura de metodos (Polimorfismo)
  @Override
  public String toString() {
    String mensaje = String.format("el nombre es: %s", getNombre());
    return mensaje;
  }
}
