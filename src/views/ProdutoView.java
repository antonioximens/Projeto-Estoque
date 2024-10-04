package views;

import java.util.ArrayList;

import domain.Produto;
import service.ProdutoService;

public class ProdutoView {
    // criando um constructor vazio caso precise implementar algo
    public ProdutoView() {
        // vazio
    }

    // fazendo um metodo para exibir
    public void Exibir3() {
            // instanciando a Produto para usar
        ProdutoService srv = new ProdutoService();
        
        // criando uma lista com os dados da tabela (Pai)
        ArrayList<Produto> lista = srv.LerTodos();

        System.out.println("==========================");
        // criando um for para percorrer a lista
        // for ( "o tipo" "variavel que recebe" : "da onde vem?")
        for (Produto pdt : lista) {
            this.Imprimir(pdt);

        }

    }

    private void Imprimir(Produto pdt){
         // imprimindo as informações
         System.out.println("Produto: ");
         System.out.println("Código: " + pdt.getCodigo());
         System.out.println("Descrição: " + pdt.getDescricao());
         System.out.println("Data de inclusão: " + pdt.getDataDeInclusao());
         System.out.println("Código SubClasse: " + pdt.getCodigoSubclasse());
         System.out.println("Valor:" + pdt.getValor());
         System.out.println("\n----------------------------------\n");
    }
}
