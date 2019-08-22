public class HeyJude{
    
    public static void main(String[] args){
	String HEY = "Hey Jude ";
	String DON = "don't ";
	String MAK = "make it bad.";
	String BEA = "be afraid.";
	String LET = "let me down.";
	String TAK = "Take a sad song and make it better.";
	String YOW = "You were made to go out and get her.";
	String YOH = "You have found her, now go and get her.";
	String REM = "Remember to ";
	String LEH = "let her into you heart.";
	String LES = "let her into your skin.";
	String THE = "Then you ";
	String CAN = "can start ";
	String BEG = "begin ";
	String TOM = "to make it better ";
	String BET = "better ";
	String NA  = "na ";
	String THEMIN = "The minute ";
	String AND = "And anytime you feel the pain, hey Jude, refrain,\n"
	    + "Don’t carry the world upon your shoulders.\n"
	    + "For well you know that it’s a fool who plays it cool\n"
	    + "By making his world a little colder.";
	String SOL = "So let it out and let it in, hey Jude, begin,\n"
	    + "You’re waiting for someone to perform with.\n"
	    + "And don’t you know that it’s just you, hey jude, you’ll do,\n"
	    + "The movement you need is on your shoulder.";

	
        String[] coro = {HEY, DON, MAK, TAK, REM, LEH, THE, CAN, TOM};
	String[] p1 = {HEY, DON, BEA, YOW,THEMIN, LES, THE, BEG, TOM};
	String[] p2 = {AND}; // NA seis veces
	String[] p3 = {HEY, DON, LET, YOH, REM, LEH, THE, CAN, TOM}; 
	String[] p4 = {SOL, NA, NA, NA, NA, NA, NA}; // NA seis veces 
	String[] p5 = {HEY, DON, MAK, TAK, REM, LES, THE, BEG, TOM}; // better cinco veces
	String[] p6 = {NA,NA ,NA, NA, NA, NA, NA, HEY}; // Repetir dos veces (NA 9 veces, HEY)
	
	String[][] parrafos = {coro, p1, p2, p3, p4, p5, p6};

	for(int i = 0; i < parrafos.length; i++){
	    if(i < 3)
		imprimirParrafo(parrafos[i], 1);
	    else
		imprimirParrafo(parrafos[i], 2); 
	}
     
    }
     //Parámetros del método: String[], el numerito del switch                                                                     
     public static void imprimirParrafo(String[] parrafo, int numerito){
         switch(numerito){
	     case 1:
		 System.out.print("\n");
		 int a = 0;
		 while(a < parrafo.length){
		     if(parrafo[a].charAt(parrafo[a].length() -1) != '.')
			 System.out.print(parrafo[a]);
		     else
			 System.out.print(parrafo[a]+"\n");
		     a++;
		 }
		 break;

	       case 2:
		 System.out.print("\n");
	         for(int i = 0; i < parrafo.length; i++){
		     if(parrafo[i].charAt(parrafo[i].length() -1) != '.')
			 System.out.print(parrafo[i]);
		     else
			 System.out.print(parrafo[i]+"\n");
		 }	 
		 break;
	 }
     }

}
