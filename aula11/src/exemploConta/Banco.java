/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemploConta;

/**
 *
 * @author sorti
 */
public class Banco {
    public static void main(String[] args) {
		ContaBancaria c1 = new ContaBancaria();
		ContaBancaria c2 = new ContaBancaria();
		c1.nomeBanco = "Banco cimol";
		System.out.println(c1.nomeBanco);
		System.out.println(c2.nomeBanco);
		c2.nomeBanco = "Teste";
		System.out.println(c1.nomeBanco);
		System.out.println(c2.nomeBanco);
		ContaBancaria.nomeBanco = "Novo banco";
    }
    
}
