package restaurante;

public class PagamentoDinheiro extends Pagamento{
	int prazo = 0;
	double desconto = 1.00;

public PagamentoDinheiro(double pagamento) {
		super(pagamento);

}
@Override
public double pagar(double pagamento) {
	pagamento = pagamento * desconto;
	return pagamento;
}
	
}