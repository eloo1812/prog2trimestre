package exemploExcecao;

public class Teste {
    public static void main(String[] args){
        Operacoes op = new Operacoes();

        try {
            op.divide(8, 0);
        } catch (ArithmeticException e){
            System.out.println(e);
        }
    }
}