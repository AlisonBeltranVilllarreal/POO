import java.util.Date;

public class Empleado extends Persona {
    protected int sueldoBase;

    public Empleado(String nombre, Date fechaNacimiento, int dni, int sueldoBase) {
        super(nombre, fechaNacimiento, dni);
        this.sueldoBase = sueldoBase;
    }

    public int getSueldo() {
        return sueldoBase;
    }

    public void setSueldoBase(int sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public void imprimirDatos() {
        System.out.print("DNI: ");
        System.out.println(getDni());
        System.out.println("NOMBRE: " + getNombre());
        System.out.println("FECHA DE NACIMIENTO: " + formatFecha());
        System.out.println("Sueldo base:" + sueldoBase);
    }
}
