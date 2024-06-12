
package aula10.ativLampada;

import aula10.ativLampada.Lampada;


public class ativTeste {
    public static void main(String[] args) {
        
        Lampada lamp1 = new Lampada();
        Lampada lamp2 = new Lampada();
        Lampada lamp3 = new Lampada();
        Lampada lamp4 = new Lampada();
        Lampada lamp5 = new Lampada();
        
        lamp1.marca = "lg";
        lamp1.modelo = "led";
        lamp1.local = "sala";
        lamp1.cor = "branca";
        
        
        lamp2.marca = "consul";
        lamp2.modelo = "led";
        lamp2.local = "quarto";
        lamp2.cor = "amarelo";
        
        lamp3.marca = "lg";
        lamp3.modelo = "led";
        lamp3.local = "banheiro";
        lamp3.cor = "azul";
        
        
        lamp4.marca = "lg";
        lamp4.modelo = "led";
        lamp4.local = "sala";
        lamp4.cor = "branca";
        
        lamp5.marca = "consul";
        lamp5.modelo = "led";
        lamp5.local = "cozinha";
        lamp5.cor = "amarela";
    
     lamp1.ligar();
        lamp3.ligar();
        lamp5.ligar();

        
        System.out.println(lamp1.obterDados());
        System.out.println(lamp2.obterDados());
        System.out.println(lamp3.obterDados());
        System.out.println(lamp4.obterDados());
        System.out.println(lamp5.obterDados());
        lamp1.desligar();
        lamp5.desligar();

        
        System.out.println("Lampada 1 está ligada? " + (lamp1.estaLigada() ? "Sim" : "Não"));
        System.out.println("Lampada 2 está ligada? " + (lamp2.estaLigada() ? "Sim" : "Não"));
        System.out.println("Lampada 3 está ligada? " + (lamp3.estaLigada() ? "Sim" : "Não"));
        System.out.println("Lampada 4 está ligada? " + (lamp4.estaLigada() ? "Sim" : "Não"));
        System.out.println("Lampada 5 está ligada? " + (lamp5.estaLigada() ? "Sim" : "Não"));
    }
}


