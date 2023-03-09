import java.util.Date;
import java.text.SimpleDateFormat;

public class Persona1{
    private String nombre;
    private Date dateNacimiento;
    private int dni;

    public Persona1(String nombre, Date dateNacimiento, int dni){
            this.nombre = nombre;
            this.dateNacimiento = dateNacimiento;
            this.dni = dni;
             }
        public String getNombre(){
        return nombre;
            }
            public Date getDateNacimiento(){
        return dateNacimiento;
            }
            public int getDni(){
        return dni;
            }

            public void setNombre(String nombre) {
                this.nombre = nombre;
            }
        
            public void setdateNacimiento(Date dateNacimiento) {
                this.dateNacimiento = dateNacimiento;
            }
        
            public void setDni(int dni) {
                this.dni = dni;
            }

        public void imprimirDatos(){
            System.out.print("DNI: ");
            System.out.print(dni);
            System.out.print("Nombre: "+ nombre);
            System.out.print("Fecha Nacimiento: "+ formatdate());
            System.out.println();
        }
        public String formatdate() {
            SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
            String dateFormat = sfd.format(dateNacimiento);
            return dateFormat;
        }
}