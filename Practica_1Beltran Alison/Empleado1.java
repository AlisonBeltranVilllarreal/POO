import java.util.Date;

public class Empleado1 extends Persona1{
    private int sueldoBase;
    public Empleado1(String nombre, Date dateNacimiento, int dni, int sueldoBase ){
        super(nombre, dateNacimiento, dni);
        this.sueldoBase = sueldoBase;
    }
    public int getSueldoBase(){
        return sueldoBase;
    }

    public void setSueldoBase(int sueldoBase){
        this.sueldoBase =sueldoBase;
    }
    public void imprimirDatos(){
        
        System.out.print("DNI: ");
        System.out.print(getDni());
        System.out.println();
        System.out.print("Nombre: "+ getNombre());
        System.out.println();
        System.out.print("Fecha Nacimiento: " + getDateNacimiento());
       // dateNacimiento = new Date();
        System.out.println();
        System.out.println("Sueldo Base: "+ sueldoBase);
        //sueldoBase=lector.nextInt();
    }

}
