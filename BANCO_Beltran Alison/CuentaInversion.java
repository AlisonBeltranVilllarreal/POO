public class CuentaInversion extends Cliente{
    public int plazo;
    public int intereses;

    public CuentaInversion(int plazo, int intereses) {
        this.plazo = plazo;
        this.intereses = intereses;
    }

    public double proyectarInversion(double cantidad){
       double rendimientos = (this.intereses * 0.01) * cantidad;
       double total = (this.plazo * rendimientos) + cantidad;
       return total;
    }
}