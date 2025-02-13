/**
 * PosicionEstaLibre.java
 * ccatalan (01/2018) 
 *   
 */

/**
 *  Regla de posición del tablero está libre
 * 
 */
public class PosicionEstaLibre extends Regla {
  /**
   *  Devuelve verdadero si se cumple la regla o falso en caso contrario
   * 
   */    
  public boolean seCumple(Tablero tablero, Posicion posicion) {
    return (tablero.devolverFicha(posicion) == Ficha.VACIA); 
  }      
}
