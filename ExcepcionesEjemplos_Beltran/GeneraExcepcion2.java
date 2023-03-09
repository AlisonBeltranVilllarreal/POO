public class GeneraExcepcion2 {
    void produceExcepcion(){
        int numero[]=new int[5];
        System.out.println("Tratando de acceder a una posicion fuera del vector");
        numero[7]=0;
    }
}