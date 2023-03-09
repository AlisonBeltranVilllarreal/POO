import java.util.Scanner;

public class Cliente extends Persona {

    Vendedor vendedor;
    Productos productos;
    public String rfc;
    public String domicilio;
    public static Scanner lector = new Scanner(System.in);



    public Cliente(String nombre, String apePaterno, String apeMaterno, Fecha fechadeNacimiento, String rfc,
                   String domicilio) {
        super(nombre, apePaterno, apeMaterno, fechadeNacimiento);
        this.rfc = rfc;
        this.domicilio = domicilio;
    }
    
    
    public static Cliente leerCliente() {

        String nombre, apePaterno, apeMaterno, rfc, domicilio;
        Fecha fechadeNacimiento;
        int dia, mes, anio;

        System.out.println("\n Agregar Cliente");
        System.out.println("Nombre: ");
        nombre = lector.next();
        System.out.println("Apellido Paterno: ");
        apePaterno = lector.next();
        System.out.println("Apellido Materno: ");
        apeMaterno = lector.next();
        System.out.println("Fecha Nacimiento: ");
        System.out.println("Dia:  ");
        dia = lector.nextInt();
        System.out.println("Mes:  ");
        mes = lector.nextInt();
        System.out.println("Anio:  ");
        anio = lector.nextInt();
        fechadeNacimiento = new Fecha(dia,mes, anio);
        System.out.println("RFC: ");
        rfc = lector.next();
        System.out.println("Domicilio: ");
        domicilio = lector.next();

        return new Cliente(nombre, apePaterno, apeMaterno, fechadeNacimiento, rfc, domicilio);
    }


    public void ImprimirCliente(){
        System.out.println("CLIENTE");
        System.out.println("Nombre: "+nombre);
        System.out.println("Apellido Paterno: "+apePaterno);
        System.out.println("Apeliido Materno: "+apeMaterno);
        System.out.println("Fecha de nacimiento: ");
        getFechaNacimiento().imprimir();
        System.out.println("Rfc: "+rfc);
        System.out.println("Domicilio: "+domicilio);
    }



}