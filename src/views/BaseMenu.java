package views;

import java.util.Scanner;

public abstract class BaseMenu {
    // criando uma instancia de scanner para poder capturar os dados do usuario
    protected Scanner scanner;

    // criando um constructor para instanciar o objt dentro dele
    public BaseMenu() {
        this.scanner = new Scanner(System.in);
    }

    // criando os metodos abstratos para usar na ultima 
    public abstract void ExibirMenu();
    public abstract void Listar();
    public abstract void Localizar();
    public abstract void Adicionar();
    public abstract void Atualizar();
    public abstract void Remover();
}
