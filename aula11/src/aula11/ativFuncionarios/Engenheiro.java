
package aula11.ativFuncionarios;


public class Engenheiro extends Funcionario{

    public Engenheiro (String nome, String sobrenome, int matricula, int crea){
        super(nome,sobrenome,matricula);
        this.crea = crea;
    }

    private int crea;

    public int getCrea() {
        return crea;
    }

    public void setCrea(int crea)
    {
        this.crea = crea;
    }
    
}
