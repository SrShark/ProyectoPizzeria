package com.plan111.vista;

import com.plan111.controlador.GestorPersonalEntrega;
import com.plan111.dao.BussinessException;
import com.plan111.vista.modelos.ModeloPersonalEntrega;

import javax.swing.*;

/**
 * @author Guido Cavallo
 */

public class frmPersonalEntrega extends javax.swing.JFrame {
  private final GestorPersonalEntrega gestor;
  private ModeloPersonalEntrega modeloTablaPersonalEntrega;

  private JTable tablaPersonalEntrega;
  private JPanel panel1;

  public frmPersonalEntrega(GestorPersonalEntrega gestor) throws BussinessException {
    this.gestor = gestor;
    this.modeloTablaPersonalEntrega = new ModeloPersonalEntrega(gestor.listarPersonalEntrega());
    inciarComponentes();
    setVisible(true);
    setSize(600, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setTitle("Agregar Personal de Entrega");
    this.tablaPersonalEntrega.setModel(this.modeloTablaPersonalEntrega);
  }

  private void inciarComponentes() {
    JPanel panel = new JPanel();
    panel.setLayout(null);
    this.getContentPane().add(panel);
  }
}
