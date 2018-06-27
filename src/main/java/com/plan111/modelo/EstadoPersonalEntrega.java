package com.plan111.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "estado_personal_entrega")
@Getter @Setter @NoArgsConstructor
public class EstadoPersonalEntrega implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idEstadoPersonalEntrega;

  @Column(
      updatable = true,
      length = 20,
      nullable = false
  )
  private String nombre;

  @Column(
      updatable = true,
      length = 255,
      nullable = true
  )
  private  String descripcion;

  public Integer getIdEstadoPersonalEntrega() {
    return idEstadoPersonalEntrega;
  }

  public void setIdEstadoPersonalEntrega(Integer idEstadoPersonalEntrega) {
    this.idEstadoPersonalEntrega = idEstadoPersonalEntrega;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
}
