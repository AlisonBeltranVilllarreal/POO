import java.util.Date;

public class EmpleadoComision extends Empleado{
    private double porcentajeComision;
    private int dineroVentas;

    public EmpleadoComision(String nombre, Date fechaNacimiento, int dni,
                            int sueldoBase, double porcentajeComision) {
        super(nombre, fechaNacimiento, dni, sueldoBase);
        this.porcentajeComision = porcentajeComision;
        this.dineroVentas = 0;
    }

    public void vender(int dineroVenta) { this.dineroVentas += dineroVenta; }

    public int getSueldo() {
        return sueldoBase + ((int) (dineroVentas * porcentajeComision / 100.0));
    }

    public void imprimirDatos(){
        System.out.print("DNI: ");
        System.out.println(getDni());
        System.out.println("NOMBRE: " + getNombre());
        System.out.println("FECHA DE NACIMIENTO: " + formatFecha());
        System.out.println("Sueldo base:" + getSueldo());
        System.out.println("Comision: ");
        System.out.println((double)this.dineroVentas* this.porcentajeComision/100.0);

    }
}