package repository;

import domain.ClasseProduto;
import fakedb.ClasseProdutoFakeDB;

// extendendo da BaseRepository para utiliazr os metodos a ser implementado
public class ClasseProdutoRepo extends BaseRepository<ClasseProduto> {

    // criando um atributo para acessar o bancoFakeDB
    private ClasseProdutoFakeDB db;

    // criando um constructor
    public ClasseProdutoRepo() {
        // garantindo que a lista seja criada
        this.db = new ClasseProdutoFakeDB();

        // criando para guardar em fonte de dados
        this.fonteDeDados = this.db.getTabela();
    }

    // implementando os metodos da classe pai do BaseRepository
    // fazer primeiro o Read
    @Override
    public ClasseProduto Create(ClasseProduto instancia) {
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
    public ClasseProduto Read(int chave) {
        // algoritmo de busca
        // type | nome qualquer | onde vmos olhar ou buscar
        for (ClasseProduto cp : this.fonteDeDados) {
            // fazendo comparação com a chave
            // verificando se encontra
            if (cp.getCodigo() == chave) {
                return cp;
            }
        }
        // se não, ele retorna null
        return null;
    }

    @Override
    public ClasseProduto Update(ClasseProduto instancia) {
        // verificando se encontra o objt
        ClasseProduto cp = this.Read(instancia.getCodigo());

        // caso encontrar, ele atualiza
        if (cp != null) {
            cp.setDescricao(instancia.getDescricao());
            return cp;
        }
        // se não, ele retorna null
        return null;
    }

    @Override
    public ClasseProduto Delete(int chave) {
        // verificando se encontra o objt
        ClasseProduto cp = this.Read(chave);

        // tentando achar o objt para deletar
        if (cp != null) {
            // apos achar remove
            this.fonteDeDados.remove(cp);
            // retorna e verifica se é esse que o usuario queria apagar
            return cp;
        } else {
            return null;
        }
    }

}
