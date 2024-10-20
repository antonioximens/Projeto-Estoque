package views;

import java.time.LocalDate;
import java.util.ArrayList;

import domain.Produto;
import service.ProdutoService;


public class ProdutoMenu extends BaseMenu {
   // criando uma rota de serviço para instnaciara dentro do constructor
    private ProdutoService srv;

    // criando um constructor e nao esquecer de usar o super()
    public ProdutoMenu(){
        super();
        this.srv = new ProdutoService();
    }
    @Override
    public void ExibirMenu() {
       // criando um menu
       int opcao = 0;

       while(opcao != 9)
       {
            // add limpar console antes das opcoes
            Util.ClearConsole();
            // colocando as opções
            System.out.println("Produto");
            System.out.println("Menu de Opções");
            System.out.println("1 - Listar");
            System.out.println("2 - Localizar");
            System.out.println("3 - Adicionar");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Remover");
            System.out.println("9 - Sair");
            System.out.print("Digite sua opção: ");

            // colocando a opcao para ser lida 
            opcao = this.scanner.nextInt();   
            
            // criando um switch para validar a opcao
            switch (opcao) {
                case 1:
                    this.Listar();
                    break;
                case 2:
                    this.Localizar();
                    break;
                case 3:
                    this.Adicionar();
                    break;
                case 4:
                    this.Atualizar();
                    break;
                case 5:
                    this.Remover();
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    @Override
    public void Listar() {
        // add o limpa console
        Util.ClearConsole();
        System.out.println("Listando...");
 
        // Criar uma lista com os objtos para pode ver
        ArrayList<Produto> lista = this.srv.LerTodos();

        // criar um forEach para listar os dados e percorrer a lista
        for (Produto pdt : lista) {
            this.ImprimirEmLinha(pdt);
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Localizar() {
        // limpar primeiro o console
        Util.ClearConsole();
        System.out.println("Localizando...");

        System.out.println("Informe o código do Produto: ");
        int codigo = this.scanner.nextInt();

        Produto pdt = this.srv.Ler(codigo);
        if(pdt != null){
            this.ImprimirEmLinha(pdt);
        } else {
            System.out.println("Problema - Produto não foi encontrada");
        }
    }

    @Override
    public void Adicionar() {
       // metodo adicionar, antes tem que add o limpa console
       Util.ClearConsole();
       System.out.println("Adicionando...");

       // adicionando a descrição da classe produto
       System.out.println("Informe a Descrição do Produto: ");
       String descricao = this.scanner.next();

       // instanciando um novo objt da classe produto
       Produto pdt = new Produto();
       pdt.setCodigo(0);
       pdt.setDescricao(descricao);
       pdt.setDataDeInclusao(LocalDate.now());

       Produto pdtNovo = this.srv.Criar(pdt);
       if(pdtNovo != null) {
        System.out.println("Produto adicionada com sucesso");
       } else {
        System.out.println("Problema - Produto não foi adicionada");
       }

       // criando s nextLine para evitar bug
       System.out.println("Clique <ENTER> para continuar...");
       this.scanner.nextLine();
       this.scanner.nextLine();
    }

    @Override
    public void Atualizar() {
        // metodo atualizar, antes tem que add o limpa console
        Util.ClearConsole();
        System.out.println("Atualizando....");

        System.out.println("Informe o código do Produto: ");
        int codigo = this.scanner.nextInt();

        Produto pdt = this.srv.Ler(codigo);

        if(pdt != null){
            System.out.println("Informe a nova Descrição para este Produto: ");
            String descricao = this.scanner.next();
            pdt.setDescricao(descricao);

            if(this.srv.Atualizar(pdt) != null){
                System.out.println("Produto atualizada com sucesso");
            } else {
                System.out.println("Problema - Produto não foi atualizada");
            }
        } else {
            System.out.println("Problema - Produto não foi encontrada");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Remover() {
        // metodo Remover, antes tem que add o limpa console
        Util.ClearConsole();
        System.out.println("Removendo....");

        // pegar o numero do id para remover
        System.out.println("Informe o código do Produto: ");
        int codigo = this.scanner.nextInt();

        // verificando se existe o codigo informado
        Produto pdt = this.srv.Ler(codigo);

        // devolvendo e removnedo o objt
        if(pdt != null){
            if(this.srv.Deletar(codigo) != null){
                System.out.println("Produto removida com sucesso");
            } else {
                System.out.println("Problema - Produto não foi removida");
            }
        } else {
            System.out.println("Problema - Produto não foi encontrada");
        }
    }

    // metodo de imprimir lista
    private void ImprimirEmLinha(Produto pdt){
        String msg = "Produto - ";
        msg += "Código: " + pdt.getCodigo() + " | ";
        msg += "Descrição: " + pdt.getDescricao() + " | ";
        msg += "Data de Inclusão: " + pdt.getDataDeInclusao();
        System.out.println(msg);
    }
}
