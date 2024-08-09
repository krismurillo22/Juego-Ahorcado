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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class Main extends JFrame{
    AdminPalabrasSecretas admin;
    JuegoAhorcadoAzar juegoAzar; 
    JuegoAhorcadoFijo juegoFijo; 

    
    public Main() {
        admin = new AdminPalabrasSecretas();
        admin.agregarPalabra("MANZANAS");
        setTitle("Ahorcado");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Juego del Ahorcado");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel);

        JPanel buttonPanel = new JPanel();
        JButton btnFijo = new JButton("Ahorcado Fijo");
        JButton btnAzar = new JButton("Ahorcado al Azar");
        JButton btnAgregar = new JButton("Agregar Palabra");
        JButton Salir = new JButton("Salir");
        
        btnFijo.setFocusable(false);
        btnAzar.setFocusable(false);
        btnAgregar.setFocusable(false);
        Salir.setFocusable(false);
        
        btnFijo.setPreferredSize(new Dimension(180, 50));
        btnAzar.setPreferredSize(new Dimension(180, 50));
        btnAgregar.setPreferredSize(new Dimension(180, 50));
        Salir.setPreferredSize(new Dimension(180, 50));
        
        //Esto es pura decoracion para los botones
        btnFijo.setFont(new Font("Arial", Font.BOLD, 18));
        btnAzar.setFont(new Font("Arial", Font.BOLD, 18));
        btnAgregar.setFont(new Font("Arial", Font.BOLD, 18));
        Salir.setFont(new Font("Arial", Font.BOLD, 18));

        Color colorNuevoSalida = new Color(109, 14, 16);
        Color colorNuevoOtros = new Color(139, 64, 66);
        
        Salir.setBackground(colorNuevoSalida);
        btnAzar.setBackground(colorNuevoOtros);
        btnFijo.setBackground(colorNuevoOtros);
        btnAgregar.setBackground(colorNuevoOtros);
        
        Salir.setForeground(Color.WHITE);
        btnFijo.setForeground(Color.WHITE);
        btnAzar.setForeground(Color.WHITE);
        btnAgregar.setForeground(Color.WHITE);
        
        buttonPanel.add(btnFijo);
        buttonPanel.add(btnAzar);
        buttonPanel.add(btnAgregar);
        buttonPanel.add(Salir);
        
        add(titlePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nuevaPalabra = JOptionPane.showInputDialog("Ingrese una nueva palabra:");
                if (nuevaPalabra != null && !nuevaPalabra.trim().isEmpty()) {
                    admin.agregarPalabra(nuevaPalabra.toUpperCase());
                    System.out.println("Palabra ingresada: " + nuevaPalabra);
                } else {
                    JOptionPane.showMessageDialog(null, "No se ingresó ninguna palabra valida.");
                }
            }
        });

        Salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
        
        btnAzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (admin.getPalabras().isEmpty()){
                    JOptionPane.showMessageDialog(null, "No hay ninguna palabra agregada.\n Por favor agregar una palabra.");
                }else{
                    JOptionPane.showMessageDialog(null, "¡Juego en modo Azar ACTIVADO!");
                    juegoAzar= new JuegoAhorcadoAzar(admin.obtenerPalabraAlAzar());  
                    juegoAzar.jugar();
                }
            }
        });
        
        btnFijo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Iniciar juego de ahorcado en modo azar     
                if (admin.getPalabras().isEmpty()){
                    JOptionPane.showMessageDialog(null, "No hay ninguna palabra agregada.\n Por favor agrega una palabra.");
                }else{
                    JOptionPane.showMessageDialog(null, "¡Juego en modo Fijo ACTIVADO!");
                    String[] opciones = admin.getPalabras().toArray(new String[0]);;
                    String seleccion = (String) JOptionPane.showInputDialog(
                        null,
                        "Selecciona una palabra:",
                        "Seleccionar Palabra",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        opciones,
                        opciones[0]
                    );
                    if (seleccion != null) {
                        JOptionPane.showMessageDialog(null, "Palabra seleccionada: " + seleccion);
                        juegoFijo= new JuegoAhorcadoFijo(seleccion);  
                        juegoFijo.jugar();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se seleccionó ninguna palabra.");
                    }
                    
                }
            }
        });
    }
    
    public static void main(String[] args) {
        new Main();
    }
}
