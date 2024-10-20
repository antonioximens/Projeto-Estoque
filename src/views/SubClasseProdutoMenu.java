package views;

import java.time.LocalDate;
import java.util.ArrayList;

import domain.SubClasseProduto;
import service.SubClasseProdutoService;

public class SubClasseProdutoMenu extends BaseMenu {
    // criando uma rota de serviço para instnaciara dentro do constructor
    private SubClasseProdutoService srv;

    // criando um constructor e nao esquecer de usar o super()
    public SubClasseProdutoMenu(){
        super();
        this.srv = new SubClasseProdutoService();
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
            System.out.println("SubClasseProduto");
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
        ArrayList<SubClasseProduto> lista = this.srv.LerTodos();

        // criar um forEach para listar os dados e percorrer a lista
        for (SubClasseProduto scp : lista) {
            this.ImprimirEmLinha(scp);
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

        System.out.println("Informe o código da SubClasseProduto: ");
        int codigo = this.scanner.nextInt();

        SubClasseProduto scp = this.srv.Ler(codigo);
        if(scp != null){
            this.ImprimirEmLinha(scp);
        } else {
            System.out.println("Problema - Classe de Produto não foi encontrada");
        }
    }

    @Override
    public void Adicionar() {
       // metodo adicionar, antes tem que add o limpa console
       Util.ClearConsole();
       System.out.println("Adicionando...");

       // adicionando a descrição da classe produto
       System.out.println("Informe a Descrição da SubClasseProduto: ");
       String descricao = this.scanner.next();

       // instanciando um novo objt da classe produto
       SubClasseProduto scp = new SubClasseProduto();
       scp.setCodigo(0);
       scp.setDescricao(descricao);
       scp.setDataDeInclusao(LocalDate.now());

       SubClasseProduto scpNovo = this.srv.Criar(scp);
       if(scpNovo != null) {
        System.out.println("SubClasseProduto adicionada com sucesso");
       } else {
        System.out.println("Problema - SubClasseProduto não foi adicionada");
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

        System.out.println("Informe o código da SubClasseProduto: ");
        int codigo = this.scanner.nextInt();

        SubClasseProduto scp = this.srv.Ler(codigo);

        if(scp != null){
            System.out.println("Informe a nova Descrição para esta SubClasseProduto: ");
            String descricao = this.scanner.next();
            scp.setDescricao(descricao);

            if(this.srv.Atualizar(scp) != null){
                System.out.println("SubClasseProduto atualizada com sucesso");
            } else {
                System.out.println("Problema - SubClasseProduto não foi atualizada");
            }
        } else {
            System.out.println("Problema - SubClasseProduto não foi encontrada");
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
        System.out.println("Informe o código da SubClasseProduto: ");
        int codigo = this.scanner.nextInt();

        // verificando se existe o codigo informado
        SubClasseProduto scp = this.srv.Ler(codigo);

        // devolvendo e removnedo o objt
        if(scp != null){
            if(this.srv.Deletar(codigo) != null){
                System.out.println("SubClasseProduto removida com sucesso");
            } else {
                System.out.println("Problema - SubClasseProduto não foi removida");
            }
        } else {
            System.out.println("Problema - SubClasseProduto não foi encontrada");
        }
    }

    // metodo de imprimir lista
    private void ImprimirEmLinha(SubClasseProduto scp){
        String msg = "SubClasseProduto - ";
        msg += "Código: " + scp.getCodigo() + " | ";
        msg += "Descrição: " + scp.getDescricao() + " | ";
        msg += "Data de Inclusão: " + scp.getDataDeInclusao();
        System.out.println(msg);
    }
    
}
