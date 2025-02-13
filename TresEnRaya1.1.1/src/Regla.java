/**
 * Regla.java
 * ccatalan (01/2018) 
 *   
 */

/**
 *  Regla del juego
 * 
 */
public abstract class Regla {
  /**
   *  Devuelve verdadero si se cumple la regla o falso en caso contrario
   * 
   */   
  public abstract boolean seCumple(Tablero tablero, Posicion posicion);    
}
