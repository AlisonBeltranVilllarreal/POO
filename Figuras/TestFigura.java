import java.util.Scanner;

public class TestFigura {
    public static void main (String[] args){
        Circulo circulo = new Circulo();
        Triangulo triangulo = new Triangulo();
        Scanner lector = new Scanner (System.in);
        double base, altura, lado, radio, diametro;
        System.out.println("Triangulo");
        System.out.println("Ingresa la base: ");
        base = lector.nextDouble();
        System.out.println("Ingresa la altura: ");
        altura = lector.nextDouble();
        System.out.println("El area del triangulo es: "+ triangulo.calcularArea(base, altura));
    }
    
}
