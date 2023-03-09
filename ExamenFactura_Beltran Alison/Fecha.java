import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Fecha {
    public int dia;
    public int mes;
    public int anio;

    public Fecha(int dia,int mes, int anio){
        this.dia=dia;
        this.mes=mes;
        this.anio=anio;
    }

    public void imprimir(){
        System.out.println(this.dia + "/"+ this.mes + "/" + this.anio);
    }
}
