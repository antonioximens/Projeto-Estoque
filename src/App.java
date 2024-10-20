import views.ClasseProdutoMenu;
import views.ProdutoMenu;
import views.SubClasseProdutoMenu;

public class App {
    public static void main(String[] args) throws Exception {
        // instanciando a ClasseProdutoView para poder testar
        //ClasseProdutoMenu menuzinho1 = new ClasseProdutoMenu();

        // chamando o metodo da visao product
        //menuzinho1.ExibirMenu();

        // instanciando a SubClasseProdutoView
        //SubClasseProdutoMenu menuzinho2 = new SubClasseProdutoMenu();

        // chamando o metodo visao da SubClasseProdutoView
        //menuzinho2.ExibirMenu();

        // instanciando a classe produto
        ProdutoMenu menuzinho3 = new ProdutoMenu();

        // chamando o metodo visao da Classe produtoview
        menuzinho3.ExibirMenu();
    }
}
