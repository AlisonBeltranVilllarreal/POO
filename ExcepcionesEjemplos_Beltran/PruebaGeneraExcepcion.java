public class PruebaGeneraExcepcion {
    public static void main (String args[]){
        GeneraExcepcion2 objeto =new GeneraExcepcion2();
        try{ objeto.produceExcepcion();
        }
        catch (ArrayIndexOutOfBoundsException excep){
            System.out.println("Excepcion Generada en otro bloque");
        }
    }
}