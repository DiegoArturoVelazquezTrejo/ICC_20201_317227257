package app; 
import processing.core.PApplet;

// para compilar javac -cp ".:core.jar" Sketch.java
// para ejecutar java -cp ".:core.jar" Sketch
public class Sketch extends PApplet{

  public static void main(String[] args){
    PApplet.main("Sketch");
  }
  public void settings(){
    size(640,640);
  }
  public void setup(){
    fill(120,50,240);
    dibujaTablero();
  }
  public void draw(){
  }

  public void dibujaTablero(){
    int ancho = 80;
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 8; j++){
        if((i % 2 == 0 &&  j % 2 != 0) || (i % 2 != 0 && j %2 == 0)) {
          fill(0,0,0);
          rect(i*ancho, j * ancho, ancho, ancho); // 1
        }
        else if((i % 2 == 0 &&  j % 2 == 0) || (i % 2 != 0 && j %2 != 0 )) {
          fill(255,255,255);
          rect(i*ancho, j * ancho, ancho, ancho); // 0
        }
      }
    }
  }



}
