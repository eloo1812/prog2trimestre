package exemploOverride;

public class Principal {
    public static void main(String[] args){
        Pessoa p1 = new Pessoa();
        p1.setNome("Jonas");
        p1.setSobrenome("Silva");
        p1.setIdade(25);
        System.out.println(p1.toString());

        Aluno a1 = new Aluno();
        a1.setNome("Luisa");
        a1.setSobrenome("Sousa");
        a1.setIdade(16);
        a1.setMatricula(1234);
        System.out.println(a1.obterDados());
    }
}