import java.util.Date;

public class Persona1{
    private String nombre;
    private Date dateNacimiento;
    private int dni;

    public Persona1(String nombre, Date dateNacimiento, int dni){
            this.nombre = nombre;
            this.dateNacimiento = dateNacimiento;
            this.dni = dni;
             }
                public Persona1(){
           
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

        public void imprimirDatos(){
            System.out.print("DNI: ");
            System.out.print(dni);
            System.out.print("Nombre: "+ nombre);
            System.out.print("Fecha Nacimiento: ");
           // dateNacimiento.imprimir();
            System.out.println();
        }
}