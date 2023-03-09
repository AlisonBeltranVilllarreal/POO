import java.util.Scanner;

public class PiscinaTest {
    public static void main(String[] args) throws Exception{
        Scanner lector= new Scanner(System.in);
        int nivel, cantidad, opcion;
        System.out.println("Ingresa el nivel maximo de la piscina: ");
        nivel =lector.nextInt();
        Piscina piscina = new Piscina(nivel);
        do{
            System.out.println("1.-llenar");
            System.out.println("2.-Vaciar");
            System.out.println("3.-Ver Nivel");
            System.out.println("0.-Salir");
            System.out.println("Seleccionar una opcion: ");
            opcion=lector.nextInt();
            switch (opcion){
                case 0:
                System.out.println("Fin del Programa...");
               break;

               case 1:
               try{
               System.out.println("Cantidad a llenar:");
               cantidad=lector.nextInt();
               piscina.llenar(cantidad);
               }catch (PiscinaNivelException e){
                   System.out.println(e.toString()+ " "+ e.nivel);
               }
               break;

               case 2:
               try{
               System.out.println("Cantidad a vaciar");
               cantidad=lector.nextInt();
               piscina.vaciar(cantidad);
               }catch (PiscinaNivelException e){
                   System.out.println(e.toString()+ " "+ e.nivel);
               }
               break;
               default:
               System.out.println("Opcion Invalida...");

               case 3:
               System.out.println("El nivel es: " + piscina.getNivel());
        

            }

        }while(opcion!=0);
        
    }


}
    