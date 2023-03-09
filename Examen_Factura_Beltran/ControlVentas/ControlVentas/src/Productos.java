public class Productos {
    private int id;
    private String descripcion;
    private float precio;

    public Productos(int id, String descripcion, float precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public void imprimirDatos(){
        System.out.println("ID: "+id);
        System.out.println("Descripcion: "+descripcion);
        System.out.println("Precio: "+precio);
    }
}
