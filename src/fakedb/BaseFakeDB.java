package fakedb;

import java.util.ArrayList;

public abstract class BaseFakeDB<TDominio> {
    // criando um ArrayList para armazerna dados genericos
    // atributo protegido
    protected ArrayList<TDominio> tabela;

    // propriedade somente leitura
    public ArrayList<TDominio> getTabela() {
        return tabela;
    }

    /*
     * 1- metodos abstract nao podem ter codigo
     * 2- metodos devem ser codificados nas classe filhas (reais)
     * 3- este metodo deve ser executado toda a vez que a classe filha for
     * instanciada
     * usando o constrcutor para sempre ser executado
     */
    abstract void preencherDados();

    // criando um constructor
    // todas vez que chamar essa classe vai ser executado o preencherDados
    public BaseFakeDB() {
        this.preencherDados();
    }
}
