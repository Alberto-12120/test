/**
 *  TresEnRayaTest.java
 *  ccatalan (01/2018)
 * 
 */

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

/**
 *  Clase de test del Juego Tres en raya
 * 
 */
public class TresEnRayaTest {
  /**
   *  Método main
   * 
   */   
  public static void main(String[] args) {
    System.out.println(TresEnRaya.VERSION);  
    TresEnRaya tresEnRaya = new TresEnRaya();
    
    tresEnRaya.nuevaPartida();
/*    
    System.out.println("Juega " + tresEnRaya.devuelveTurno());    
    System.out.println(tresEnRaya.ponerFicha(new Posicion(1, 1)));
    System.out.println(tresEnRaya.devuelveTableroString());
    
    System.out.println("Juega " + tresEnRaya.devuelveTurno());    
    System.out.println(tresEnRaya.ponerFicha(new Posicion(1, 1)));
    System.out.println(tresEnRaya.devuelveTableroString());
    
    System.out.println("Juega " + tresEnRaya.devuelveTurno());    
    System.out.println(tresEnRaya.ponerFicha(new Posicion(0, 1)));
    System.out.println(tresEnRaya.devuelveTableroString());
    
    System.out.println("Juega " + tresEnRaya.devuelveTurno());    
    System.out.println(tresEnRaya.ponerFicha(new Posicion(0, 0)));
    System.out.println(tresEnRaya.devuelveTableroString());
    
    System.out.println("Juega " + tresEnRaya.devuelveTurno());    
    System.out.println(tresEnRaya.ponerFicha(new Posicion(0, 2)));
    System.out.println(tresEnRaya.devuelveTableroString());
 
    System.out.println("Juega " + tresEnRaya.devuelveTurno());    
    System.out.println(tresEnRaya.ponerFicha(new Posicion(2, 2)));
    System.out.println(tresEnRaya.devuelveTableroString());
 */
    System.out.println("Juega " + tresEnRaya.devuelveTurno());    
    System.out.println(tresEnRaya.ponerFicha(new Posicion(1, 1)));
    System.out.println(tresEnRaya.devuelveTableroString());
    
    System.out.println("Juega " + tresEnRaya.devuelveTurno());    
    System.out.println(tresEnRaya.ponerFicha(new Posicion(1, 1)));
    System.out.println(tresEnRaya.devuelveTableroString());
    
    System.out.println("Juega " + tresEnRaya.devuelveTurno());    
    System.out.println(tresEnRaya.ponerFicha(new Posicion(0, 0)));
    System.out.println(tresEnRaya.devuelveTableroString());
    
    System.out.println("Juega " + tresEnRaya.devuelveTurno());    
    System.out.println(tresEnRaya.ponerFicha(new Posicion(0, 1)));
    System.out.println(tresEnRaya.devuelveTableroString());
    
    System.out.println("Juega " + tresEnRaya.devuelveTurno());    
    System.out.println(tresEnRaya.ponerFicha(new Posicion(0, 2)));
    System.out.println(tresEnRaya.devuelveTableroString());

    try {
      tresEnRaya.guardarPartida("partida.dat");
      System.out.println("Partida guardada");
    } catch(Exception e) {
      System.out.println("Error al guardar partida");
      if (TresEnRaya.esModoDebug()) {
        e.printStackTrace();
      }
      System.exit(1);
    }
        
    try {
      tresEnRaya.recuperarPartida("partida.dat");
      System.out.println("Partida recuperada");
//      System.out.println(tresEnRaya.devuelveTableroString());
    } catch(FileNotFoundException e) {
      System.out.println("Error al recuperar partida: Fichero " + 
                          "partida.dat" + " no existe");
      if (TresEnRaya.esModoDebug()) {
        e.printStackTrace();
      }
    } catch(InputMismatchException e) {
      System.out.println("Error al recuperar partida: Fichero " + 
                          "partida.dat" + " incorrecto");
      if (TresEnRaya.esModoDebug()) {
        e.printStackTrace();
      }
    } catch(Exception e) {
      System.out.println("Error al recuperar partida");
      if (TresEnRaya.esModoDebug()) {
        e.printStackTrace();
      }
    } 
    
    System.out.println("Juega " + tresEnRaya.devuelveTurno());    
    System.out.println(tresEnRaya.ponerFicha(new Posicion(2, 1)));
    System.out.println(tresEnRaya.devuelveTableroString());
  }     
}
