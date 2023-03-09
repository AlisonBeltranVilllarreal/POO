import java.util.Date;

public class CuentaBancaria {
    private String tipoDeCuenta;
    private long numeroCuenta;
    private double saldo;
    private Date fechaAlta;
    private Cliente cliente;
    private CuentaInversion cuentaInversion;
    private CuentaNomina cuentaNomina;


    public CuentaBancaria(String tipoDeCuenta, long numeroCuenta, double saldo, Date fechaAlta, Cliente cliente, CuentaNomina cuentaNomina, CuentaInversion cuentaInversion) {
        this.tipoDeCuenta = tipoDeCuenta;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.fechaAlta = fechaAlta;
        this.cliente = cliente;
        this.cuentaNomina = cuentaNomina;
        this.cuentaInversion = cuentaInversion;
    }

    public String getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    public void setTipoDeCuenta(String tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public CuentaNomina getCuentaNomina() {
        return cuentaNomina;
    }

    public CuentaInversion getCuentaInversion() {
        return cuentaInversion;
    }

    public void imprimirDatos(){
        System.out.println("Numero de cuenta: "+numeroCuenta);
        System.out.println("Saldo: "+saldo);
        System.out.println("Fecha alta: "+fechaAlta);
        cliente.imprimirDatos();
    }

}
