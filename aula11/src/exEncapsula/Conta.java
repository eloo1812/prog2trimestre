/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exEncapsula;

/**
 *
 * @author sorti
 */
public class Conta {
    private String titular;
	private String identificador;
	private float saldo;

	public Conta(){
		identificador = geraIdentificador();
	}
	
	public Conta(String titular, float deposito){
		this.titular = titular;
		identificador = geraIdentificador();
		this.saldo = deposito;

	}

	Conta(String titular){
		this.titular = titular;
		identificador = geraIdentificador();
	}

	public String getIdentificador(){
		return identificador;
	}

	public String getTitular(){
		return titular;
	}

	public void setTitular(String titular){
		this.titular = titular;
	}

	void depositar(float saldo){
		this.saldo+=saldo;
	}
	boolean sacar(float valor){
		if(valor<=saldo){
			saldo-=valor;
			return true;
		}
		return false;
	}

	private String geraIdentificador(){
		return "conta"+new Random().nextInt(100,10000);
	}

	String verificaSaldo(){
		return String.format("Seu saldo é de R$%.2f",saldo);
	}
}
