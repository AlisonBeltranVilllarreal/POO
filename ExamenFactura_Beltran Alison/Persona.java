public class Persona{
    public String nombre;
    public String apePaterno;
    public String apeMaterno;
    public Fecha fechaNacimiento;

    public Persona(String nombre, String apePaterno, String apeMaterno, Fecha fechaNacimiento) {
        //super(dia, mes,anio);
        this.nombre=nombre;
        this.apePaterno=apePaterno;
        this.apeMaterno=apeMaterno;
        this.fechaNacimiento=fechaNacimiento;

    }

    public Fecha getFechaNacimiento(){
        return fechaNacimiento;
    }
}