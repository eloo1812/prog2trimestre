
package aula10.ativLampada;

public class Lampada {
    
    
     String marca;
     String modelo;
     String cor;
     String local;
     boolean lig;

    
     void ligar() {
        lig = true;
    }

    
     void desligar() {
        lig = false;
    }

    
     boolean estaLigada() {
        return lig;
    }

    
    public String obterDados() {
        return String.format("Marca: %s, Modelo: %s, Cor: %s, Local: %s, Ligada: %s",
                marca, modelo, cor, local, lig ? "Sim" : "Não");
    }
}

