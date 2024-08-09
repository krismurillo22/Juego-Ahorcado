/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego_ahorcado_lab_4;

/**
 *
 * @author User
 */
public abstract class JuegoAhorcadoBase implements JuegoAhorcadoable{
    protected String palabraSecreta;
    protected String palabraActual;
    protected int intentos;
    
    public JuegoAhorcadoBase() {
        this.intentos = 10;
    }
    
    abstract void actualizarPalabraActual(char letra);
    abstract boolean verificarLetra(char letra);
    abstract boolean hasGanado();
}
