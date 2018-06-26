package com.plan111.vista;

import javax.swing.*;
import java.awt.*;

/**
 * @author Guido Cavallo
 */

public class FrmPersonalEntrega extends JFrame {

  public FrmPersonalEntrega() {
    inciarComponentes();
    setVisible(true);
    setSize(600, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setTitle("Agregar Personal de Entrega");
  }

  private void inciarComponentes() {
    JPanel panel = new JPanel();
    panel.setLayout(null);
    this.getContentPane().add(panel);

    JLabel labelNombre = new JLabel("Nombre:");
    labelNombre.setBounds(0, 10, 50, 20);
    JLabel labelApellido = new JLabel("Apellido:");
    labelApellido.setBounds(0, 40, 50, 20);
    panel.add(labelNombre);
    panel.add(labelApellido);
  }
}
