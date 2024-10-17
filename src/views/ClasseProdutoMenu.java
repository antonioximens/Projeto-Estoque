package views;

import java.time.LocalDate;
import java.util.ArrayList;

import domain.ClasseProduto;
import service.ClasseProdutoService;


public class ClasseProdutoMenu extends BaseMenu {
    
    // declarando o srv para usar no listar assim fazendo requisições dentr do sistema
    private ClasseProdutoService srv;

    // criando o constructor da classe para pegar o scanner do pai
    // alem de instanciar a classe serviço para usar no listar
    public ClasseProdutoMenu(){
        super();
        this.srv = new ClasseProdutoService();
    }

    // implementando os metodos do pai 
    @Override
    public void ExibirMenu() {
       // criando uma opcao
       int op = 0;

       // criando uma repetiçao para executar o menu
       while(op != 9){

            // passando a lista do menu e coloando o limpa console
            Util.ClearConsole();
            System.out.println("Classe Produto: ");
            System.out.println("Menu de Opções");
            System.out.println("1- Listar");
            System.out.println("2- Localizar");
            System.out.println("3- Adicionar");
            System.out.println("4- Atualizar");
            System.out.println("5- Remover");
            System.out.println("9- Sair");
            
            // chamando a op para ser lida
            op = this.scanner.nextInt();

            // logo cria um switch case para olhar as opcoesss
            switch (op) {
                // opcao de listar as classes
                case 1:
                    // chamando com o this o metodo que esta no pai e implementado qui
                    this.Listar();
                    break;
                case 2:
                    // chamando com o this o metodo que esta no pai e implementado qui
                    this.Localizar();
                    break;
                    case 3:
                    // chamando com o this o metodo que esta no pai e implementado qui
                    this.Adicionar();
                    break;
                    case 4:
                    // chamando com o this o metodo que esta no pai e implementado qui
                    this.Atualizar();
                    break;
                    case 5:
                    // chamndo com o this o metodo que esta no pai e implementado qui
                    this.Remover();
                    break;
                    case 9:
                    System.out.println("Encerrando Sitema\nSaindo...");
                    break;
            
                default:
                System.out.println("Opção invalida!");
                    break;
            }
       }
    }

    @Override
    public void Listar() {
        // metodo listar, antes tem que add o limpa console
        Util.ClearConsole();
        System.out.println("Listando...\n");
        
        // declarando o ArrayList para percorrer a lista e seu tipo
        // que recebe srv pois ele faz o caminho
        ArrayList<ClasseProduto> lista = this.srv.LerTodos();
        for (ClasseProduto cp : lista) {
            this.ImprimirEmLinha(cp);
        } 

        // msg para o usuario clicar no enter e usando dois netxLine para nao dar bug
        // quanndo for digitar
        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
       
    }

    @Override
    public void Localizar() {
       // metodo localizar, antes tem que add o limpa console
       Util.ClearConsole();
       System.out.println("Localizando...");

       // pegando o id para saber qual objto achar
       System.out.println("Informe o código da Classe de Produto: ");
       int codigo = this.scanner.nextInt();

       // Chamando a classe produto o metodo ler para achar item especifico
       ClasseProduto cp = this.srv.Ler(codigo);

       // verificando se encontrou o item
       if( cp != null){
        // se encontrou ele retorna o obj
            this.ImprimirEmLinha(cp);
       } else {
        // se nao elel mostra a msg de erro
            System.out.println("Problema: - Classe Produto não encontrada.");
       }
       
       // msg para o usuario clicar no enter e usando dois netxLine para nao dar bug
       // quanndo for digitar
       System.out.println("Clique <ENTER> para continuar...");
       this.scanner.nextLine();
       this.scanner.nextLine();

    }

    @Override
    public void Adicionar() {
       // metodo adicionar, antes tem que add o limpa console
       Util.ClearConsole();
       System.out.println("Adicionando...");

       // adicionando a descrição da classe produto
       System.out.println("Informe a Descrição da Classe de Produto: ");
       String descricao = this.scanner.next();

       // instanciando um novo objt da classe produto
       ClasseProduto cp = new ClasseProduto();
       cp.setCodigo(0);
       cp.setDescricao(descricao);
       cp.setDataDeInclusao(LocalDate.now());

       ClasseProduto cpNovo = this.srv.Criar(cp);
       if(cpNovo != null) {
        System.out.println("Classe de Produto adicionada com sucesso");
       } else {
        System.out.println("Problema - Classe de Produto não foi adicionada");
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

        System.out.println("Informe o código da Classe de Produto: ");
        int codigo = this.scanner.nextInt();

        ClasseProduto cp = this.srv.Ler(codigo);

        if(cp != null){
            System.out.println("Informe a nova Descrição para esta Classe de Produto: ");
            String descricao = this.scanner.next();
            cp.setDescricao(descricao);

            if(this.srv.Atualizar(cp) != null){
                System.out.println("Classe de Produto atualizada com sucesso");
            } else {
                System.out.println("Problema - Classe de Produto não foi atualizada");
            }
        } else {
            System.out.println("Problema - Classe de Produto não foi encontrada");
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
        System.out.println("Informe o código da Classe de Produto: ");
        int codigo = this.scanner.nextInt();

        // verificando se existe o codigo informado
        ClasseProduto cp = this.srv.Ler(codigo);

        // devolvendo e removnedo o objt
        if(cp != null){
            if(this.srv.Deletar(codigo) != null){
                System.out.println("Classe de Produto removida com sucesso");
            } else {
                System.out.println("Problema - Classe de Produto não foi removida");
            }
        } else {
            System.out.println("Problema - Classe de Produto não foi encontrada");
        }
    }

    // metodo de imprimir lista
    private void ImprimirEmLinha(ClasseProduto cp){
        String msg = "Classe de Produto - ";
        msg += "Código: " + cp.getCodigo() + " | ";
        msg += "Descrição: " + cp.getDescricao() + " | ";
        msg += "Data de Inclusão: " + cp.getDataDeInclusao();
        System.out.println(msg);
    }

}
