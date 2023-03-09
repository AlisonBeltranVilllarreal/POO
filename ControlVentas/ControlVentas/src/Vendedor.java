import java.util.Date;

public class Vendedor extends Persona{
    private int id;
    private String area;
    private float porcentajeComision;
    private int sueldoBase;
    

    public Vendedor(int id, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String area, float porcentajeComision, int sueldoBase) {
        super(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento);
        this.id = id;
        this.area = area;
        this.porcentajeComision = porcentajeComision;
        this.sueldoBase = sueldoBase;
    }

    public void imprimirDatos() {
        System.out.println("area: " + area);
        System.out.println("porcentajeComision: " + porcentajeComision);
        System.out.println("sueldoBase: " + sueldoBase);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public float getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(float porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    public int getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(int sueldoBase) {
        this.sueldoBase = sueldoBase;
    }
}
