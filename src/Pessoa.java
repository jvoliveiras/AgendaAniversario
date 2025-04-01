package src;

import java.util.ArrayList;

public class Pessoa {
    private String nome, telefone, email;
    private Data dataDeAniversario;

    public Pessoa(String nome, String telefone, String email, Data dataDeAniversario){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataDeAniversario = dataDeAniversario;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Data getDataDeAniversario() {
        return this.dataDeAniversario;
    }
    public void setDataDeAniversario(Data dataAniv) {
        this.dataDeAniversario = dataAniv;
    }

    public String toString() {
        return "Nome: " + this.nome + "\t Telefone: " + this.telefone + "\t Email: " + this.email + "\t Data Aniv: " + this.dataDeAniversario.dia+"/"+this.dataDeAniversario.mes;
    } 



}
