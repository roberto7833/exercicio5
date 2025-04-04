package br.ufpb.roberto.exercicio5;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

public class ProgramaAgenda implements Agenda{
    private GravadorDeDados gravadorDeContatos;
    private Map<String, Contato> contatosMap;

    public ProgramaAgenda(){
        this.gravadorDeContatos = new GravadorDeDados();
        this.contatosMap = new HashMap<>();
    }

    @Override
    public void cadastrarContato(String nome, int dia, int mes) {
        if(!contatosMap.containsKey(nome)){
            Contato contato = new Contato(nome, dia, mes);
            contatosMap.put(nome, contato);
        }
    }
    @Override
    public Contato pesquisaAniversariantes(int dia, int mes) {
       //ArrayList<Contato> aniversariantes = new ArrayList<>();
       for(Contato c: contatosMap.values()){
           if(c.getDiaAniversario()==dia && c.getMesAniversario()==mes){
              //aniversariantes.add(c);
               return c;
           }
       }
       return null;
    }
    @Override
    public boolean removerDados(String nome) throws ContatoInexistenteException {
        if(!contatosMap.containsKey(nome)){
            throw new ContatoInexistenteException("Contato não encontrado");
        }
        contatosMap.remove(nome);
        return true;
    }
    @Override
    public void salvarDados() throws IOException {
        this.gravadorDeContatos.gravarContato(this.contatosMap.values());
    }
    @Override
    public void recuperarDados() throws IOException {
        Collection<Contato> contatosAchados = this.gravadorDeContatos.recuperarContatos();
        for(Contato c: contatosAchados){
            this.cadastrarContato(c.getNome(),c.getDiaAniversario(),c.getMesAniversario());
        }
    }
}
