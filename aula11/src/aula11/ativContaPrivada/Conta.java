
package aula11.ativContaPrivada;

public class Conta {
   
    private String titular;
    private String identificador;
    private String senha; 
    private float saldo;

    public Conta(String titular, String identificador, String senha, float saldoInicial) {
        this.titular = titular;
        this.identificador = identificador;
        this.senha = senha;
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void depositar(float valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Deposito de R$ " + valor + " realizado com sucesso. Saldo atual: R$ " + saldo);
        } else {
            System.out.println("Valor de deposito inválido.");
        }
    }

    public boolean sacar(float valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso. Saldo atual: R$ " + saldo);
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor de saque invalido.");
            return false;
        }
    }

    public float consultarSaldo() {
        return saldo;
    }

    public boolean verificarSenha(String senhaDigitada) {
        return senha.equals(senhaDigitada);
    }
}

