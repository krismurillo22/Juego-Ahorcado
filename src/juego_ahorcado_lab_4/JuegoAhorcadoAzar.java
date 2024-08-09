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
    private List<String> palabrasPosibles;

    //Constructor de la clase
    public JuegoAhorcadoAzar(List<String> palabrasPosibles) {
        this.palabrasPosibles = palabrasPosibles;
        inicializarPalabraSecreta();
    }

    //Inicializacion del metodo para iniciar la seleccion de la palabra secreta
    @Override
    public void inicializarPalabraSecreta() {
        if (palabrasPosibles != null && !palabrasPosibles.isEmpty()) {
             Random rand = new Random();
            palabraSecreta = palabrasPosibles.get(rand.nextInt(palabrasPosibles.size()));
            // Crear un String con guiones bajos repetidos
            palabraActual = "_".repeat(palabraSecreta.length());
            System.out.println("Palabra secreta seleccionada: " + palabraSecreta);
        } else {
            System.out.println("La lista de palabras se encuentra vacía.");
            
        }
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
        
    }

    
    
}
