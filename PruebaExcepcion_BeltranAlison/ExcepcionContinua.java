public class ExcepcionContinua {
    static void divide(){
        int num[]={4,8,16,32,64,128,256};
        int den[]={2,0,4,4,0,8};

        for(int i=0;i<num.length;i++){
            try{System.out.println(num[i]+ "/" + "="+num[i]/den[i]);
        }
        catch(java.lang.ArithmeticException exception){
            System.out.println("Dividiendo por cero");
        }
        catch(java.lang.ArrayIndexOutOfBoundsException excepcion){
            System.out.println("Error al acceder el vector");
        }
    }
  }
}
