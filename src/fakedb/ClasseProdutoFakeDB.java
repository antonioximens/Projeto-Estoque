package fakedb;

import java.time.LocalDate;
import java.util.ArrayList;

import domain.ClasseProduto;

// extends BaseFAkeDB, como estamos criando o produto o TDominio consequentimente se torna
// ClasseProduto, pois é ela que estamos mexendo
public class ClasseProdutoFakeDB extends BaseFakeDB<ClasseProduto> {

    // usar a lampada para implementar o metodo preencherDados
    @Override
    void preencherDados() {
        // instanciando a tabela do pai para se torna uma lista de ClasseProduto
        this.tabela = new ArrayList<ClasseProduto>();
        // instanciadno a ClasseProduto para preencher
        // e usando o add para alocar a instacia logo fica
        // this.tabela(do pai).add(instancia aqui dentro)
        this.tabela.add(new ClasseProduto(1, "Carnes", LocalDate.now()));
        this.tabela.add(new ClasseProduto(2, "Bebidas", LocalDate.now()));
        this.tabela.add(new ClasseProduto(3, "Laticínios", LocalDate.now()));
        this.tabela.add(new ClasseProduto(4, "Higiene", LocalDate.now()));
        this.tabela.add(new ClasseProduto(5, "Limpeza", LocalDate.now()));

    }

    // constructor
    public ClasseProdutoFakeDB() {
        super();
    }

}
