package com.company.banco;

public class Cliente{

    private String nombre;
    private String apellido;
    private String domicilio;
    private String ciudad;
    private String telefono;

    public Cliente(String nombre, String apellido, String domicilio, String ciudad, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void imprimirDatos(){
        System.out.println("NOMBRE: "+nombre);
        System.out.println("APELLIDO: "+apellido);
        System.out.println("DOMICILIO: "+domicilio);
        System.out.println("CIUDAD: "+ciudad);
        System.out.println("TELEFONO: "+telefono);
    }

}