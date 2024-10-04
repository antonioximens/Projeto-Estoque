package fakedb;

import java.time.LocalDate;
import java.util.ArrayList;

import domain.SubClasseProduto;

// extends com a baseFakeDB sendo generica de SubClasseProduto
public class SubClasseProdutoFakeDB extends BaseFakeDB<SubClasseProduto> {

    /* puxando o metodo abstrato do pai para classe filha */
    @Override
    void preencherDados() {
        // instanciando a tabela do pai para se torna uma lista de SubClasseProduto
        // logo pega o this.tabela = new ArrayList<tipo da lista>
        // this.tabela = new ArrayList<tipo da lista>();
        
        this.tabela = new ArrayList<SubClasseProduto>();

        // instanciadno a ClasseProduto para preencher
        // e usando o add para alocar a instacia logo fica
        // this.tabela(do pai).add(instancia aqui dentro)
        this.tabela.add(new SubClasseProduto(1, "Cerveja", LocalDate.now(), 1));
        this.tabela.add(new SubClasseProduto(2, "Suco", LocalDate.now(), 1));
        this.tabela.add(new SubClasseProduto(3, "Chá", LocalDate.now(), 1));
        this.tabela.add(new SubClasseProduto(4, "Água", LocalDate.now(), 1));
        this.tabela.add(new SubClasseProduto(5, "Destilado", LocalDate.now(), 1));

    }

    public SubClasseProdutoFakeDB() {
        super();
    }

}
