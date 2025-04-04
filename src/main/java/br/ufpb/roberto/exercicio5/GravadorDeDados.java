package br.ufpb.roberto.exercicio5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class GravadorDeDados {
    private String arquivoAgenda;

    public GravadorDeDados(){
        this.arquivoAgenda = "arquivo.dat";
    }
    public void gravarContato(Collection<Contato> contatos)throws IOException{
        ArrayList<Contato> contatosArrayList = new ArrayList<>();
        contatosArrayList.addAll(contatos);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivoAgenda))){
            out.writeObject(contatosArrayList);
        }
    }
    public Collection<Contato> recuperarContatos()throws IOException{
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivoAgenda))){
            Collection<Contato> contatosAchados = (ArrayList<Contato>) in.readObject();
            return contatosAchados;
        }catch (ClassNotFoundException | ClassCastException e){
            throw new IOException();
        }
    }
}
