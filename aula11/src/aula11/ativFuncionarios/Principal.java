
package aula11.ativFuncionarios;


public class Principal 
{
    public static void main(String[] args) 
    {
        Motorista m1 = new Motorista("pedro","silva",123);
        Engenheiro e1 = new Engenheiro("ana", "sousa", 123, 12345678);

        m1.setNome("pedro");
        m1.setSobrenome("Marco");
        m1.setMatricula(123);
        m1.setCnh("123");

        System.out.println("Motorista:" +m1.getNome());
        System.out.println("CNH:" +m1.getCnh());

        e1.setNome("Fabricio");
        e1.setSobrenome("Antonio");
        e1.setCrea(123456789);
        e1.setMatricula(23);

        System.out.println("Engenheiro: "+e1.getNome()+" "+ e1.getSobrenome());
        System.out.println("Matricula: "+e1.getMatricula());
        System.out.println("Crea: "+e1.getCrea());
    }

}
