
package aula11.ativContas;


public class Conta 
{
    
    private static int contadorId = 0;
    private String titular;
    private String id;
    protected float saldo;
    private String senha;

    public Conta(String titular, String senha) {
        this.titular = titular;
        this.senha = senha;
        this.id = gerarId();
        this.saldo = 0;
    }

    public void depositar(float valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso. Saldo atual: R$ " + saldo);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    private String gerarId() {
        contadorId++;
        return "ID" + contadorId;
    }

    public String getId() {
        return id;
    }

    public boolean validaAcesso(String senha) {
        return this.senha.equals(senha);
    }

    public String getTitular() {
        return titular;
    }

    public float getSaldo() {
        return saldo;
    }
}



