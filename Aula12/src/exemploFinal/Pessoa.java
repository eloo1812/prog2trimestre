
package exemploFinal;

/**
 *
 * @author sorti
 */
public final class Pessoa {

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public float getAltura() {
        return altura;
    }
  
        private String nome;
        private String sobrenome;
        private float altura;
    
}
