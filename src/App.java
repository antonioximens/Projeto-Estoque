import views.ClasseProdutoView;
import views.ProdutoView;
import views.SubClasseProdutoView;

public class App {
    public static void main(String[] args) throws Exception {
        // instanciando a ClasseProdutoView para poder testar
        ClasseProdutoView view1 = new ClasseProdutoView();

        // chamando o metodo da visao product
        view1.Exibir();

        // instanciando a SubClasseProdutoView
        SubClasseProdutoView view2 = new SubClasseProdutoView();

        // chamando o metodo visao da SubClasseProdutoView
        view2.Exibir2();

        // instanciando a classe produto
        ProdutoView view3 = new ProdutoView();

        // chamando o metodo visao da Classe produtoview
        view3.Exibir3();
    }
}
