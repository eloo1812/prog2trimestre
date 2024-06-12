package aula10.ativAlunos;

import aula10.ativAlunos.Aluno;
import java.util.Random;
import java.util.Scanner;

public class TurmaLista {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Aluno[] lista = new Aluno[20];
        int contAluno = 0;
        String resp;
        
        do {
            System.out.println("Selecione uma opcao");
            System.out.println("c - cadastrar um aluno");
            System.out.println("l - listar alunos");
            System.out.println("p - pesquisar um aluno");
            System.out.println("s - sair");
            System.out.print(": ");
            resp = ler.next();
            
            if (resp.equals("c")) {
                lista[contAluno] = new Aluno();
                System.out.print("Qual o nome do aluno: ");
                lista[contAluno].nome = ler.next();
                System.out.print("Qual o sobrenome: ");
                lista[contAluno].sobrenome = ler.next();
                System.out.print("Qual o e-mail do " + lista[contAluno].nome + ": ");
                lista[contAluno].eMail = ler.next();
                lista[contAluno].codigo = new Random().nextInt(1000, 10000);
                System.out.println("Informe as notas do " + lista[contAluno].nome);
                System.out.print("Nota um: ");
                lista[contAluno].notaUm = ler.nextFloat();
                System.out.print("Nota dois: ");
                lista[contAluno].notaDois = ler.nextFloat();
                System.out.println(lista[contAluno].nome + " cadastrado, obteve o codigo " + lista[contAluno].codigo);
                contAluno++;
            } else if (resp.equals("l")) {
                for (int i = 0; i < contAluno; i++) {
                    System.out.println("Nome: " + lista[i].nome);
                    System.out.println("Sobrenome: " + lista[i].sobrenome);
                    System.out.println("Media: " + lista[i].obterMedia());
                    System.out.println("Status: " + lista[i].verStatus());
                }
            } else if (resp.equals("p")) {
                System.out.print("Qual codigo do aluno: ");
                int codigo = ler.nextInt();
                boolean alunoEncontrado = false;
                for (int i = 0; i < contAluno; i++) {
                    if (lista[i].codigo == codigo) {
                        alunoEncontrado = true;
                        System.out.println("Nome: " + lista[i].nome);
                        System.out.println("Sobrenome: " + lista[i].sobrenome);
                        System.out.println("E-mail: " + lista[i].eMail);
                        System.out.println("Media: " + lista[i].obterMedia());
                        System.out.println("Status: " + lista[i].verStatus());
                        break;
                    }
                }
                if (!alunoEncontrado) {
                    System.out.println("Aluno com codigo " + codigo + " nao encontrado.");
                }
            }
        } while (!resp.equals("s"));
    }
}

class Aluno {
    String nome;
    String sobrenome;
    String eMail;
    int codigo;
    float notaUm;
    float notaDois;

    float obterMedia() {
        return (notaUm + notaDois) / 2;
    }

    String verStatus() {
        return obterMedia() >= 6 ? "Aprovado" : "Reprovado";
    }
}
