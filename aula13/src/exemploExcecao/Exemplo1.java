package exemploExcecao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exemplo1 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int i = 0;
        do {
            try {
                System.out.println("Digite um num: ");
                int v1 = ler.nextInt();

                System.out.println("Digite outro: ");
                int v2 = ler.nextInt();
                int resultado = v1 / v2;
                System.out.println(resultado);
            } catch (InputMismatchException erro) {
                System.out.println("n1 e n2 precisam ser números");
            } catch (ArithmeticException e) {
                System.out.println("nao da p dividir por zero");
                i = 1;
            }
            finally {
                System.out.println("Sempre é executado...");
            }
//            catch (Exception e) {
//                System.out.println("Algo deu errado hohoho");
//                i = 1;
//                //e.printStackTrace(); para lançar a pilha do erro
//            }
        } while (i != 0);
    }
}