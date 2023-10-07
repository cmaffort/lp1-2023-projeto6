package br.cefetmg.lagos.model.service;

public class Venda {
    private double precoTotal;
    
    void adicionarItem(int id) {
        //precoTotal += preço do id
    }
    
    void removerItem(int id) {
        //remove a primeira ocorrência do id
        //precoTotal -= preço do id
    }
    
    void descontoVenda(double desconto) {
        precoTotal -= desconto * precoTotal;
    }
    
    void descontoItem(double desconto, int id) {
        //precoTotal -= desconto * preço do id
    }
    
    void emitirNotaFiscal() {
        
    }
    
    void finalizarVenda() {
        //receber e conferir pagamento
        //registrar venda no sistema
        //emitirNotaFiscal();
        //zerar a venda
    }
    
    void cancelarVenda() {
        precoTotal = 0;
    }
}