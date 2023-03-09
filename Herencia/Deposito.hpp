#ifndef DEBITO_HPP
#define DEBITO_HPP

#include "Movimiento.hpp"
class  Deposito: public Movimiento
{
private:
    string tipo;
public:
     Deposito
    (Cliente elCliente, string laFecha, float elMonto, string elNumDeCuenta, string elTipo );
    string getTipo();
    float getMonto;

    Deposito(string elTipo);
     string getTipo();
}



