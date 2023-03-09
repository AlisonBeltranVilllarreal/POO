import java.util.Date;

public class Estudiante extends Persona {
    private int puntuacionTotal;
    private int numeroCalificaciones;

    public Estudiante(String nombre, Date fechaNacimiento,
                      int dni) {
        super(nombre, fechaNacimiento, dni);

        this.puntuacionTotal = 0;
        this.numeroCalificaciones = 0;
    }
    public void nuevaCalificacion(int puntos) {
        puntuacionTotal += puntos;
        numeroCalificaciones++;
    }
    public double getNotaMedia() {
        return ((double) puntuacionTotal)/numeroCalificaciones;
    }

    public void imprimirDatos() {
        System.out.println("DATOS DEL ESTUDIANTE");
        System.out.print("DNI: ");
        System.out.println(getDni());
        System.out.println("NOMBRE: " + getNombre());
        System.out.println("FECHA DE NACIMIENTO: " + formatFecha());
        System.out.println("NOTA MEDIA: "+getNotaMedia());
        System.out.println();
    }
}
