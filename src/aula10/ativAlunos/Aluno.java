
package aula10.ativAlunos;


public class Aluno {
    
            String nome;
            String sobrenome;
            String eMail;
            int codigo;
            float notaUm;
            float notaDois;
            
            float obterMedia(){
                return (notaUm+notaDois)/2;
        }
            String verStatus(){
                float media = obterMedia();
                if(media>=8)
                    return "aprovado";
                else if (media>=6)
                    return "recuperacao";
                else
                    return "reprovado";
        }
        
    }

