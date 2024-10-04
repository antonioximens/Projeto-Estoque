package views;

import java.util.ArrayList;

import domain.ClasseProduto;
import service.ClasseProdutoService;

// classe de funcionalidade
public class ClasseProdutoView {
    public ClasseProdutoView() {
        // VAZIO
    }

    // fazendo uma funcionalidade
    // metodo
    public void Exibir() {
        // instanciando a ClasseProdutoRepo para usar
        ClasseProdutoService srv = new ClasseProdutoService();

        // criando uma lista com os dados da tabela (Pai)
        ArrayList<ClasseProduto> lista = srv.LerTodos();

        System.out.println("==========================");
        // criando um for para percorrer a lista
        // for ( "o tipo" "variavel que recebe" : "da onde vem?")
        for (ClasseProduto cp : lista) {
            this.Imprimir(cp);
        }

    }

    private void Imprimir(ClasseProduto cp) {

        // imprimindo as informações
        System.out.println("Classe de Produto");
        System.out.println("Código: " + cp.getCodigo());
        System.out.println("Descrição: " + cp.getDescricao());
        System.out.println("data de inclusão: " + cp.getDataDeInclusao());
        System.out.println("\n----------------------------------\n");
    }
}