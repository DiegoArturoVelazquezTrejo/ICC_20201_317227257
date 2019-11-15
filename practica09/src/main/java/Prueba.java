import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;

public class Prueba{


  public static void main(String args[]){
    try{

      List<String> lines = Files.readAllLines(Paths.get("hola2.txt"));
      Funcion m = (String p ) -> {System.out.println(p.toLowerCase()); };

      System.out.println(lines);
      /* Mapeando una función anónima a los renglones de la lista lines */
      lines.forEach(m::funcion);

      /*
      List<String> lines = Files.readAllLines(Paths.get("hola2.csv"));

      for(String string : lines){
        String row[] = string.split(",");
        System.out.println("X: "+row[0]+", Y: "+row[1]);
      }

      */

    }catch(IOException e){
      System.out.println(e.getMessage());
    }
  }

  /**
  * Interface funcional para definir la función anónima
  **/
  @FunctionalInterface
  public interface Funcion{
    /** Función anónima funcion
    * @param : String
    **/
    public void funcion(String m);
  }

}
