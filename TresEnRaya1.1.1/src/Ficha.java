/**
 * Ficha.java
 * ccatalan (01/2018) 
 *   
 */

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *  Ficha del tablero de juego
 * 
 */
public enum Ficha { 
  VACIA("-"), CRUZ ("x"), CIRCULO("o");
  private final String simbolo;

  /**
   *  Construye una ficha
   * 
   */  
  Ficha(String simbolo) {
    this.simbolo = simbolo;
  }
  
  /**
   *  Devuelve símbolo que representa a la ficha
   * 
   */   
  public static Ficha nueva(Scanner scanner) throws Exception {
    String s = scanner.next(
      Pattern.compile(VACIA.devuelveSimbolo() + "|" +
                      CRUZ.devuelveSimbolo() + "|" +
                      CIRCULO.devuelveSimbolo()));

    if (s.equals(CRUZ.devuelveSimbolo())) {
      return CRUZ;    
    } else if (s.equals(CIRCULO.devuelveSimbolo())) {
      return CIRCULO;  
    } else {
      return VACIA;
    }
  }
  
  /**
   *  Devuelve símbolo que representa a la ficha
   * 
   */   
  public String devuelveSimbolo() {
    return simbolo;    
  }
}