/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemploPolimorfismo;

/**
 *
 * @author sorti
 */
public class Teste {
    public static void main(String[] args){
        Operacoes op = new Operacoes();
        System.out.println("somando dois nums: "+op.soma(5,3));
        System.out.println("somando duas string: "+op.soma("palavra","teste"));
        System.out.println("somando 3 nums: "+op.soma(5,3, 2));
    }
}
