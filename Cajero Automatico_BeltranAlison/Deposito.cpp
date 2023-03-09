#include"Deposito.hpp"

Deposito: :Deposito(){

Deposito: :Deposito(Cliente elCliente, string laFecha,
Float: elMonto, string numDeCuenta,
string elTipo): Movimiento(elCliente, laFecha, elMonto, numDeCuenta)
{
    tipo = elTipo;
}
string Deposito: :getTipo()
{
    return tipo;
}
float Debito: :get monto()
{
    return monto;
}
}

private:
	string Cliente;
	int numDeCuenta;
	string fecha;
	int importe;

public:
	Deposito();
	
	Deposito(string cliente, int numeroDeCuenta, string fecha, int importe);
	
	void getCliente();

	string getNumDeCuenta();

	string getFecha();

	string getImporte();

	String sumaAlBalance();
};