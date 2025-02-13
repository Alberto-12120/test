/**
 * PosicionEstaDentroTablero.java
 * ccatalan (01/2018) 
 *   
 */

/**
 *  Regla de posición está dentro del tablero
 * 
 */
public class PosicionEstaDentroTablero extends Regla {
  /**
   *  Devuelve verdadero si se cumple la regla o falso en caso contrario
   * 
   */     
  public boolean seCumple(Tablero tablero, Posicion posicion) {
    return tablero.posicionEstaDentro(posicion);
  }  
}
