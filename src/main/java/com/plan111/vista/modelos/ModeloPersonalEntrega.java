package com.plan111.vista.modelos;

import com.plan111.modelo.PersonalEntrega;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author Guido Cavallo
 */

public class ModeloPersonalEntrega extends AbstractTableModel {

  private static final String[] columnas = {"id Pers. Entrega", "Nombre", "Apellido", "DNI", "Fecha de Nacimiento"};
  private List<PersonalEntrega> listaPersonalEntrega;

  public ModeloPersonalEntrega (List<PersonalEntrega> listaPersonal) {
    this.listaPersonalEntrega = listaPersonal;
  }

  @Override
  public int getRowCount() {
    return this.listaPersonalEntrega.size();
  }

  @Override
  public int getColumnCount() {
    return 5;
  }

  @Override
  public Object getValueAt(int fila, int columna) {
    return null;
  }

  @Override
  public String getColumnName(int index) {
    return columnas[index];
  }

  public List<PersonalEntrega> getListaPersonalEntrega() {
    return listaPersonalEntrega;
  }

  public void setListaPersonalEntrega(List<PersonalEntrega> listaPersonalEntrega) {
    this.listaPersonalEntrega = listaPersonalEntrega;
  }
}
