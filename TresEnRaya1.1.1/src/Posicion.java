/**
 * Posicion.java
 * ccatalan (01/2018) 
 *   
 */


/**
 *  Posición en el tablero de juego
 * 
 */
public class Posicion {
    private int fila;
    private int columna;
    
    /**
     *  Construye una posición
     *  
     */  
    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }
  
    /**
     *  Devuelve la fila de la posición
     * 
     */   
    public int devolverFila() {
        return fila;
    }

    /**
     *  Devuelve la columna de la posición
     * 
     */
    public int devolverColumna() {
        return columna;
    }
}
