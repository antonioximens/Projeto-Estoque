package repository;

import java.util.ArrayList;

// Classe Base Abstrata
public abstract class BaseRepository<TDominio> {

    protected ArrayList<TDominio> fonteDeDados;

    // utilizando o CRUD
    // Criar algo, precisar saber o que vai ser criado, logo uma instacia de um objt
    // tipo: TDominio / oque é: instancia
    public abstract TDominio Create(TDominio instancia);

    // Ler todos, logo é um método real
    public ArrayList<TDominio> ReadAll() {
        return this.fonteDeDados;
    }

    // Ler algo especifico, logo precisa de um identificador
    public abstract TDominio Read(int chave);

    // atualizar algo, logo precisa achar o objeto a ser atualizado
    public abstract TDominio Update(TDominio instancia);

    // Apagar algo, logo precisa de um identificador
    public abstract TDominio Delete(int chave);
}
