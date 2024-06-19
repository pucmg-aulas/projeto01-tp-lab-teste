package restaurante;

	public class PagamentoCredito extends Pagamento {
	int prazo = 30;
	double desconto = 0.969;

	public PagamentoCredito(double pagamento) {
		super(pagamento);
	}
	
	
	@Override
	public double pagar(double pagamento) {
		pagamento = pedido.calcularTotal() * desconto;
		return pagamento;
	}
}