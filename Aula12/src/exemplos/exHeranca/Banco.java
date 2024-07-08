package exemplos.exHeranca;

import java.util.Scanner;

public class Banco {
	public static String leString(String mensagem){
		Scanner ler = new Scanner(System.in);
		System.out.print(mensagem);
		return ler.nextLine();
	}

	public static float leFloat(String mensagem){
		Scanner ler = new Scanner(System.in);
		System.out.print(mensagem);
		return ler.nextFloat();
	}

	public static ContaCorrente cadastraContaCorrente(){
		String titular = leString("Nome do titular: ");
		String senha = leString("Qual a senha: ");
		float limite = leFloat("Qual o limite inicial: ");
		ContaCorrente c1 = new ContaCorrente(titular,senha,limite);
		System.out.println("Conta cadastrada com o identificador "+c1.getIdentificador());
		return c1;
	}

	public static ContaPoupanca cadastraContaPoupanca(){
		String titular = leString("Nome do titular: ");
		String senha = leString("Qual a senha: ");
		float deposito = leFloat("Qual o deposito inicial: ");
		ContaPoupanca c1 = new ContaPoupanca(titular,senha,deposito);
		System.out.println("Conta cadastrada com o identificador "+c1.getIdentificador());
		return c1;
	}

	public static ContaCorrente acessaContaCorrente(ContaCorrente c1){
		System.out.println("Acessando a conta "+c1.getIdentificador());
		String opc;
		do{
			System.out.println("Selecione uma opção");
			System.out.println("d - depositar");
			System.out.println("s - sacar");
			System.out.println("v - verificar saldo");
			System.out.println("e - sair");
			opc = leString(":");
			switch (opc){
				case "d"->{
					float valor = leFloat("Qual valor depositar: ");
					c1.depositar(valor);
				}
				case "s"->{
					float valor = leFloat("Qual valor sacar: ");
					if(c1.sacar(valor)){
						System.out.println("Saque realizado");
					}
					else{
						System.out.println("Saldo insuficiente");
					}
				}
				case "v"-> System.out.println(c1.verificaSaldo());
			}
		}
		while(!opc.equals("e"));
		return c1;
	}

	public static ContaPoupanca acessaContaPoupanca(ContaPoupanca c1){
		System.out.println("Acessando a conta "+c1.getIdentificador());
		String opc;
		do{
			System.out.println("Selecione uma opção");
			System.out.println("d - depositar");
			System.out.println("s - sacar");
			System.out.println("v - verificar saldo");
			System.out.println("e - sair");
			opc = leString(":");
			switch (opc){
				case "d"->{
					float valor = leFloat("Qual valor depositar: ");
					c1.depositar(valor);
				}
				case "s"->{
					float valor = leFloat("Qual valor sacar: ");
					if(c1.sacar(valor)){
						System.out.println("Saque realizado");
					}
					else{
						System.out.println("Saldo insuficiente");
					}
				}
				case "v"-> System.out.println(c1.verificaSaldo());
			}
		}
		while(!opc.equals("e"));
		return c1;
	}

	public static void main(String[] args) {
		ContaCorrente[] listaCc = new ContaCorrente[200];
		ContaPoupanca[] listaCp = new ContaPoupanca[200];
		int contCc = 0;
		int contCp = 0;
		String opc;
		do{
			System.out.println("Selecione uma opção");
			System.out.println("cc - cadastrar uma conta corrente");
			System.out.println("cp - cadastrar uma conta poupança");
			System.out.println("ac - acessar uma conta corrente");
			System.out.println("ap - acessar uma conta poupança");
			System.out.println("e - sair");
			opc = leString(": ").toLowerCase();
			switch (opc){
				case "cc"->{
					if(contCc<listaCc.length) {
						listaCc[contCc] = cadastraContaCorrente();
						contCc++;
					}
					else{
						System.out.println("O banco está lotado");
					}
				}
				case "cp"->{
					if(contCp< listaCp.length) {
						listaCp[contCp] = cadastraContaPoupanca();
						contCp++;
					}
					else{
						System.out.println("Banco lotado");
					}
				}
				case "ac"->{
					String id = leString("Qual o identificador: ");
					String senha = leString("Qual a senha de acesso: ");
					int posicao = -1;
					for(int i=0;i<contCc;i++)
						if(listaCc[i].validaAcesso(id,senha))
							posicao = i;
					if(posicao>=0){
						listaCc[posicao] = acessaContaCorrente(listaCc[posicao]);
					}
					else{
						System.out.println("Conta ou senha incorretos");
					}
				}
				case "ap"->{
					String id = leString("Qual o identificador: ");
					String senha = leString("Qual a senha de acesso: ");
					int posicao = -1;
					for(int i=0;i<contCc;i++)
						if(listaCp[i].validaAcesso(id,senha))
							posicao = i;
					if(posicao>=0){
						listaCp[posicao] = acessaContaPoupanca(listaCp[posicao]);
					}
					else{
						System.out.println("Conta ou senha incorretos");
					}
				}
			}
		}
		while (!opc.equals("e"));
	}
}