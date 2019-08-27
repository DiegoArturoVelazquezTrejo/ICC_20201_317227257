import java.util.Scanner; 
import java.io.BufferedReader;
import java.io.InputStreamReader; 

public class ScannerEjercicio{

    public static void main(String args[]){


	Scanner sc = new Scanner(System.in);
	//int num1 = sc.nextInt();
	//int num2 = sc.nextInt();
	//System.out.print(num1+num2);


	InputStreamReader inputReader	= new InputStreamReader(System.in);
        BufferedReader buff = new BufferedReader(inputReader);

	String linea = "";
	String linea2 = ""; 
	try{
	    linea = buff.readLine().trim();
	    linea2 = buff.readLine().trim();
	}catch(Exception e){
	    System.out.print("Error"); 
	}
	int x, y = 0;
	try{
	    x = Integer.parseInt(linea);
	    y = Integer.parseInt(linea2);
	    System.out.print("La suma de los numeros es: " + (x+y)); 
	}catch(NumberFormatException e){
	    System.out.print("No es un número"); 
	} 
    }

}
