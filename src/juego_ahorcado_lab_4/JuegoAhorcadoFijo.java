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
    
    public JuegoAhorcadoFijo(String palabraSecreta) {
        this.palabraSecreta = palabraSecreta;
        this.palabraActual = "_".repeat(palabraSecreta.length());
        this.intentos = 10;
    }

    @Override
    public void inicializarPalabraSecreta() {
        //No es necesario hacer nada aca, debido a que la palabra secreta ya ha sido inicializada en el constructor
        System.out.println("La palabra secreta es: " + palabraSecreta);
    }

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

    @Override
    protected boolean hasGanado() {
        return palabraActual.equals(palabraSecreta);
    }

    public void jugar() {
        JOptionPane.showMessageDialog(null, "¡HORA DE EMPEZAR!\nAdivina la palabra");
        while (!hasGanado() && intentos > 0) {
            String letra=" ";
            letra = JOptionPane.showInputDialog(null, "Palabra: " + palabraActual
                    + "\nIntentos: " + intentos
                    + "\nIngresa una letra:");
            if (letra == null || letra.isEmpty()) {
                break;
            }else{ //El error que salia era porque letras las convertia antes de que fuera el break si estaba vacia.
                letra=letra.toUpperCase();
                char letraChar = letra.charAt(0);
                if (verificarLetra(letraChar)) {
                    actualizarPalabraActual(letraChar);
                    if (hasGanado()) {
                        JOptionPane.showMessageDialog(null, "¡FELICIDADES GANASTE! Su palabra era: " + palabraSecreta);
                    }
                } else {
                    if (intentos == 0) {
                        JOptionPane.showMessageDialog(null, "¡UPS PERDEDOR! La palabra era: " + palabraSecreta);
                    } else {
                        JOptionPane.showMessageDialog(null, "UPS. Letra incorrecta, por favor intenta de nuevo.");
                    }
                }
            }
        }
    }
}
