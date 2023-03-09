#include "Movimiento.hpp"

Movimiento: :Movimiento(){}
Movimiento: :Movimiento(Cliente elCliente, string laFecha, float elMonto)
{
    cliente = elCliente;
    fecha = laFecha;
    monto = elMonto;
}
float Movimiento: :getMonto()
{
    return monto;
}
public:
	void Movimiento();

	string getCliente();

	void setCliente(string Cliente);

	string getNumDeCuenta();

	void setNumDeCuenta(string numDeCuenta);

	string getFecha();

	void setFecha(string fecha);
};