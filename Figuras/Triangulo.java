public class Triangulo implements figura{
    public double lado;
    @Override
    public double calcularArea(double x, double y){
        return x*y/2;
    }
    @Override
    public double calcularPerimetro(double x, double y){
        return x+y+lado;
    }
    @Override
    public void centrar(int ren, int col){
         
    }
}
