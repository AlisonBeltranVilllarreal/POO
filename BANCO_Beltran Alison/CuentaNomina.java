import java.util.ArrayList;
import java.util.Scanner;

public class CuentaNomina extends CuentBancaria{
    public static Movimientos movimiento;
    public static Scanner lector = new Scanner(System.in);
    public static ArrayList<Movimientos> movimientos = new ArrayList<>();


    public CuentaNomina(ArrayList<Movimientos> movimientos) {
        this.movimientos = movimientos;
    }

    public ArrayList<Movimientos> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<Movimientos> movimientos) {
        this.movimientos = movimientos;
    }

    public void depositar(Movimientos movimientos){
        this.movimientos.add(movimientos);
    }

    public void retirar(Movimientos movimientos){
        this.movimientos.add(movimientos);
    }
}