public class Retiro : Class {

private:
	int Cliente;
	string numDeCuenta;
	string fecha;
	string importe;

public:
	Retiro();
	
	Retiro(string cliente, int numeroDeCuenta, string fecha, int importe);
	
	void getCliente();

	string getNumDeCuenta();

	string getFecha();

	string getImporte();

	String restaAlBalance();
};