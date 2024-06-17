
package aula11.ativContas;

import java.util.Scanner;
public class Principal {
    private static Scanner ler = new Scanner(System.in);
    private static Conta[] contas = new Conta[20];
    private static int numContas = 0;

    public static void main(String[] args) {
        String opcao;
        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Criar conta corrente");
            System.out.println("2 - Criar conta poupança");
            System.out.println("3 - Consultar saldo");
            System.out.println("4 - Depositar");
            System.out.println("5 - Sacar");
            System.out.println("6 - Listar todas as contas");
            System.out.println("7 - Sair");
            System.out.print(": ");
            opcao = ler.next();

            switch (opcao) {
                case "1":
                    criarContaCorrente();
                    break;
                case "2":
                    criarContaPoupanca();
                    break;
                case "3":
                    consultarSaldo();
                    break;
                case "4":
                    depositar();
                    break;
                case "5":
                    sacar();
                    break;
                case "6":
                    listarContas();
                    break;
                case "7":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("7"));
    }

    private static void criarContaCorrente() {
        System.out.print("Nome do titular: ");
        String titular = ler.next();
        System.out.print("Senha: ");
        String senha = ler.next();
        System.out.print("Limite: ");
        float limite = ler.nextFloat();
        
        ContaCorrente novaConta = new ContaCorrente(titular, senha, limite);
        contas[numContas] = novaConta;
        numContas++;

        System.out.println("Conta corrente criada com sucesso!");
    }

    private static void criarContaPoupanca() {
        System.out.print("Nome do titular: ");
        String titular = ler.next();
        System.out.print("Senha: ");
        String senha = ler.next();
        System.out.print("Depósito inicial: ");
        float depositoInicial = ler.nextFloat();
        
        ContaPoupanca novaConta = new ContaPoupanca(titular, senha, depositoInicial);
        contas[numContas] = novaConta;
        numContas++;

        System.out.println("Conta poupança criada com sucesso!");
    }

    private static Conta buscarConta(String identificador, String senha) {
        for (int i = 0; i < numContas; i++) {
            if (contas[i].getId().equals(identificador) && contas[i].validaAcesso(senha)) {
                return contas[i];
            }
        }
        return null;
    }

    private static void consultarSaldo() {
        System.out.print("Identificador da conta: ");
        String identificador = ler.next();
        System.out.print("Senha: ");
        String senha = ler.next();
        Conta conta = buscarConta(identificador, senha);
        if (conta != null) {
            if (conta instanceof ContaCorrente) {
                ContaCorrente cc = (ContaCorrente) conta;
                System.out.println("Saldo da Conta Corrente: " + cc.verificaSaldo());
            } else if (conta instanceof ContaPoupanca) {
                ContaPoupanca cp = (ContaPoupanca) conta;
                System.out.println("Saldo da Conta Poupança: " + cp.verificaSaldo());
            }
        } else {
            System.out.println("Conta não encontrada ou senha incorreta.");
        }
    }

    private static void depositar() {
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

    private static void sacar() {
        System.out.print("Identificador da conta: ");
        String identificador = ler.next();
        System.out.print("Senha: ");
        String senha = ler.next();
        Conta conta = buscarConta(identificador, senha);
        if (conta != null) {
            System.out.print("Valor do saque: R$ ");
            float valor = ler.nextFloat();
            boolean sucesso = false;
            if (conta instanceof ContaCorrente) {
                ContaCorrente cc = (ContaCorrente) conta;
                sucesso = cc.sacar(valor);
            } else if (conta instanceof ContaPoupanca) {
                ContaPoupanca cp = (ContaPoupanca) conta;
                sucesso = cp.sacar(valor);
            }

            if (sucesso) {
                System.out.println("Saque realizado com sucesso.");
            } else {
                System.out.println("Não foi possível realizar o saque.");
            }
        } else {
            System.out.println("Conta não encontrada ou senha incorreta.");
        }
    }

    private static void listarContas() {
        if (numContas == 0) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            System.out.println("Contas cadastradas:");
            for (int i = 0; i < numContas; i++) {
                Conta conta = contas[i];
                if (conta instanceof ContaCorrente) {
                    ContaCorrente cc = (ContaCorrente) conta;
                    System.out.println("Conta Corrente - ID: " + cc.getId() + ", Titular: " + cc.getTitular() + ", Saldo: R$ " + cc.getSaldo() + ", Limite: R$ " + cc.verificaSaldo());
                } else if (conta instanceof ContaPoupanca) {
                    ContaPoupanca cp = (ContaPoupanca) conta;
                    System.out.println("Conta Poupança - ID: " + cp.getId() + ", Titular: " + cp.getTitular() + ", Saldo: R$ " + cp.getSaldo());
                }
            }
        }
    }
}

    

