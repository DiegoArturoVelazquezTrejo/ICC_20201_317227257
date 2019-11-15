import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;
import processing.core.PApplet;
import processing.core.PImage;


public class Practica9 extends PApplet{


    public static void main(String[] args) {
      PApplet.main("Practica9");
    }

    @Override
    public void settings(){
        size(800,800);
    }

    @Override
    public void setup(){
      String archivo = getClass().getResource("numeros.csv").getPath();
      dibujar(archivo);
    }

    @Override
    public void draw(){
    }

    public void dibujar(String archivo ){
      try{
        float radio = 10;
        List<String> lines = Files.readAllLines(Paths.get(archivo));
        for(String string : lines){
          String row[] = string.split(",");
          ellipse(Float.parseFloat(row[0]), Float.parseFloat(row[1]), radio, radio);
          System.out.println("X: "+row[0]+", Y: "+row[1]);
        }

      }catch(IOException e){
        System.out.println(e.getMessage());
      }
    }

}
