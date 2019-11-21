import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;

/**
* Clase Escritura para escribir sobre un archivo
* @author: Diego Arturo Velázquez Trejo
* @version : 1.0
**/

public class Escritura{

  /* Método para escribir dentro de un mensaje */
  public void escribir(String archivoF){
    String archivo = getClass().getResource("numeros.csv").getPath();
    Path nuevo_archivo = Paths.get(archivoF);
    String resultado = "";
    try{
      List<String> lineas = Files.readAllLines(Paths.get(archivo));
      for(String string : lineas){

        String row[] = string.split(",");
        double x1 = Double.parseDouble(row[0]);
        double x2 = Double.parseDouble(row[1]);

        // Definiendo las funciones anónimas
        Transformacion tangente   = (double x) ->  {return Math.tan(x); };
        Transformacion normaVec = (double x) ->  {return Math.sqrt(x); };

        // Aplicando la transfromación a los números
        double x = normaVec.transformar(x1 * x1 + x2 * x2);
        double y = tangente.transformar(x2/x1);

        resultado = resultado + x+","+y+"\n";
      }
      // Escribiendo en un archivo 
      Files.write(nuevo_archivo, resultado.getBytes());
    }catch(IOException e){
      System.out.println(e.getMessage());
    }
  }


  @FunctionalInterface
  public interface Transformacion{
    /**
    * Método para transformar una coordenada de tipo rectangular a tipo polar
    * @param : double
    * @param : double
    * @return : double
    **/
    public double transformar(double x);
  }

  /* Método main para la clase Escritura*/
  public static void main(String agrs[]){
    Escritura es = new Escritura();
    es.escribir("coordenadasPolares.csv");
  }

}
