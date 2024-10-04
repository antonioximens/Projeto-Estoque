package domain;

import java.time.LocalDate;

// classe criada e fazendo herança com BaseParametro
public class ClasseProduto extends BaseParametro {
    // criando um constructor com herança
    // puxando primeriamente o constructor vazio
    public ClasseProduto() {
        super();
    }

    // constructor com os atributos
    public ClasseProduto(int codigo, String descricao, LocalDate dataDeInclusao) {
        super(codigo, descricao, dataDeInclusao);
    }
}
