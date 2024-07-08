package objetos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Escrever {
    public static void main(String[] args){
        File arquivo = new File("C:/Users/User/OneDrive/Área de Trabalho/Programação/Aula22/pessoa.db");
        try {
            ObjectOutputStream escrita = new ObjectOutputStream(new FileOutputStream(arquivo.getAbsolutePath()));
            //criando objeto pra escrever no arquivo
            Pessoa p1 = new Pessoa();
            p1.setNome("Jonas");
            p1.setSobrenome("Fischer");
            p1.setCpf("04793634044");
            //escrever objeto no arquivo
            escrita.writeObject(p1);
            System.out.println("Pessoa "+p1.getNome()+" salva com sucesso");
            escrita.close();
        } catch (IOException e) {
            System.out.println("Error ao create arquivo");
        }
    }
}