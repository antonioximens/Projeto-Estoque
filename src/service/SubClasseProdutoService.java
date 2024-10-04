package service;

import java.util.ArrayList;

import domain.SubClasseProduto;
import repository.SubClasseProdutoRepo;

public class SubClasseProdutoService extends BaseServico<SubClasseProduto>{

    private SubClasseProdutoRepo repo;

    // criando um contructor para classe
    public SubClasseProdutoService() {
        // chamando o repo com this para pode usar os metodos do crud
        // caso na ofaça essa inicialização ele da um erro
        this.repo = new SubClasseProdutoRepo();
    }

    @Override
    public ArrayList<SubClasseProduto> LerTodos() {
        // imprementando o metodo 
        return this.repo.ReadAll();    
    }

    @Override
    public SubClasseProduto Ler(int chave) {
        // imprementando o metodo 
        return this.repo.Read(chave);
    }

    @Override
    public SubClasseProduto Criar(SubClasseProduto obj) {
        // imprementando o metodo 
        return this.repo.Create(obj);
    }

    @Override
    public SubClasseProduto Atualizar(SubClasseProduto obj) {
        // imprementando o metodo 
        return this.repo.Update(obj);
    }

    @Override
    public SubClasseProduto Deletar(int chave) {
        // imprementando o metodo 
        return this.repo.Delete(chave);
    }
    
}
