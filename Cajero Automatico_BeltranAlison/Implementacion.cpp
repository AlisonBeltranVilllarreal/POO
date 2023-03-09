#include <stdlib.h>
#include "BDCliente.hpp"

BDCliente: :BDCliente(){indice = 0;}

    void BDCliente: :agrega(Cliente elCliente)
    {
        clientes[indice] = elCliente;
        indice+=1;
    }

    void BDCliente: :despliega()
    {
        fot(int i=0; i< indice; i++)
            cout <<"Cliente: :"<< clientes[i].getNombre()<<endl;
    }