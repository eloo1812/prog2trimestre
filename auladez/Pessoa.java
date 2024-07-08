
package auladez;


public class Pessoa {

    
    
       String nome;
       String sobrenome;
       int altura;
       
       void andar(){
        System.out.println(nome+"andando..");
    }
       void correr(){
        System.out.println(nome+"correndo..");
    }
       String dados(){
        return "nome: "+nome+"sobrenome:"+sobrenome+"mede:"+altura+"cm";
    }
    }
    

