
package aula11.ativContas;


class ContaPoupanca extends Conta {
    public ContaPoupanca(String titular, String senha, float depositoInicial) {
        super(titular, senha);
        this.saldo = depositoInicial;
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

    public String verificaSaldo() {
        return "Saldo atual: R$ " + saldo;
    }
}