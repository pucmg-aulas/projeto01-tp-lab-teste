/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante;

import java.util.*;

public class ListaDeEspera {
    
    private ArrayList<RequisicaoDeMesa> listaRequisicao;
    private ArrayList<RequisicaoDeMesa> historico;

        
    public ListaDeEspera(){
        this.listaRequisicao = new ArrayList <> (); 
        this.historico = new ArrayList <>();
    }
    
    public void adicionaNaLista(RequisicaoDeMesa requisicao){
        if (requisicao == null) {
            throw new IllegalArgumentException("não pode ser vazio");
        }
        this.listaRequisicao.add(requisicao);
                this.historico.add(requisicao);

    }
    
    public void removeDaLista(RequisicaoDeMesa requisicao){
        this.listaRequisicao.remove(requisicao);
        
    }

    public void removeDaListaPorNome(String nomeCliente) {
        
    listaRequisicao.removeIf(requisicao -> requisicao.getNomeCliente().equals(nomeCliente));
    }
    
    public String imprimeLista(){
        String rtrn = "";
        for (int i = 0; i < listaRequisicao.size(); i++) {
            rtrn += "Cliente: "+listaRequisicao.get(i).getNomeCliente() +", "+listaRequisicao.get(i).getQuantiaPessoas() + "\n";
        }
        return rtrn;
    }
    public String imprimeHistorico(){
        String rtrn = "";
        for (int i = 0; i < historico.size(); i++) {
            rtrn += "Cliente: "+historico.get(i).getNomeCliente()+", "+historico.get(i).getQuantiaPessoas() + "\n";
        }
        return rtrn;
    }
}
