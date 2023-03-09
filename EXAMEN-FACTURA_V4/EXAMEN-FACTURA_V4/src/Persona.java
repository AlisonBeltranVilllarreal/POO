import java.text.SimpleDateFormat;
import java.util.Date;

public class Persona {
    public String nombre;
    public String apellidoPaterno;
    public String apellidoMaterno;
    public Date fechaNacimiento;


    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public void imprimirDatos() {
        System.out.println("Nombre: ");
        System.out.println(nombre);
        System.out.println("Apellido Paterno: ");
        System.out.println(apellidoPaterno);
        System.out.println("Apellido Materno: ");
        System.out.println(apellidoMaterno);
        System.out.print("Fecha de nacimiento: " + formatFecha());
        System.out.println();
    }

    public String formatFecha() {
        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormat = sfd.format(fechaNacimiento);
        return fechaFormat;
    }
}
