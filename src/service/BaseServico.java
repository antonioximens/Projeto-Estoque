package service;

import java.util.ArrayList;

public abstract class BaseServico<TDominio> {
    // crud: Create, Read && ReadA, update e delete ;

    // ReadAll é um metodo publico abstrato com uma lista de TDominio que percorre toda 
    // a lista
    public abstract ArrayList<TDominio> LerTodos();
    // ler algum item especifico precisa mostrar a chave que é dele
    public abstract TDominio Ler(int chave);
    // qu aod se cria algo, precisa passar algo ou a instacia a ser criada
    public abstract TDominio Criar(TDominio obj);
    // quando se edita procurace o obj para alterar
    public abstract TDominio Atualizar(TDominio obj);
    // ao deletar algo voce deve passar a chave para encontra-lo
    public abstract TDominio Deletar(int chave);

    
}
