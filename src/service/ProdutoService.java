package service;

import java.util.ArrayList;

import domain.Produto;
import repository.ProdutoRepo;

public class ProdutoService extends BaseServico<Produto> {
    // criando repo para utilzar os metodos do crud
    private ProdutoRepo repo;

    // chamando o contructor para inicializar o repo e usar os metodos do crud
    public ProdutoService(){
        // inicializando a classe Repo com o new
        this.repo = new ProdutoRepo();
    }


    @Override
    public ArrayList<Produto> LerTodos() {
        // usa o repo para chamar oso metodos
        return this.repo.ReadAll();
    }

    @Override
    public Produto Ler(int chave) {
        // usa o repo para chamar oso metodos
        return this.repo.Read(chave);
    }

    @Override
    public Produto Criar(Produto obj) {
       // usa o repo para chamar oso metodos
        return this.repo.Create(obj);
    }

    @Override
    public Produto Atualizar(Produto obj) {
        // usa o repo para chamar oso metodos
        return this.repo.Update(obj);
    }

    @Override
    public Produto Deletar(int chave) {
        // usa o repo para chamar oso metodos
        return this.repo.Delete(chave);
    }
    
}
