package objetos;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private String nome;
    private String sobrenome;
    private String cpf;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString(){
        return "nome: "+nome+" "+sobrenome+" "+"CPF: "+cpf;
    }
}