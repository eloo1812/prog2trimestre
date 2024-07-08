

package Arquivos;

import java.io.File;

public class Exemplo3 {
    public static void main (String[] args)
    {
        File caminho = new File("C:/Users/User/OneDrive/Área de Trabalho/Programação/Aula22/");
        if(caminho.exists()) {
            System.out.println("A pasta "+caminho.getAbsolutePath()+" existe");
        } else {
            System.out.println("Não existe, criando a pasta");
            if(caminho.mkdirs()){
                System.out.println("[Ok]");
            } else {
                System.out.println("[Fail]");
            }
        }
    }
}