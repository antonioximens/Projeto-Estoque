package domain;

import java.time.LocalDate;

public class BaseParametro {
    // criando as propriedades
    // para ser utilizado para classes filhos
    protected int codigo;
    protected String descricao;
    protected LocalDate dataDeInclusao;

    // gerando os getters e setters
    // para obter e mudar valores
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataDeInclusao() {
        return dataDeInclusao;
    }

    public void setDataDeInclusao(LocalDate dataDeInclusao) {
        this.dataDeInclusao = dataDeInclusao;
    }

    // criando o constructor
    public BaseParametro() {
    }

    // constructor com atributos
    public BaseParametro(int codigo, String descricao, LocalDate dataDeInclusao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.dataDeInclusao = dataDeInclusao;
    }
}
