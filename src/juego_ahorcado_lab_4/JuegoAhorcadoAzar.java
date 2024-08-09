/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego_ahorcado_lab_4;

/**
 *
 * @author User
 */
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

public class JuegoAhorcadoAzar extends JuegoAhorcadoBase {
    private String palabrasPosibles;

    //Constructor de la clase
    public JuegoAhorcadoAzar(String palabra) {
        this.palabraSecreta = palabra;
        this.palabraActual = "_".repeat(palabraSecreta.length());
        this.intentos = 10;
    }

    //Inicializacion del metodo para iniciar la seleccion de la palabra secreta
    @Override
    public void inicializarPalabraSecreta() {
        
    }

    //Aqui se implementa el metodo para actualizar la palabra actual en el juego
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

    //Esta es la implementacion donde se verifican las letras
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
    
    //Aqui se implementa el metodo de que se ha ganado
    protected boolean hasGanado() {
        return palabraActual.toString().equals(palabraSecreta);
    }

    public void jugar() {
        JOptionPane.showMessageDialog(null, "Adivina la palabra secreta al azar.");
        while (!hasGanado() && intentos > 0) {
            String letra = JOptionPane.showInputDialog(null, "Palabra: " + palabraActual
                    + "\nIntentos: " + intentos
                    + "\nIngresa una letra:");

            if (letra == null || letra.isEmpty()) {
                break;
            }
            char letraChar = letra.charAt(0);
            if (verificarLetra(letraChar)) {
                actualizarPalabraActual(letraChar);
                if (hasGanado()) {
                    JOptionPane.showMessageDialog(null, "¡FELICIDADES! Has ganado. La palabra era: " + palabraSecreta);
                }
            } else {
                if (intentos == 0) {
                    JOptionPane.showMessageDialog(null, "¡Lo siento! Has perdido. La palabra era: " + palabraSecreta);
                } else {
                    JOptionPane.showMessageDialog(null, "Letra incorrecta. Intenta de nuevo.");
                }
            }
        }
    }  
}
