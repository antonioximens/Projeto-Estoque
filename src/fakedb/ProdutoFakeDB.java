package fakedb;

import java.util.ArrayList;
import java.time.LocalDate;
import domain.Produto;

// Pegando dados da base fakeDb sendo generica de Produto
// logo após implementei o metodo do pai, preencherDados
public class ProdutoFakeDB extends BaseFakeDB<Produto> {

    /* puxando o metodo abstrato do pai para classe filha */
    @Override
    void preencherDados() {
        // instanciando a tabela do pai para se torna uma lista de SubClasseProduto
        // logo pega o this.tabela = new ArrayList<tipo da lista>
        // this.tabela = new ArrayList<tipo da lista>()

        this.tabela = new ArrayList<Produto>();

        this.tabela.add(new Produto(1, "Coca-Cola", LocalDate.now(), 1, 5.00));
        this.tabela.add(new Produto(2, "Fanta", LocalDate.now(), 1, 4.00));
        this.tabela.add(new Produto(2, "Mate-Leão", LocalDate.now(), 3, 3.50));
        this.tabela.add(new Produto(4, "Crystal", LocalDate.now(), 4, 4.50));
        this.tabela.add(new Produto(5, "Vodka", LocalDate.now(), 5, 45.89));
    }

    // criadno um constructor
    public ProdutoFakeDB() {
        super();
    }

}
