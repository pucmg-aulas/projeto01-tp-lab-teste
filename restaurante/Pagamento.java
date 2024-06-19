package restaurante;

public abstract class Pagamento implements IPagavel{
 double desconto;
int prazo;
Pedido pedido;
double total;//como puxar o total do pedido

public Pagamento(double pagamento) {
	this.total = pagamento;
}

public double getTotal() {
	return total;
}



}