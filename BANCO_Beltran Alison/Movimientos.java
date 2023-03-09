import java.util.Date;

public class Movimientos  {
    private String tipo;
    private Date fecha;
    private double monto;
    private double saldoAnterior;
    private double saldoActual;

    public Movimientos(String tipo, Date fecha, double monto, double saldoAnterior, double saldoActual) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.monto = monto;
        this.saldoAnterior = saldoAnterior;
        this.saldoActual = saldoActual;
    }

    public String getTipo() {
        return tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public double getSaldoAnterio() {
        return saldoAnterior;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void imprimirDatos(){
        System.out.println("Tipo: "+tipo);
        System.out.println("Fecha: "+fecha);
        System.out.println("Monto: "+monto);
        System.out.println("Saldo anterior: "+saldoAnterior);
        System.out.println("Saldo actual: "+saldoActual);
    }

}
