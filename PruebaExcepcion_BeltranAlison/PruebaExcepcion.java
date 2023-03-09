import java.util.Scanner;
public class PruebaExcepcion {
    public static void main (String Args[]){
        Scanner lector = new Scanner(System.in);
        int num=10;
        int posicion=0;
        int numero;
        int array[]=new int [num];
        System.out.println("Al generar excepcion, volvera al menu");

            for (int i = 0; i<8; i++) {
                try {

                    System.out.println("Ingrese el número: ");
                    numero = lector.nextInt();
                    System.out.println("Agregar en determinada posicion: ");
                    posicion = lector.nextInt();
                    array[posicion] = numero;
                } catch (java.lang.ArrayIndexOutOfBoundsException Error) {
                    System.out.println("Se genero una excepcion al ingresar en una posicion fuera del array");
                }
            }
            for (int i=0;i<9;i++){
                try {
                    System.out.print(array[i] + ",");
                }catch (java.lang.ArrayIndexOutOfBoundsException Error) {
                    System.out.println("Se genero una excepcion");
                }
            }
        }
    }