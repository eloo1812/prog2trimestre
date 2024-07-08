
package auladez;

public class exemplooo {
    public static void main(String[] args) {
    Pessoa pessoa1 = new Pessoa();
    Pessoa pessoa2 = new Pessoa();
    pessoa1.nome = "Jonas";
    pessoa1.sobrenome = "Silva";
    pessoa2.nome = "Duda";
    pessoa2.sobrenome = "Souza";
    
    pessoa2.andar();
    System.out.println(pessoa1.dados());
}
}

