package br.ufpb.roberto.exercicio5;

import java.io.IOException;

public interface Agenda {
    void cadastrarContato(String nome, int dia, int mes);
    Contato pesquisaAniversariantes(int dia, int mes);
    boolean removerDados(String nome)throws ContatoInexistenteException;
    void salvarDados()throws IOException;
    void recuperarDados() throws IOException;
}
