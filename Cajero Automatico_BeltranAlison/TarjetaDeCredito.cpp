public class TarjetaDeCredito : Tarjeta {
private:
	int balanceAlCorte;

public:
	TarjetaDeCredito();

	void getBalanceAlCorte();

	void setBalanceAlCorte(int balanceAlCorte);

	void calculaBalanceAlCorte();
};