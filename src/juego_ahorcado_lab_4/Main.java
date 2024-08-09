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
    private JTextArea textArea;
    private JTextField textField;
    private JButton botonMandarDatos;

    
    public Main() {
        admin = new AdminPalabrasSecretas();
        
        
        admin.agregarPalabra("Manzanas");
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
                if (admin.getPalabras().isEmpty()){
                    JOptionPane.showMessageDialog(null, "No hay ninguna palabra agregada.\n Por favor agrega una palabra.");
                }else{
                    JOptionPane.showMessageDialog(null, "Juego de Ahorcado en modo Azar iniciado!");
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
                    JOptionPane.showMessageDialog(null, "Juego de Ahorcado en modo Fijo iniciado!");
                    String[] opciones = admin.getPalabras().toArray(new String[0]);;
                    String seleccion = (String) JOptionPane.showInputDialog(
                        null,
                        "Selecciona una palabra:",
                        "Seleccionar Palabra",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        opciones,
                        opciones[0] // Valor inicial seleccionado
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
        // Crear y mostrar el JFrame
        new Main();
    }
}
