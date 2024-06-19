package restaurante;

public class PagamentoDebito extends Pagamento{
	int prazo = 14;
	double desconto =  0.86;
	
	public PagamentoDebito(double pagamento) {
		super(pagamento);
	}
	
	@Override
	public double pagar(double pagamento) {
		pagamento = pedido.calcularTotal() * desconto;
		return pagamento;
	}
}