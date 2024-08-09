/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego_ahorcado_lab_4;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class JuegoAhorcadoFijo extends JuegoAhorcadoBase {
    
    // Constructor que acepta una palabra secreta fija
    public JuegoAhorcadoFijo(String palabraSecreta) {
        this.palabraSecreta = palabraSecreta;
        this.palabraActual = "_".repeat(palabraSecreta.length());
        this.intentos = 10;
    }

    // Implementacion del metodo para iniciar una palabra secreta
    @Override
    public void inicializarPalabraSecreta() {
        //No es necesario hacer nada aca, debido a que la palabra secreta ya ha sido inicializada en el constructor
        System.out.println("La palabra secreta es: " + palabraSecreta);
    }

    //Aqui se implementa el uno de los metodos para actualizar la palabra que se esta manejando en el momento
    //Por eso se le llama palabra actual
    @Override
    protected void actualizarPalabraActual(char letra) {
        String nuevaPalabraActual = "";
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                nuevaPalabraActual += letra; 
            } else {
                nuevaPalabraActual += palabraActual.charAt(i); 
            }
        }
        palabraActual = nuevaPalabraActual;
    }

    //La implementacion de este metodo es para verificar la letra que va ingresando el usuario
    @Override
    protected boolean verificarLetra(char letra) {
        boolean esCorrecta = palabraSecreta.indexOf(letra) >= 0;
        if (esCorrecta) {
            actualizarPalabraActual(letra);
        } else {
            intentos--;
        }
        return esCorrecta;
    }

    //Se implementa el metodo de si el usuario gano el juego
    @Override
    protected boolean hasGanado() {
        return palabraActual.toString().equals(palabraSecreta);
    }

    //Esta es la logica del juego donde se muestran los guiones y sus intentos, una vez que adivine o no la palabra, se muestran sus respectivos mensajes
    @Override
    public void jugar() {
        char nuevaLetra = ' ';
        while (intentos > 0 && !hasGanado()) {
            System.out.println("Palabra actual: " + palabraActual);
            System.out.println("Intentos restantes: " + intentos);
            System.out.print("Introduce una letra: ");
            String letra = JOptionPane.showInputDialog("Ingrese una nueva palabra:");
            if (letra != null && !letra.isEmpty()) {
                nuevaLetra = letra.charAt(0);
                System.out.println("Letra ingresada: " + nuevaLetra);
            } else {
                JOptionPane.showMessageDialog(null, "No se ingresó ninguna letra.");
            }
            
            if (verificarLetra(nuevaLetra)) {
                System.out.println("¡Correcto!");
            } else {
                System.out.println("¡Incorrecto!");
            }

            if (hasGanado()) {
                System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
            }
        }

        if (!hasGanado()) {
            System.out.println("¡Has perdido! La palabra era: " + palabraSecreta);
        }
    }
}
