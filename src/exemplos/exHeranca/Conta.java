package exemplos.exHeranca;

import java.util.Random;

public class Conta {
	private String titular;
	private String identificador;
	protected float saldo;
	private String senha;

	public Conta(String titular, String senha){
		this.titular = titular;
		this.senha = senha;
		identificador = geraIdentificador();
	}

	private String geraIdentificador(){
		Random aleatorio = new Random();
		String identificador = "";
		for(int i=0;i<4;i++)
			identificador+=(char)aleatorio.nextInt(65,90);
		identificador+=aleatorio.nextInt(1000,2000);
		return identificador;
	}

	public String getTitular(){
		return titular;
	}

	public void setTitular(String titular){
		this.titular = titular;
	}

	public String getIdentificador(){
		return identificador;
	}

	public void setSenha(String senha){
		this.senha = senha;
	}

	public void depositar(float valor){
		saldo+=valor;
	}

	public boolean validaAcesso(String identificador, String senha){
		return this.identificador.equals(identificador) && this.senha.equals(senha);
	}

}