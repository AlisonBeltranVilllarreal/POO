public class TarjetaDeDebito : Tarjeta {
private:
	int  balanceActual;

public:

	void getBalanceActual();

	void setBalanceActual(int balanceActual);

	void TarjetaDeDebito();

	void calculaBalanceActual();
};
