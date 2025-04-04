package br.ufpb.roberto.exercicio5;

import java.io.Serializable;
import java.util.Objects;

public class Contato implements Serializable{
    private String nome;
    private int diaAniversario;
    private int mesAniversario;

    public Contato(String nome, int diaAniversario, int mesAniversario) {
        this.nome = nome;
        this.diaAniversario = diaAniversario;
        this.mesAniversario = mesAniversario;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getDiaAniversario() {
        return this.diaAniversario;
    }
    public void setDiaAniversario(int diaAniversario) {
        this.diaAniversario = diaAniversario;
    }
    public int getMesAniversario() {
        return this.mesAniversario;
    }
    public void setMesAniversario(int mesAniversario) {
        this.mesAniversario = mesAniversario;
    }
    @Override
    public String toString(){
        return "Nome "+this.nome+" dia Aniversario "+this.diaAniversario+" do mês "+this.mesAniversario;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return diaAniversario == contato.diaAniversario && mesAniversario == contato.mesAniversario && Objects.equals(nome, contato.nome);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nome, diaAniversario, mesAniversario);
    }
}
