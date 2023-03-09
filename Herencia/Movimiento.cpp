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