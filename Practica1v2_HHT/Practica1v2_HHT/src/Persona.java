import java.text.SimpleDateFormat;
import java.util.Date;

public class Persona {
    private String nombre;
    private Date fechaNacimiento;
    private int dni;

    public Persona(String nombre,
                   Date fechaNacimiento, int dni) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void imprimirDatos() {
        System.out.print("DNI: ");
        System.out.println(dni);
        System.out.println("NOMBRE: " + nombre);
        System.out.print("FECHA DE NACIMIENTO: " + formatFecha());
        System.out.println();
    }

    public String formatFecha() {
        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormat = sfd.format(fechaNacimiento);
        return fechaFormat;
    }

}