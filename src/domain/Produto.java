package domain;

import java.time.LocalDate;

public class Produto extends BaseParametro {
    // criadno um codigo para subclasse e valor
    private int codigoSubclasse;
    private double valor;

    // gerando os getters e setters
    public int getCodigoSubclasse() {
        return codigoSubclasse;
    }

    public void setCodigoSubclasse(int codigoSubclasse) {
        this.codigoSubclasse = codigoSubclasse;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    // gerando os construtores
    // primeiro o vazio
    public Produto() {
        super();
    }

    // gerando o constructor com os atributos do pai e da classe
    public Produto(int codigo, String descricao, LocalDate dataDeInclusao, int codigoSubclasse, double valor) {
        super(codigo, descricao, dataDeInclusao);
        this.codigoSubclasse = codigoSubclasse;
        this.valor = valor;
    }

}
