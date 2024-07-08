package exemploExcecao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exemplo2 {
    public static void main (String[] args){
        Scanner ler = new Scanner(System.in);
        boolean valido = true;

        do{
            try {
                System.out.println("Digite numero: ");
                int n = ler.nextInt();
                valido = true;
            } catch(InputMismatchException e) {
                System.out.println("Precisam ser numeros");
                ler.next(); //pra limpar o buffer do teclado e nao ficar repetindo
                valido = false;
            }
        } while(!valido);
    }
}