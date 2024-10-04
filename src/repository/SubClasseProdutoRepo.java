package repository;

import domain.SubClasseProduto;
import fakedb.SubClasseProdutoFakeDB;

// extendendo da BaseRepository para utiliazr os metodos a ser implementado
public class SubClasseProdutoRepo extends BaseRepository<SubClasseProduto> {

    // criando um atributo para acessar o bancoFakeDB
    private SubClasseProdutoFakeDB db;

    // criando um constructor
    public SubClasseProdutoRepo() {
        // garantindo que a lista seja criada
        this.db = new SubClasseProdutoFakeDB();

        // criando para guardar em fonte de dados
        this.fonteDeDados = this.db.getTabela();
    }

    // implementando os metodos da classe pai do BaseRepository
    // fazer primeiro o Read
    @Override
    public SubClasseProduto Create(SubClasseProduto instancia) {
        // criando uma proxChave para instancia
        // chamando a fonte de dados
        int proxChave = this.fonteDeDados.getLast().getCodigo() + 1;

        // setando o codigo com o setter
        instancia.setCodigo(proxChave);
        // pegando a fonte de dados para add dentro da lista
        this.fonteDeDados.add(instancia);
        // retornando a instancia
        return instancia;

    }

    @Override
    public SubClasseProduto Read(int chave) {
        // algoritmo de busca
        // type | nome qualquer | onde vmos olhar ou buscar
        for (SubClasseProduto scp : this.fonteDeDados) {
            // fazendo comparação com a chave
            // verificando se encontra
            if( scp.getCodigo() == chave ){
                return scp;
            }
        }
        // se não, ele retorna null
        return null;
    }

    @Override
    public SubClasseProduto Update(SubClasseProduto instancia) {
        // verificando se encontra o objt
        SubClasseProduto scp = this.Read(instancia.getCodigo());

        // caso encontrar, ele atualiza
        if(scp != null){
            scp.setDescricao(instancia.getDescricao());
        }
        // se não, ele retorna null
        return null;
    }

    @Override
    public SubClasseProduto Delete(int chave) {
        // verificando se encontra o objt
        SubClasseProduto scp = this.Read(chave);

        // tentando achar o objt para deletar
        if(scp != null){
             // apos achar remove
            this.fonteDeDados.remove(scp);
            // retorna e verifica se é esse que o usuario queria apagar
            return scp;
        }
        return null;
    }
    
}
