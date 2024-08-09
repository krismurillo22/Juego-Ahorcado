/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego_ahorcado_lab_4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class Main extends JFrame{
    AdminPalabrasSecretas admin;
    JuegoAhorcadoAzar juegoAzar; 
    
    public Main() {
        admin = new AdminPalabrasSecretas();
        juegoAzar= new JuegoAhorcadoAzar(admin.getPalabras());
        
        setTitle("Ahorcado");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Juego del Ahorcado");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel);

        // Crear los botones
        JPanel buttonPanel = new JPanel();
        JButton btnFijo = new JButton("Juego Fijo");
        JButton btnAzar = new JButton("Juego Azar");
        JButton btnAgregar = new JButton("Agregar Palabra");
        JButton Salir = new JButton("Salir");
        btnFijo.setPreferredSize(new Dimension(180, 50));
        btnAzar.setPreferredSize(new Dimension(180, 50));
        btnAgregar.setPreferredSize(new Dimension(180, 50));
        Salir.setPreferredSize(new Dimension(180, 50));
        // Ajustar la fuente de los botones
        btnFijo.setFont(new Font("Arial", Font.PLAIN, 18));
        btnAzar.setFont(new Font("Arial", Font.PLAIN, 18));
        btnAgregar.setFont(new Font("Arial", Font.PLAIN, 18));
        Salir.setFont(new Font("Arial", Font.PLAIN, 18));
        // Añadir los botones al panel
        buttonPanel.add(btnFijo);
        buttonPanel.add(btnAzar);
        buttonPanel.add(btnAgregar);
        buttonPanel.add(Salir);
        // Añadir los paneles al JFrame usando BorderLayout
        add(titlePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar un cuadro de diálogo para ingresar una palabra
                String nuevaPalabra = JOptionPane.showInputDialog("Ingrese una nueva palabra:");
                if (nuevaPalabra != null && !nuevaPalabra.trim().isEmpty()) {
                    admin.agregarPalabra(nuevaPalabra);
                    System.out.println("Palabra ingresada: " + nuevaPalabra);
                } else {
                    JOptionPane.showMessageDialog(null, "No se ingresó ninguna palabra válida.");
                }
            }
        });

        Salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar la aplicación
                System.exit(0);
            }
        });
        setVisible(true);
        
        btnAzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Iniciar juego de ahorcado en modo azar
                juegoAzar.inicializarPalabraSecreta();
                if (admin.getPalabras().isEmpty()){
                    JOptionPane.showMessageDialog(null, "No hay ninguna palabra agregada.\n Por favor agrega una palabra.");
                }else{
                    JOptionPane.showMessageDialog(null, "Juego de Ahorcado en modo Azar iniciado!");
                }
            }
        });
    }
    
    public static void main(String[] args) {
        // Crear y mostrar el JFrame
        new Main();
    }
}
