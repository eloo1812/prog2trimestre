/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exEncapsula;

/**
 *
 * @author sorti
 */
public class Banco {
    public static void main(String[] args) {
		Conta c1 = new Conta("Ana",100);
		System.out.println("Ana conta cadastrada com id "+c1.getIdentificador());
		c1.depositar(10);
		c1.setTitular("Anna");
		c1.depositar(100);
		System.out.println(c1.getIdentificador());
		System.out.println(c1.getTitular());

	}
    
}
