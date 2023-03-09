import java.util.Date;

public class Estudiante extends Persona1 {
    private int puntuacionTotal;
    private int numeroCalificaciones;

    public Estudiante(String nombre, Date fechaNacimiento,
                    int dni, int puntuacionTotal, int numeroCalificaciones) {
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
        super.imprimirDatos();
        System.out.println("NOTA MEDIA: ");
        System.out.println(this.getNotaMedia());
        System.out.println();
    }
}
