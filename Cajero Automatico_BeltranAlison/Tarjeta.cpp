public class Tarjeta {

private:
	int numEnPlastico;
	int numDeSeguridad;
	int numDeCuenta;
	string Cliente;
	string Vigencia;

public:
	int getNumEnPlastico();

	int getNumDeSeguridad();

	int getNumDeCuenta();

	string getCliente();

	string getVigencia();

	Tarjeta();

	Tarjeta(int numEnPlastico, int numDeSeguridad, int numDeCuenta, string cliente);
};