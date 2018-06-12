package com.plan111.modelo;

import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Guido
 */

@Entity
@Table(name = "vehiculo")
@Setter @Getter @NoArgsConstructor
public class Vehiculo implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer idVehiculo;

  @Column
  private String patente;

  @Column
  private String modelo;

  @Column
  private String marca;
      
  @ManyToOne
  @JoinColumn(name="idPersonalEntrega")
  private PersonalEntrega personalEntrega;

  @OneToOne
  @JoinColumn(name="tipo_vehiculo")
  private TipoVehiculo tipoVehiculo;

  public Integer getIdVehiculo() {
    return idVehiculo;
  }

  public void setIdVehiculo(Integer idVehiculo) {
    this.idVehiculo = idVehiculo;
  }

  public String getPatente() {
    return patente;
  }

  public void setPatente(String patente) {
    this.patente = patente;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public PersonalEntrega getPersonalEntrega() {
    return personalEntrega;
  }

  public void setPersonalEntrega(PersonalEntrega personalEntrega) {
    this.personalEntrega = personalEntrega;
  }

  public TipoVehiculo getTipoVehiculo() {
    return tipoVehiculo;
  }

  public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
    this.tipoVehiculo = tipoVehiculo;
  }
}
