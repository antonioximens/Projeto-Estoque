package repository;

import domain.Produto;
import fakedb.ProdutoFakeDB;

public class ProdutoRepo extends BaseRepository<Produto> {

     // criando um atributo para acessar o bancoFakeDB
    private ProdutoFakeDB db;

     // criando um constructor
    public ProdutoRepo(){
        // garantindo que a lista seja criada
        this.db = new ProdutoFakeDB();
         // criando para guardar em fonte de dados
        this.fonteDeDados = this.db.getTabela();

    }

    // implementando os metodos da classe pai do BaseRepository
    // fazer primeiro o Read
    @Override
    public Produto Create(Produto instancia) {
         // criando uma proxChave para instancia
        int proxChave = this.fonteDeDados.getLast().getCodigo() + 1;

        // setando o codigo com o setter
        instancia.setCodigo(proxChave);
         // pegando a fonte de dados para add dentro da lista
        this.fonteDeDados.add(instancia);
         // retornando a instancia
        return instancia;
    }

    @Override
    public Produto Read(int chave) {
        // algoritmo de busca
        // type | nome qualquer | onde vmos olhar ou buscar
        for (Produto pdt : this.fonteDeDados) {
            // fazendo comparação com a chave
            // verificando se encontra
            if(pdt.getCodigo() == chave){
                return pdt;
            }
        }
        // retorna null caso não ache
        return null;
    }

    @Override
    public Produto Update(Produto instancia) {
        // verificando se encontra o objt
        Produto pdt = this.Read(instancia.getCodigo());

        // caso encontrar, ele atualiza
        if(pdt != null){
            pdt.setDescricao(pdt.getDescricao());
            return pdt;
        }
         // se não, ele retorna null
        return null;
        
    }

    @Override
    public Produto Delete(int chave) {
        // verificando se encontra o objt
        Produto pdt = this.Read(chave);
        // retorna e verifica se é esse que o usuario queria apagar
        if(pdt != null){
            // apos achar remove
            this.fonteDeDados.remove(pdt);
            // retorna e verifica se é esse que o usuario queria apagar
            return pdt;
        }
        return null;
    }
    
}
