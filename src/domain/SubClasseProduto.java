package domain;

import java.time.LocalDate;

// classe criada e fazendo herança com BaseParametro
public class SubClasseProduto extends BaseParametro {
    // cirando um atributo para classe filha
    private int codigoClasse;

    // gerando um getter e setter para o privete codigoClasse
    public int getCodigoClasse() {
        return codigoClasse;
    }

    public void setCodigoClasse(int codigoClasse) {
        this.codigoClasse = codigoClasse;
    }

    // criando um constructor com herança
    // puxando primeriamente o constructor vazio
    public SubClasseProduto() {
        super();
    }

    // constructor com os atributos
    public SubClasseProduto(int codigo, String descricao, LocalDate dataDeInclusao, int codigoClasse) {
        super(codigo, descricao, dataDeInclusao);
        this.codigoClasse = codigoClasse;
    }
}
