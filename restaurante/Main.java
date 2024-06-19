package restaurante;

import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        ArrayList<RequisicaoDeMesa> requisicoes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Mesa> mesas = new ArrayList<Mesa>();
        mesas.add(new Mesa(4, true));
        mesas.add(new Mesa(6, true));
        mesas.add(new Mesa(8, true));
        ListaDeEspera listaDeEspera = new ListaDeEspera(mesas);

        
      
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Incluir pessoa na fila de espera por mesa");
            System.out.println("2 - Remover pessoa da fila de espera");
            System.out.println("3 - Buscar pessoa na fila de espera");
            System.out.println("4 - Mostrar toda a lista de espera");
            System.out.println("5 - Mostrar disponibilidade das mesas");
            System.out.println("6 - Imprimir Menu");
            System.out.println("7 - Fazer Pedido ");
            System.out.println("8 - Pedir a conta ");
            System.out.println("9 - Sair");


            System.out.print("Opcao: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {

                case 1: {

                    System.out.print("\nDigite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o número de lugares: ");
                    int lugares = scanner.nextInt();
                    scanner.nextLine();

                    Mesa mesaDisponivel = mesas.stream()
                            .filter(mesa -> mesa.isDisponivel() && mesa.getNumeroAssentos() >= lugares)
                            .sorted(Comparator.comparingInt(Mesa::getNumeroAssentos))
                            .findFirst()
                            .orElse(null);

                    if (mesaDisponivel != null) {
                        RequisicaoDeMesa requisicao = new RequisicaoDeMesa(nome, lugares, LocalTime.now(), mesaDisponivel);
                        listaDeEspera.adicionarNaLista(requisicao);
                        requisicoes.add(requisicao);
                        System.out.println("Cliente adicionado com sucesso!");
                    } else {
                        System.out.println("Nenhuma mesa disponível no momento.");
                    }
break;
                }
                case 2: {

                    System.out.print("\nDigite o nome do cliente a ser removido: ");
                    String nome = scanner.nextLine();
                    listaDeEspera.removerDaListaPorNome(nome);
                    requisicoes.removeIf(rm -> rm.getNomeCliente().equals(nome));
                    System.out.println("Cliente removido com sucesso!");
                    break;
                }
                case 3: {

                    System.out.print("\nDigite o nome do cliente para busca: ");
                    String nome = scanner.nextLine();
                    System.out.println(listaDeEspera.imprimirCliente(nome));
                    break;
                }
                case 4: {

                    System.out.println("\nLista de espera atual:");
                    System.out.println(listaDeEspera.imprimirLista());
                    break;
                }
                case 5: {

                    System.out.println("\nDisponibilidade das Mesas:");
                    mesas.forEach(mesa -> System.out.println("Mesa " + mesa.getNumeroAssentos() + " lugares: " + (mesa.isDisponivel() ? "Disponível" : "Ocupada")));
                    break;
                }
                case 6: {

                    System.out.println(menu.imprimirMenu());
                    break;
                }
                case 7: {
                    System.out.println("Insira 1 para pedido no Restaurante e 2 para pedido Delivery: s a");
                    int opcaoPedido = scanner.nextInt();
                    scanner.nextLine();
                    switch(opcaoPedido) {


                    case 1: {

                        System.out.println("Escolha a Mesa: ");
                        requisicoes.forEach(requisicao -> System.out.println("Mesa: " + requisicao.getNomeCliente()));
                        String nome = scanner.nextLine();
                        RequisicaoDeMesa requisicaoEncontrada = requisicoes.stream()
                                .filter(rm -> rm.getNomeCliente().equals(nome))
                                .findFirst()
                                .orElse(null);

                        if (requisicaoEncontrada != null) {

                            System.out.println("Menu:\n" + menu.imprimirMenu());
                            System.out.print("Digite o nome do item para adicionar ao pedido: ");
                            String itemNome = scanner.nextLine();
                            ItemMenu item = menu.getItens().stream()
                                    .filter(i -> i.getNome().equalsIgnoreCase(itemNome))
                                    .findFirst()
                                    .orElse(null);

                            if (item != null) {

                                requisicaoEncontrada.getPedido().adicionarItem(item);
                                System.out.println("Item adicionado ao pedido!");

                            } else {

                                System.out.println("Item não encontrado no menu! :(");

                            }
                        } else {
                            System.out.println("Mesa não encontrada!");
                        }
                    } 
                    
                    case 2:{

                        System.out.println("Menu:\n" + menu.imprimirMenu());
                        System.out.print("Digite o nome do item para adicionar ao pedido: ");
                        String itemNome = scanner.nextLine();
                        ItemMenu item = menu.getItens().stream()
                                .filter(i -> i.getNome().equalsIgnoreCase(itemNome))
                                .findFirst()
                                .orElse(null);

                        if (item != null) {

                            //getPedido().adicionarItem(item);
                            System.out.println("Item adicionado ao pedido!");

                        } else {

                            System.out.println("Item não encontrado no menu! :(");
                        }
                     }
                }
              break;
                }
                case 8: {

                    System.out.println("Escolha a Mesa: ");
                    requisicoes.forEach(requisicao -> System.out.println("Mesa: " + requisicao.getNomeCliente()));
                    String nome = scanner.nextLine();
                    RequisicaoDeMesa requisicaoEncontrada = requisicoes.stream()
                            .filter(rm -> rm.getNomeCliente().equals(nome))
                            .findFirst()
                            .orElse(null);
                    if (requisicaoEncontrada != null) {

                        System.out.println("Total a pagar: R$ " + requisicaoEncontrada.calculaConta());
                       
                       
                        System.out.println("Insira o método de pagamento: \n1. Dinheiro \n2. Pix \n3. Cartão de Débito \n4. Cartão de Crédito");
                        int metodoPagamento = scanner.nextInt();
                        switch(metodoPagamento) {
                        case 1: {
                        	
                        	
                        	double total = requisicaoEncontrada.getPedido().calcularTotal();
                        	Pagamento pagamento = new PagamentoDinheiro(total);
                        	pagamento.pagar(total);
                        	
                        }
                        }

                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    } else {

                        System.out.println("Mesa não encontrada! :(");
                    }
               break;
                }
                case 9: {

                    System.out.println("\nEncerrando programa.");

                    break;

                }
            }
        }
    }
}
