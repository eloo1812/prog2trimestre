
package exemploFinal;


public class Operacoes {
    //atributo final precisa te um valor ate o final do construtor
    //pode ser alterad
    public final double pi;
    //constante PI é static e public alem de final e precisa ser inicializada na declaração
    public static final double PI = 3.1463793;
    
    public Operacoes(){
        pi = 3.1467893;
    }
}
