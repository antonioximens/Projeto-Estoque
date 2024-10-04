package service;

import java.util.ArrayList;

import domain.ClasseProduto;
import repository.ClasseProdutoRepo;

public class ClasseProdutoService extends BaseServico<ClasseProduto> {

    // precisa import a classe repositorio para usar os metodos do crud
    private ClasseProdutoRepo repo;

    // criando o constructor para inicializar a classe
    public ClasseProdutoService(){
        // chamando o repo com this para pode usar os metodos do crud
        this.repo = new ClasseProdutoRepo();
    }

    @Override
    public ArrayList<ClasseProduto> LerTodos() {
         // chamamos o repo para usar o metodo
        return this.repo.ReadAll();
    }

    @Override
    public ClasseProduto Ler(int chave) {
         // chamamos o repo para usar o metodo
        return this.repo.Read(chave);
    }

    @Override
    public ClasseProduto Criar(ClasseProduto obj) {
         // chamamos o repo para usar o metodo
        return this.repo.Create(obj);
    }

    @Override
    public ClasseProduto Atualizar(ClasseProduto obj) {
         // chamamos o repo para usar o metodo
        return this.repo.Update(obj);
    }

    @Override
    public ClasseProduto Deletar(int chave) {
         // chamamos o repo para usar o metodo
        return this.repo.Delete(chave);
    }

}
