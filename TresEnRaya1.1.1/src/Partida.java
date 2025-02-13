/**
 * Partida.java
 * ccatalan (01/2018) 
 *   
 */

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *  Partida de juego de tablero
 * 
 */
public class Partida {
  public enum ResultadoJugada {VALIDA, INVALIDA, HAY_LINEA_O_DIAGONAL, 
                               HAY_EMPATE};
  private Tablero tablero;
  private Regla reglas[];
  private Ficha turno;
  private boolean finalizada;
  
  /**
   *  Construye una partida 
   * 
   */  
  public Partida(Regla reglas[], int filas, int columnas) {
    this.reglas = reglas;
    finalizada = false;
    tablero = new Tablero(filas, columnas);
    turno = Ficha.CIRCULO; 
  }

  /**
   *  Construye una partida de un fichero
   * 
   */   
  public Partida(Regla reglas[], String nombreFichero) throws Exception {
    this.reglas = reglas;
    finalizada = false;    
    recuperar(nombreFichero);
  }
  
  /**
   *  Devuelve ficha que tiene turno
   * 
   */    
  public Ficha devuelveTurno() {
    return turno;  
  }  
  
  /**
   *  Devuelve si partida está finalizada
   * 
   */    
  public boolean finalizada() {
    return finalizada;
  }  
  
  /**
   *  Devuelve verdadero si jugada es válida o falso en caso contrario
   * 
   */  
  private boolean esJugadaValida(Posicion posicion) {
    for(Regla regla: reglas) {
      if (! regla.seCumple(tablero, posicion)) {
        return false;
      }
    } 
    return true;    
  }   
  
  /**
   *  Pone siguiente ficha del siguiente turno
   * 
   */   
  private void siguienteTurno() {
    if (turno == Ficha.CIRCULO) {
      turno = Ficha.CRUZ;    
    } else {
      turno = Ficha.CIRCULO;
    }
    // o también
    //turno = (turno == Ficha.CIRCULO ? Ficha.CRUZ : Ficha.CIRCULO);
  }  
  
  /**
   *  Pone una ficha del tablero.
   *  Devuelve HAY_LINEA_O_DIAGONAL, HAY_EMPATE, JUGADA_INVALIDA o JUGADA_VALIDA
   *  
   */ 
  public ResultadoJugada ponerFicha(Posicion posicion) {
    if ( ! esJugadaValida(posicion)) {
      return ResultadoJugada.INVALIDA;
    }
        
    tablero.ponerFicha(turno, posicion);
      
    if (tablero.hayLineaODiagonal()) {
      finalizada = true;
      return ResultadoJugada.HAY_LINEA_O_DIAGONAL;
    }
    else if (tablero.hayEmpate()) {
      finalizada = true;
      return ResultadoJugada.HAY_EMPATE;
    }
    
    siguienteTurno();

    return ResultadoJugada.VALIDA;
  }
  
  /**
   *  Devuelve el tablero como cadena de caracteres
   *
   */ 
  public String devuelveTableroString() {
    return tablero.devuelveTableroString();
  }  
  
  /**
   *  Guarda en fichero la partida actual
   * 
   */   
  public void guardar(String nombreFichero) throws Exception {
    PrintWriter fichero = 
      new PrintWriter(new BufferedWriter(new FileWriter(nombreFichero)));    
    
    fichero.println(turno.devuelveSimbolo());
    
    tablero.guardar(fichero);    
    fichero.close();
  }
  
  /**
   *  Recupera una partida de fichero
   * 
   */   
  private void recuperar(String nombreFichero) throws Exception {
    Scanner fichero = new Scanner(new FileInputStream(nombreFichero));
    turno = Ficha.nueva(fichero);

    tablero = new Tablero(fichero);
    fichero.close();
  }
}
