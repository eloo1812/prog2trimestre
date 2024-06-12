package aula10.ativBanco;

import java.util.Scanner;

public class Banco {
    Conta[] contas;
    int numContas;
    Scanner ler;

    public Banco() {
        contas = new Conta[20]; 
        numContas = 0; 
        ler = new Scanner(System.in);
    }

    public void iniciar() {
        String opcao;
        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Consultar saldo");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Listar todas as contas");
            System.out.println("6 - Sair");
            System.out.print(": ");
            opcao = ler.next();

            switch (opcao) {
                case "1":
                    criarConta();
                    break;
                case "2":
                    consultarSaldo();
                    break;
                case "3":
                    depositar();
                    break;
                case "4":
                    sacar();
                    break;
                case "5":
                    listarContas();
                    break;
                case "6":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("6"));
    }

    void criarConta() {
        System.out.print("Nome do titular: ");
        String titular = ler.next();
        System.out.print("Identificador: ");
        String identificador = ler.next();
        System.out.print("Senha: ");
        String senha = ler.next(); 
        System.out.print("Saldo inicial: ");
        float saldoInicial = ler.nextFloat();

        Conta novaConta = new Conta(titular, identificador, senha, saldoInicial);
        contas[numContas] = novaConta;
        numContas++;

        System.out.println("Conta criada com sucesso!");
    }

    Conta buscarConta(String identificador, String senha) {
        for (int i = 0; i < numContas; i++) {
            if (contas[i].identificador.equals(identificador) && contas[i].verificarSenha(senha)) {
                return contas[i];
            }
        }
        return null;
    }

    void consultarSaldo() {
        System.out.print("Identificador da conta: ");
        String identificador = ler.next();
        System.out.print("Senha: ");
        String senha = ler.next();
        Conta conta = buscarConta(identificador, senha);
        if (conta != null) {
            System.out.println("Saldo atual: R$ " + conta.consultarSaldo());
        } else {
            System.out.println("Conta não encontrada ou senha incorreta.");
        }
    }

    void depositar() {
        System.out.print("Identificador da conta: ");
        String identificador = ler.next();
        System.out.print("Senha: ");
        String senha = ler.next();
        Conta conta = buscarConta(identificador, senha);
        if (conta != null) {
            System.out.print("Valor do depósito: R$ ");
            float valor = ler.nextFloat();
            conta.depositar(valor);
        } else {
            System.out.println("Conta não encontrada ou senha incorreta.");
        }
    }

    void sacar() {
        System.out.print("Identificador da conta: ");
        String identificador = ler.next();
        System.out.print("Senha: ");
        String senha = ler.next();
        Conta conta = buscarConta(identificador, senha);
        if (conta != null) {
            System.out.print("Valor do saque: R$ ");
            float valor = ler.nextFloat();
            conta.sacar(valor);
        } else {
            System.out.println("Conta não encontrada ou senha incorreta.");
        }
    }

    void listarContas() {
        if (numContas == 0) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            System.out.println("Contas cadastradas:");
            for (int i = 0; i < numContas; i++) {
                System.out.println(contas[i].identificador + " - Titular: " + contas[i].titular + " - Saldo: R$ " + contas[i].saldo);
            }
        }
    }

    public static void main(String[] args) {
        Banco banco = new Banco();
        banco.iniciar();
    }
}
