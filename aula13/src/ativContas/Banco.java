package ativContas;

import objetos.Pessoa;

import java.io.*;
import java.util.Scanner;

public class Banco {
        private static Scanner ler = new Scanner(System.in);
        private static ContaPoupanca[] contasPoupanca = new ContaPoupanca[20];
        private static ContaCorrente[] contasCorrente = new ContaCorrente[20];
        private static int numContasPoupanca = 0;
        private static int numContasCorrente = 0;


        public static void main(String[] args) {
            carregarContasDoArquivoPoupanca();
            carregarContasDoArquivoCorrente();

            String opcao;
            do {
                System.out.println("Selecione uma opção:");
                System.out.println("1 - Criar conta corrente");
                System.out.println("2 - Criar conta poupança");
                System.out.println("3 - Consultar saldo de Conta Poupança");
                System.out.println("4 - Depositar em Conta Poupança");
                System.out.println("5 - Sacar Conta Poupança");
                System.out.println("6 - Listar todas as contas poupança");
                System.out.println("7 - Listar todas as contas corrente");
                System.out.println("8 - Consultar saldo de Conta Corrente");
                System.out.println("9 - Depositar em Conta Corrente");
                System.out.println("10 - Sacar Conta Corrente");
                System.out.println("11 - Sair");
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
                        consultarSaldoPoupanca();
                        break;
                    case "4":
                        depositarPoupanca();
                        break;
                    case "5":
                        sacarPoupanca();
                        break;
                    case "6":
                        listarContasPoupanca(numContasPoupanca);
                        break;
                    case "7":
                        listarContasCorrente(numContasCorrente);
                        break;
                    case "8":
                        consultarSaldoCorrente();
                        break;
                    case "9":
                        depositarCorrente();
                        break;
                    case "10":
                        sacarCorrente();
                        break;
                    case "11":
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } while (!opcao.equals("11"));
        }

        private static void carregarContasDoArquivoPoupanca() {
            File arquivo = new File("C:/Users/User/OneDrive/Área de Trabalho/Programação/Aula22/ContaPoupanca.txt");
            if (arquivo.exists()) {
                try {
                    ObjectInputStream leitura = new ObjectInputStream(new FileInputStream(arquivo));
                    while (true) {
                        try {
                            ContaPoupanca conta = (ContaPoupanca) leitura.readObject();
                            contasPoupanca[numContasPoupanca] = conta;
                            numContasPoupanca++;
                        } catch (EOFException e) {
                            break;
                        }
                    }
                    leitura.close();
                } catch (ClassNotFoundException e) {
                    System.out.println("Erro ao carregar contas: objeto não encontrado");
                } catch (IOException e) {
                    System.out.println("Erro ao carregar contas: " + e.getMessage());
                }
            }
        }

    private static void carregarContasDoArquivoCorrente() {
        File arquivo = new File("C:/Users/User/OneDrive/Área de Trabalho/Programação/Aula22/ContaCorrente.txt");
        if (arquivo.exists()) {
            try {
                ObjectInputStream leitura = new ObjectInputStream(new FileInputStream(arquivo));
                while (true) {
                    try {
                        ContaCorrente conta = (ContaCorrente) leitura.readObject();
                        contasCorrente[numContasCorrente] = conta;
                        numContasCorrente++;
                    } catch (EOFException e) {
                        break;
                    }
                }
                leitura.close();
            } catch (ClassNotFoundException e) {
                System.out.println("Erro ao carregar contas: objeto não encontrado");
            } catch (IOException e) {
                System.out.println("Erro ao carregar contas: " + e.getMessage());
            }
        }
    }

        private static void criarContaCorrente() {
            System.out.print("Nome do titular: ");
            String titular = ler.next();
            System.out.print("Senha: ");
            String senha = ler.next();
            System.out.print("Limite: ");
            float limite = ler.nextFloat();

            ContaCorrente novaConta = new ContaCorrente(titular, senha, limite);
            contasCorrente[numContasCorrente] = novaConta;
            numContasCorrente++;

            // Atualizar arquivo com todas as contas
            File arquivo = new File("C:/Users/User/OneDrive/Área de Trabalho/Programação/Aula22/ContaCorrente.txt");
            try {
                ObjectOutputStream escrita = new ObjectOutputStream(new FileOutputStream(arquivo));
                for (int i = 0; i < numContasCorrente; i++) {
                    if (contasCorrente[i] instanceof ContaCorrente) {
                        escrita.writeObject(contasCorrente[i]);
                    }
                }
                System.out.println("Conta " + novaConta.getId() + " salva com sucesso");
                escrita.close();
            } catch (IOException e) {
                System.out.println("Erro ao criar arquivo: " + e.getMessage());
            }
        }

        private static void criarContaPoupanca() {
            System.out.print("Nome do titular: ");
            String titular = ler.next();
            System.out.print("Senha: ");
            String senha = ler.next();
            System.out.print("Depósito inicial: ");
            float depositoInicial = ler.nextFloat();

            ContaPoupanca novaConta = new ContaPoupanca(titular, senha, depositoInicial);
            contasPoupanca[numContasPoupanca] = novaConta;
            numContasPoupanca++;

            // Atualizar arquivo com todas as contas
            File arquivo = new File("C:/Users/User/OneDrive/Área de Trabalho/Programação/Aula22/ContaPoupanca.txt");
            try {
                ObjectOutputStream escrita = new ObjectOutputStream(new FileOutputStream(arquivo));
                for (int i = 0; i < numContasPoupanca; i++) {
                    if (contasPoupanca[i] instanceof ContaPoupanca) {
                        escrita.writeObject(contasPoupanca[i]);
                    }
                }
                System.out.println("Conta " + novaConta.getId() + " salva com sucesso");
                escrita.close();
            } catch (IOException e) {
                System.out.println("Erro ao criar arquivo: " + e.getMessage());
            }
        }

        private static Conta buscarContaPoupanca(String identificador, String senha) {
            for (int i = 0; i < numContasPoupanca; i++) {
                if (contasPoupanca[i].getId().equals(identificador) && contasPoupanca[i].validaAcesso(identificador, senha)) {
                    return contasPoupanca[i];
                }
            }
            return null;
        }

        private static Conta buscarContaCorrente(String identificador, String senha) {
            for (int i = 0; i < numContasCorrente; i++) {
                if (contasCorrente[i].getId().equals(identificador) && contasCorrente[i].validaAcesso(identificador, senha)) {
                    return contasCorrente[i];
                }
            }
            return null;
        }

        private static void consultarSaldoPoupanca() {
            System.out.print("Identificador da conta: ");
            String identificador = ler.next();
            System.out.print("Senha: ");
            String senha = ler.next();
            Conta conta = buscarContaPoupanca(identificador, senha);
            if (conta != null) {
                ContaPoupanca cp = (ContaPoupanca) conta;
                System.out.println("Saldo da Conta Poupança: " + cp.verificaSaldo());
            } else {
                System.out.println("Conta não encontrada ou senha incorreta.");
            }
        }

        private static void consultarSaldoCorrente() {
            System.out.print("Identificador da conta: ");
            String identificador = ler.next();
            System.out.print("Senha: ");
            String senha = ler.next();
            Conta conta = buscarContaCorrente(identificador, senha);
            if (conta != null) {
                ContaCorrente cc = (ContaCorrente) conta;
                System.out.println("Saldo da Conta Corrente: " + cc.verificaSaldo());
            } else {
                System.out.println("Conta não encontrada ou senha incorreta.");
            }
        }

        private static void depositarCorrente() {
            System.out.print("Identificador da conta: ");
            String identificador = ler.next();
            System.out.print("Senha: ");
            String senha = ler.next();
            Conta conta = buscarContaCorrente(identificador, senha);
            if (conta != null) {
                System.out.print("Valor do depósito: R$ ");
                float valor = ler.nextFloat();
                conta.depositar(valor);
            } else {
                System.out.println("Conta não encontrada ou senha incorreta.");
            }
        }

        private static void depositarPoupanca() {
            System.out.print("Identificador da conta: ");
            String identificador = ler.next();
            System.out.print("Senha: ");
            String senha = ler.next();
            Conta conta = buscarContaPoupanca(identificador, senha);
            if (conta != null) {
                System.out.print("Valor do depósito: R$ ");
                float valor = ler.nextFloat();
                conta.depositar(valor);
            } else {
                System.out.println("Conta não encontrada ou senha incorreta.");
            }
        }

        private static void sacarCorrente() {
            System.out.print("Identificador da conta: ");
            String identificador = ler.next();
            System.out.print("Senha: ");
            String senha = ler.next();
            Conta conta = buscarContaCorrente(identificador, senha);
            if (conta != null) {
                System.out.print("Valor do saque: R$ ");
                float valor = ler.nextFloat();
                boolean sucesso = false;
                ContaCorrente cc = (ContaCorrente) conta;
                sucesso = cc.sacar(valor);

                if (sucesso) {
                    System.out.println("Saque realizado com sucesso.");
                } else {
                    System.out.println("Não foi possível realizar o saque.");
                }
            } else {
                System.out.println("Conta não encontrada ou senha incorreta.");
            }
        }

        private static void sacarPoupanca() {
            System.out.print("Identificador da conta: ");
            String identificador = ler.next();
            System.out.print("Senha: ");
            String senha = ler.next();
            Conta conta = buscarContaPoupanca(identificador, senha);
            if (conta != null) {
                System.out.print("Valor do saque: R$ ");
                float valor = ler.nextFloat();
                boolean sucesso = false;
                ContaPoupanca cp = (ContaPoupanca) conta;
                sucesso = cp.sacar(valor);

                if (sucesso) {
                    System.out.println("Saque realizado com sucesso.");
                } else {
                    System.out.println("Não foi possível realizar o saque.");
                }
            } else {
                System.out.println("Conta não encontrada ou senha incorreta.");
            }
        }

        private static void listarContasPoupanca(int numContas) {
            File arquivo = new File("C:/Users/User/OneDrive/Área de Trabalho/Programação/Aula22/ContaPoupanca.txt");
            try {
                ObjectInputStream leitura = new ObjectInputStream(new FileInputStream(arquivo.getAbsoluteFile()));
                System.out.println("Contas cadastradas:");
                ContaPoupanca contas = (ContaPoupanca) leitura.readObject(); //volta como um objeto genérico
                System.out.println(contas);

            }

            catch (ClassNotFoundException e) {
                System.out.println("Objeto não encontrado");
            }
            catch (FileNotFoundException e) {
                System.out.println("O arquivo nao existe");
            }
            catch (IOException e) {
                System.out.println("Erro ao ler as info");
            }

            if (numContas == 0) {
                System.out.println("Nenhuma conta cadastrada.");
            } else {
                System.out.println("Contas cadastradas:");
                for (int i = 0; i < numContas; i++) {
                    Conta conta = contasPoupanca[i];
                        ContaPoupanca cp = (ContaPoupanca) conta;
                        System.out.println("Conta Poupanca - ID: " + cp.getId() + ", Titular: " + cp.getTitular() + ", Saldo: R$ " + cp.getSaldo() + ", Limite: R$ " + cp.verificaSaldo());
                }
            }
        }

        private static void listarContasCorrente(int numContas) {
            File arquivo = new File("C:/Users/User/OneDrive/Área de Trabalho/Programação/Aula22/ContaCorrente.txt");
            try {
                ObjectInputStream leitura = new ObjectInputStream(new FileInputStream(arquivo.getAbsoluteFile()));
                System.out.println("Contas cadastradas:");
                ContaCorrente contas = (ContaCorrente) leitura.readObject(); //volta como um objeto genérico
                System.out.println(contas);

            }

            catch (ClassNotFoundException e) {
                System.out.println("Objeto não encontrado");
            }
            catch (FileNotFoundException e) {
                System.out.println("O arquivo nao existe");
            }
            catch (IOException e) {
                System.out.println("Erro ao ler as info");
            }

            if (numContas == 0) {
                System.out.println("Nenhuma conta cadastrada.");
            } else {
                System.out.println("Contas cadastradas:");
                for (int i = 0; i < numContas; i++) {
                    Conta conta = contasCorrente[i];
                    ContaCorrente cc = (ContaCorrente) conta;
                    System.out.println("Conta Poupanca - ID: " + cc.getId() + ", Titular: " + cc.getTitular() + ", Saldo: R$ " + cc.getSaldo() + ", Limite: R$ " + cc.verificaSaldo());
                }
            }
        }
}