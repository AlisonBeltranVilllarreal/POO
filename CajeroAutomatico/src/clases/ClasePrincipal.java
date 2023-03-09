package clases;

public class ClasePrincipal {
    public static void main(String[] args) {
        
        ClasePadre_Abstracta mesajero = new ClaseHija_Consulta();
        mesajero.setSaldo(500);
        mesajero.Operaciones();
    }
}
