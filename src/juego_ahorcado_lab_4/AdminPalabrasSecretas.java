/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego_ahorcado_lab_4;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdminPalabrasSecretas {
    public List<String> palabras;

    public AdminPalabrasSecretas() {
        this.palabras = new ArrayList<>();
    }
    
    //Metodo para agregar una nueva palabra a la lista
    public void agregarPalabra(String palabra) {
        if (palabra != null && !palabra.isEmpty()){
            palabras.add(palabra);
            System.out.println("Su palabra ha sido agregada correctamente: " + palabra);
        }
    }
    
    //Metodo para obtener una palabra al azar de la lista
    public String obtenerPalabraAlAzar() {
        if (palabras.isEmpty()){
            System.out.println("No hay palabras disponibles para obtener.");
            return null;
        }
        
        Random ran = new Random();
        String palabra_Seleccionada = palabras.get(ran.nextInt(palabras.size()));
        System.out.println("La palabra que fue seleccionada al azar es: " + palabra_Seleccionada);
        return palabra_Seleccionada;
    }
    
    //Metodo para mostrar todas las palabras de la lista
    public void mostrarPalabras() {
        if (palabras.isEmpty()) {
            System.out.println("No hay palabras en el listado.");
        } else {
            System.out.println("Lista de palabras:");
            for (String palabra : palabras) {
                System.out.println("- " + palabra);
            }
        }
    }
    
    //Metodo para eliminar una palabra en especifico que decida el usuario
    public void eliminarPalabra(String palabra) {
        if (palabras.remove(palabra)) {
            System.out.println("Palabra que ha sido eliminada: " + palabra);
        } else {
            System.out.println("La palabra no se encontró en la lista.");
        }
    }
    
    //Metodo para obtener la cantidad de palabras en la lista
    public int obtenerCantidadDePalabras() {
        return palabras.size();
    }

    //Metodo para obtener la lista de palabras
    public List<String> getPalabras() {
        return palabras;
    }
} 
