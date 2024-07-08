
package aula10.ativAlunos;
import aula10.ativAlunos.Aluno;
import java.util.Scanner;
import java.util.Random;
public class Turma {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Aluno a1 = new Aluno();
        System.out.println("qual o nome:");
        a1.nome = ler.next();
        a1.codigo = new Random().nextInt(1000,10000);
        System.out.println("informe as notas do"+a1.nome);
        System.out.println("nota 1:");
        a1.notaUm = ler.nextFloat();
        System.out.println("nota 2:");
        a1.notaDois = ler.nextFloat();
        System.out.println(a1.nome+"cadastrado obteve o codigo"+a1.codigo);
        System.out.println("o aluno "+a1.nome+" "+a1.sobrenome);
        System.out.println("tem media "+a1.obterMedia()+"e esta "+a1.verStatus());
    }
    
}
