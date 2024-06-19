package restaurante;

import java.util.*;

public class PagamentoPix extends Pagamento{
	int prazo = 0;
	double desconto = 0.0145;
	int maxDesconto = 10;
	
public PagamentoPix(double pagamento) {
		super(pagamento);
	}


@Override
public double pagar(double pagamento) {
	double valorDescontado = pedido.calcularTotal() * desconto ;
	
	return pagamento - Math.min(maxDesconto, valorDescontado);
}

}