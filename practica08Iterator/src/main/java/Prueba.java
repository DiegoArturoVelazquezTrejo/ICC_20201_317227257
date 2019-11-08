public class Prueba{
  public static void main(String[] args){
    double[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    Matrix mat = new Matrix(array);
    for(Double dob : mat )
      System.out.println(dob);
  }
}
