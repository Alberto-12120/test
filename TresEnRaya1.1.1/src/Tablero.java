/**
 * Tablero.java
 * ccatalan (01/2018) 
 *   
 */

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;

/**
 *  Tablero de juego
 * 
 */
public class Tablero implements Serializable {
  private Ficha fichas[][];
  private int numFichas;

 /**
  *  Construye el tablero de juego
  *  
  */   
  public Tablero(int filas, int columnas) {
    fichas = new Ficha[filas][columnas];
    inicializar();
  }
  
 /**
  *  Construye el tablero de juego de un fichero
  *  
  */   
  public Tablero(Scanner scanner) throws Exception {
    fichas = new Ficha[scanner.nextInt()][scanner.nextInt()]; 
    for (int f = 0; f < fichas.length; f++) {
      for (int c = 0; c < fichas[0].length; c++) {
        Ficha ficha = Ficha.nueva(scanner);
        fichas[f][c] = ficha;
        if (ficha.equals(Ficha.CIRCULO) || ficha.equals(Ficha.CRUZ)) {
          numFichas++;    
        }
      }
    }
  }  
  
 /**
  *  Inicia tablero con posiciones vacías
  *  
  */  
  private void inicializar() {
    for (int f = 0; f < fichas.length; f++) {
      for (int c = 0; c < fichas[0].length; c++) {
        fichas[f][c] = Ficha.VACIA;
      }
    }
    numFichas = 0;
  }  

 /**
  *  Guarda tablero en un fichero de texto
  *  
  */  
  public void guardar(PrintWriter pw) {
    pw.println(fichas.length + " " + fichas[0].length);
    for (int f = 0; f < fichas.length; f++) {
      for (int c = 0; c < fichas[0].length; c++) {
        pw.print(fichas[f][c].devuelveSimbolo() + " ");
      }
      pw.println();
    }
  }  
    
  /**
   *  Devuelve número de filas del tablero
   *  
   */  
  public int devuelveNumFilas() {
    return fichas.length;
  }

  /**
   *  Devuelve número de columnas del tablero
   *  
   */   
  public int devuelveNumColumnas() {
    return fichas[0].length;
  }  
  
  /**
   *  Devuelve verdadero si posición está en tablero, o falso en caso contrario
   *  
   */  
  public boolean posicionEstaDentro(Posicion posicion) {
    int fila = posicion.devolverFila();
    int columna = posicion.devolverColumna();
      
    return (fila >= 0) && (fila < devuelveNumFilas()) && 
           (columna >= 0) && (columna < devuelveNumColumnas()); 
  }
  
  /**
   *  Pone una ficha del tablero
   *  
   */   
  public void ponerFicha(Ficha ficha, Posicion posicion) {
    if (posicionEstaDentro(posicion)) {
      fichas[posicion.devolverFila()][posicion.devolverColumna()] = ficha;
      numFichas++;
    }
  }
  
  /**
   *  Devuelve la ficha del tablero
   *  
   */  
  public Ficha devolverFicha(Posicion posicion) {
    if (posicionEstaDentro(posicion)) {
      return fichas[posicion.devolverFila()][posicion.devolverColumna()];    
    }
    return Ficha.VACIA;
  }
  
  /**
   *  Devuelve el tablero como cadena de caracteres
   *
   */ 
  public String devuelveTableroString() {
    String s = "";
    for (int f = 0; f < fichas.length; f++) {
      for (int c = 0; c < fichas[0].length; c++) {
        s = s + fichas[f][c].devuelveSimbolo() + " ";
      }
      s = s + '\n';
    }
    return s;
  }   
 
  /**
   *  Devuelve verdadero si hay diagonal descendente o falso en caso contrario
   * 
   */   
  private boolean hayDiagonalDescendente() {
    // Solución solamente válida para Tres en raya!!  
    return ((fichas[0][0] == Ficha.CRUZ) &&
            (fichas[1][1] == Ficha.CRUZ) && 
            (fichas[2][2] == Ficha.CRUZ)) ||
            ((fichas[0][0] == Ficha.CIRCULO) &&
            (fichas[1][1] == Ficha.CIRCULO) && 
            (fichas[2][2] == Ficha.CIRCULO));
  }

  /**
   *  Devuelve verdadero si hay diagonal ascendente o falso en caso contrario
   * 
   */   
  private boolean hayDiagonalAscendente() {
    // Solución solamente válida para Tres en raya!!  
    return ((fichas[2][0] == Ficha.CRUZ) && 
            (fichas[1][1] == Ficha.CRUZ) && 
            (fichas[0][2] == Ficha.CRUZ)) ||
            ((fichas[2][0] == Ficha.CIRCULO) &&
            (fichas[1][1] == Ficha.CIRCULO) && 
            (fichas[0][2] == Ficha.CIRCULO));
  }
  
  /**
   *  Devuelve verdadero si hay línea horizontal o falso en caso contrario
   * 
   */   
  private boolean hayLineaHorizontal() {
    // Solución solamente válida para Tres en raya!!  
    return ((fichas[0][0] == Ficha.CRUZ) &&
            (fichas[0][1] == Ficha.CRUZ) &&
            (fichas[0][2] == Ficha.CRUZ)) ||
           ((fichas[1][0] == Ficha.CRUZ) &&
            (fichas[1][1] == Ficha.CRUZ) &&
            (fichas[1][2] == Ficha.CRUZ)) || 
           ((fichas[2][0] == Ficha.CRUZ) &&
            (fichas[2][1] == Ficha.CRUZ) &&
            (fichas[2][2] == Ficha.CRUZ)) ||
           ((fichas[0][0] == Ficha.CIRCULO) &&
            (fichas[0][1] == Ficha.CIRCULO) &&
            (fichas[0][2] == Ficha.CIRCULO)) ||
           ((fichas[1][0] == Ficha.CIRCULO) &&
            (fichas[1][1] == Ficha.CIRCULO) &&
            (fichas[1][2] == Ficha.CIRCULO)) || 
           ((fichas[2][0] == Ficha.CIRCULO) &&
            (fichas[2][1] == Ficha.CIRCULO) &&
            (fichas[2][2] == Ficha.CIRCULO)); 
    }  
  
  /**
   *  Devuelve verdadero si hay línea Vertical o falso en caso contrario
   * 
   */   
  private boolean hayLineaVertical() {
    // Solución solamente válida para Tres en raya!!  
    return ((fichas[0][0] == Ficha.CRUZ) &&
            (fichas[1][0] == Ficha.CRUZ) &&
            (fichas[2][0] == Ficha.CRUZ)) ||
           ((fichas[0][1] == Ficha.CRUZ) &&
            (fichas[1][1] == Ficha.CRUZ) &&
            (fichas[2][1] == Ficha.CRUZ)) || 
           ((fichas[0][2] == Ficha.CRUZ) &&
            (fichas[1][2] == Ficha.CRUZ) &&
            (fichas[2][2] == Ficha.CRUZ)) ||
           ((fichas[0][0] == Ficha.CIRCULO) &&
            (fichas[1][0] == Ficha.CIRCULO) &&
            (fichas[2][0] == Ficha.CIRCULO)) ||
           ((fichas[0][1] == Ficha.CIRCULO) &&
            (fichas[1][1] == Ficha.CIRCULO) &&
            (fichas[2][1] == Ficha.CIRCULO)) || 
           ((fichas[0][2] == Ficha.CIRCULO) &&
            (fichas[1][2] == Ficha.CIRCULO) &&
            (fichas[2][2] == Ficha.CIRCULO)); 
  }
    
  /**
   *  Devuelve verdadero si hay linea o diagonal, o falso en caso contrario
   * 
   */   
  public boolean hayLineaODiagonal() {      
      return hayDiagonalDescendente() || 
             hayDiagonalAscendente() ||
             hayLineaHorizontal() || 
             hayLineaVertical();
  }
  
  /**
   *  Devuelve si hay empate
   * 
   */   
  public boolean hayEmpate() {
    return (numFichas == fichas.length * fichas[0].length);
  }  
}
