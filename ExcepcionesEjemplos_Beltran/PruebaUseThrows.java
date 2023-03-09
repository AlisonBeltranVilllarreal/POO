public class PruebaUseThrows {
    public static void main(String args[]){
        char ch;
        try{
            ch=UseThrows.prompt("Escriba una letra");
        }
        catch( java.io.IOException exc){
            System.out.println("Excepcion de entrada-Salida");
            ch='X';
        }
    } // main
}