class UseFinally{
    public static void generaExcepcion(int i){
        int t;
        int num[]={2,4,6};
        System.out.println("Recibiendo"+ what);
        try{
            switch(i){
                case 0: t=10/i; //division por cero
                break;
                case 1:num[4]=4; //genera un error
                break;
                case 2: return;
            }
        }
        catch(ArithmeticException exc){
            System.out.println("No puede dividir entre cero");
            return; //regresa desde catch
        }
        catch(ArrayIndexOutOfBoundsException exc){
            System.out.println("No hay elementos que coincidan");
        }
        finally{
            System.out.println("Ejecutando codigo de limpieza");
        }
    } //fin metodo
} //clase