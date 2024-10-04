package views;

import java.util.ArrayList;

import domain.SubClasseProduto;
import service.SubClasseProdutoService;

public class SubClasseProdutoView {
    // criando um constructor vazio
    public SubClasseProdutoView() {
        // vazio
    }

    // fazendo um metodo para exibir
    public void Exibir2() {

        // instanciando a SubClasseProdutoService para usar
        SubClasseProdutoService srv = new SubClasseProdutoService();

        // criando uma lista com os dados da tabela (Pai)
        ArrayList<SubClasseProduto> lista = srv.LerTodos();

        System.out.println("==========================");
        // criando um for para percorrer a lista
        // for ( "o tipo" "variavel que recebe" : "da onde vem?")
        for (SubClasseProduto scp : lista) {
            // imprimindo as informações
            this.Imprimir(scp);
           
        }

    }

    private void Imprimir(SubClasseProduto scp){
        // imprimindo as informações
        System.out.println("SubClasse Produto ");
        System.out.println("Código: " + scp.getCodigo());
        System.out.println("Descrição: " + scp.getDescricao());
        System.out.println("Data de Inclusão: " + scp.getDataDeInclusao());
        System.out.println("Código da Classe: " + scp.getCodigoClasse());
        System.out.println("\n----------------------------------\n");
    }

}
