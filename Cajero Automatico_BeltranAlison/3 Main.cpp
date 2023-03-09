#include <stdlib.h>
#include <iostream>
#include "Cliente.hpp"
#include "Movimiento.hpp"

int main(int argc, char* argv[])
{
    Cliente cliente1("Bob, ""AIMA3334", "BLA BLA BLA");
    Cliente cliente2("Suci, ""SUE3334", "BLA BLA BLA");
    Cliente cliente3("Robert, ""ROBT334", "BLA BLA BLA");

    Cliente clientes[10];
    clientes[0]=cliente1;
    clientes[1]=cliente2;
    clientes[2]=cliente3;

    for(int i=0; i< 3; i++)
    cout << "Cliente[" << i <<"]" << clientes[i].getNombre()<<endl;

    Deposito deposito1(cliente1, "05/04/2022", 4765.56, "435627", "deposito");
    cout << "Tipo de Movimiento: "<<deposito1.getTipo()<<endl;
    cout << "Monto depositado: "<<deposito1.getMonto()<<endl;

    cout <<"Cliente 1: :nombre" <<clientes[0].getNombre() <<endl;
    cout <<"Cliente 2: :rfc" <<clientes[1].getRfc()<< endl;
    cout <<"Cliente 3: :domicilio"<<clientes[2].getDomicilio() << endl;

    return EXIT_SUCCESS;
}