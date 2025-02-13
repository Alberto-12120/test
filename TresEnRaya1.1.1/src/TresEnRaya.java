/**
 * TresEnRaya.java
 * 
 * Versión 0 ccatalan (01/2018)
 *  - Esqueleto de código para jugar, guardar y recuperar partida
 *
 * Versión 1.0 ccatalan (01/2018)
 *  - Permite jugar una partida
 *
 * Versión 1.1 ccatalan (01/2018)
 *  - Añadido guardar y recuperar partida en fichero binario
 *
 * Versión 1.1.1 ccatalan (01/2018)
 *  - Modificado guardar y recuperar partida, ahora en fichero de texto
 *  - Modo debug
 * 
 */ 

/**
 *  Juego Tres en raya
 * 
 */
public class TresEnRaya {
  public static String VERSION = "Tres en raya 1.1.1";    
  private Partida partida;
  private Regla reglas[];
  private static boolean modoDebug = true;
  
  /**
   *  Construye juego tres en raya
   * 
   */
  public TresEnRaya() {
     reglas = new Regla[] { new PosicionEstaLibre(),
                            new PosicionEstaDentroTablero() }; 
  }
  
  /**
   *  Empieza nueva partida
   * 
   */ 
  public void nuevaPartida() {
    partida = new Partida(reglas, 3, 3);  
  }
  
  /**
   *  Recupera una partida anterior de fichero
   * 
   */ 
  public void recuperarPartida(String nombreFichero) throws Exception {
    partida = new Partida(reglas, nombreFichero);  
  }  
  
  /**
   *  Guarda partida actual
   * 
   */
  public void guardarPartida(String nombreFichero) throws Exception {
    partida.guardar(nombreFichero);    
  }
   
  /**
   *  Acaba partida actual
   * 
   */ 
  public void acabarPartida() {
      
  }

  /**
   * Pone ficha en tablero de juego
   * 
   */
  public Partida.ResultadoJugada ponerFicha(Posicion posicion) { 
    return partida.ponerFicha(posicion);
  }
  
  /**
   *  Devuelve el tablero como cadena de caracteres
   *
   */  
  public String devuelveTableroString() {
    return partida.devuelveTableroString();
  }
  
  /**
   *  Devuelve verdadero si partida está finalizada o falso en caso contrario
   * 
   */      
  public boolean partidaFinalizada() {
    return partida.finalizada();  
  }
  
  /**
   *  Devuelve ficha que tiene turno
   * 
   */    
  public Ficha devuelveTurno() {
    return partida.devuelveTurno();  
  }   

  /**
   *  Devuelve verdadero si aplicación está en modo debug o falso en caso
   *  contrario
   * 
   */  
  public static boolean esModoDebug() {
    return modoDebug;
  }
}
