package com.plan111.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Guido
 */

@Entity
@Table(name = "tipo_vehiculo")
@Getter @Setter @NoArgsConstructor
public class TipoVehiculo implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer idTipoVehiculo;

  @Column
  private String nombre;
}
