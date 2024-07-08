package exemploOverride;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private int idade;

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome()
    {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public String obterDados(){
        String retorno = "nome: "+nome+" "+sobrenome;
        retorno +="\nIdade: "+idade;
        return retorno;
    }

    @Override
    public String toString(){
        String retorno = "nome: "+nome+" "+sobrenome;
        retorno +="\nIdade: "+idade;
        return retorno;
    }
}