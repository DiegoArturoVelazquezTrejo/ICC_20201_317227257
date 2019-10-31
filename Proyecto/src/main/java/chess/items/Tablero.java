package chess.items;
import chess.pieces.*;
/**
* Clase  Tablero para el tablero del juego ajedrez.
* @author : Diego Arturo Velázquez Trejo
* @version : 1.0
**/
public class Tablero{

  /* Tamaño del tablero 8 */
  public int SIZE = 8;
  /* Matriz de piezas */
  public Pieza[][] matriz;
  /* Atributo de la clase  */
  private static Tablero instance = null;

  /* Constructor privado por omisión */
  private Tablero(){
    this.matriz = new Pieza[SIZE][SIZE];
    /* Colocando las torres en el tablero */
    this.matriz[0][0]           = new Torre(new Posicion(0,0), ColorEnum.NEGRO);
    this.matriz[0][SIZE-1]      = new Torre(new Posicion(0,SIZE-1), ColorEnum.NEGRO);
    this.matriz[SIZE-1][0]      = new Torre(new Posicion(SIZE-1,0), ColorEnum.BLANCO);
    this.matriz[SIZE-1][SIZE-1] = new Torre(new Posicion(SIZE-1,SIZE-1), ColorEnum.BLANCO);

    /* Colocando los caballos en el tablero */
    this.matriz[0][1]           = new Caballo(new Posicion(0,1), ColorEnum.NEGRO);
    this.matriz[0][SIZE-2]      = new Caballo(new Posicion(0,SIZE-2), ColorEnum.NEGRO);
    this.matriz[SIZE-1][1]      = new Caballo(new Posicion(SIZE-1,1), ColorEnum.BLANCO);
    this.matriz[SIZE-1][SIZE-2] = new Caballo(new Posicion(SIZE-1,SIZE-2), ColorEnum.BLANCO);

    /* Colocando los alfiles en el tablero */
    this.matriz[0][2]           = new Alfil(new Posicion(0,1), ColorEnum.NEGRO);
    this.matriz[0][SIZE-3]      = new Alfil(new Posicion(0,SIZE-3), ColorEnum.NEGRO);
    this.matriz[SIZE-1][2]      = new Alfil(new Posicion(SIZE-1,2), ColorEnum.BLANCO);
    this.matriz[SIZE-1][SIZE-3] = new Alfil(new Posicion(SIZE-1,SIZE-3), ColorEnum.BLANCO);

    /* Colocando los reyes y reinas en el tablero */
    this.matriz[0][3]           = new Rey(new Posicion(0,1), ColorEnum.NEGRO);
    this.matriz[0][SIZE-4]      = new Reina(new Posicion(0,SIZE-4), ColorEnum.NEGRO);
    this.matriz[SIZE-1][3]      = new Reina(new Posicion(SIZE-1,3), ColorEnum.BLANCO);
    this.matriz[SIZE-1][SIZE-4] = new Rey(new Posicion(SIZE-1,SIZE-4), ColorEnum.BLANCO);

    /* Colocando los peones en el tablero */
    for(int i = 0; i < SIZE; i++){
      this.matriz[1][i]      = new Peon(new Posicion(1,i), ColorEnum.NEGRO);
      this.matriz[SIZE-2][i] = new Peon(new Posicion(1,i), ColorEnum.BLANCO);
    }

    /* Colocando piezas vacías en las demás casillas */
    for(int i = 2; i < 6; i++){
      for(int j = 0; j < SIZE; j++){
        this.matriz[i][j]      = new Empty(new Posicion(i,j), ColorEnum.NONE);
        this.matriz[i][j]      = new Empty(new Posicion(i,j), ColorEnum.NONE);
      }
    }

  }
  /* Método para que nos regrese siempre la instancia del mismo tablero */
  public static Tablero getInstance(){
    if(instance == null)
      instance = new Tablero();
    return instance;
  }
  /* Método toString de la clase Tablero */
  @Override
  public String toString(){
    String result = "";
    for(int i = 0; i < SIZE; i++){
      for(int j = 0; j <SIZE; j++){
        result += " "+ matriz[i][j] +" ";
      }
      result+= "\n";
    }
    return result;
  }
  /** Método para obtener una pieza del tablero
  * @param : coordenada en x
  * @param : coordenada en y
  * @return : Pieza
  **/
  public Pieza getPieza(Posicion posicion ){
    //if(posicion.estaFueraDelTablero(SIZE)) return null;
    return this.matriz[posicion.getX()][posicion.getY()];
  }

}
