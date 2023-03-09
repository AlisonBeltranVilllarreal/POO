public class ExcepcionesAnidadas {
    public static void main(String args[]){
        int num[]= {4,8,16,32,64,128,256,512};
        int den[]= {2,0,4,4,0,8};
        try{
            for (int i=0;i<num.length;i++){
                try{
                    System.out.println(num[i]+"/"+den[i]+"="+ num[i]/den[i]);
                }
                catch (ArithmeticException Excep){
                    System.out.println("Fuera de limite"+ i);
                }
            }
        } //try externo
        catch (Throwable Excep){
            System.out.println("Ocurrio una excepcion fatal");
        }
        System.out.println("El programa puede continuar aqui");
    }
}