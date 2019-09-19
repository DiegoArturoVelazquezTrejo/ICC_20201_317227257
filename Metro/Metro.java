
/**
 * @author: Diego Arturo Velázquez Trejo
 * @date: 12 septiembre 2019
 * @version: 1.0
 */


public class Metro{
    private int numeroVagones;
    private String serie;

    /**
     * Método constructor del metro 
     * @param : Int -> Número de vagones, String -> No. de serie del metro 
     **/
    public Metro(int numero, String serie){
	this.numeroVagones = numero;
	this.serie = serie; 
    }
    /**
     * Setter para el número de vagones
     * @param : Int -> numero de vagones
     **/
    public void setNumeroVagones(int numero){
	this.numeroVagones = numero; 
    }
    /**                                                                                                                               
     * Setter para el número de serie                                                                                               
     * @param : String -> No. de serie                                                                                              
     **/
    public void setSerie(String serie){
	this.serie = serie; 
    }
    /**
     * Getter para el número de vagones
     * @return : int -> No. de vagones
     **/
    public int getNumeroVagones(){
	return numeroVagones; 
    }
    /**
     * Getter para el número de serie
     * @return : String -> No. de serie
     **/
    public String getNumeroDeSerie(){
	return serie; 
    }
    /**
     * Método toString
     * @return : String del objeto
     **/
    @Override
    public String toString(){
	String cadena = "";
	cadena = "Número de serie: "+getNumeroDeSerie()+" Número de vagones: "+getNumeroVagones();
	return cadena; 
    }
    /**
     * Método Equals
     * @return : true Si son equivalentes o false si son iguales
     **/
    @Override
    public boolean equals(Object o){
	if(!(o instanceof Metro)) return false;
	Metro metro = (Metro) o;
	return (metro.getNumeroDeSerie() == this.serie) && (metro.getNumeroVagones() == this.numeroVagones); 
    }
    
}
