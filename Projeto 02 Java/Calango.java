import java.util.Scanner;
public class Calango {
    int bucho;
    int maxBucho;
    int nPatas;
    int aux = 0;

    Calango(int bucho, int maxBucho, int nPatas){
        this.bucho = bucho;
        this.maxBucho = maxBucho;
        this.nPatas = nPatas;
    }

    void comer(int qtd){
        bucho += qtd;
        if(bucho < maxBucho){
            System.out.println("Comi mais uma comidinha enquanto maratono!");
        }else{
            System.out.println("Tô cheio, nao quero comer mais enquanto maratono");
        }
    }

    void andar(){
        if(nPatas < 2){
            System.out.println("Estou impossibilitado de tal tarefa, mas vou me arrastando");
            
        }
        if(bucho > 0){
            bucho -= 1;
            System.out.println("Maratonando satisfatoriamente");
            
        }
        
    }

    void acidentar(){
        if(nPatas > 0){
            nPatas -= 1;
            System.out.println("Ouch! Perdi uma pata na maratona");
        }else{
            if(nPatas == 0)
                    aux = 1;
        }
    }

    void regenerar(){
        if(nPatas == 4){
            System.out.println("Estou perfeito");
        }else if (bucho > 0){
            nPatas += 1;
            bucho -= 1;
            System.out.println("Opa! Recuperei uma pata enquanto maratono!");
        }else{
            System.out.println("Nao tenho energia suficiente para me recuperar enquanto maratono");
        }
    }
    void nadando(){
        if(nPatas < 4){
            System.out.println("Morri afogado por não conseguir nadar!");
            aux = 1;
        }
        else if(bucho > 0){
            bucho -= 1;
            System.out.println("Perdi uma das comidas no meu bucho!");
        }else{
            System.out.println("Morri de cansaço!");
            aux = 1;
        }
            
    }

    public String toString() {
        return "Bucho: " + bucho + "/" + maxBucho + " Patas: " + nPatas;
    }

    public static void main(String[] args) {
        Scanner lendo = new Scanner(System.in);
        int maratona_calango;
        int contagem = 1;
        Calango deadlango = new Calango(5, 10, 4);
        System.out.println("\n Digite quanos KM você quer que o Deadlango faça de maratona: ");
        maratona_calango = lendo.nextInt();

        
        for(int i = 0; i < maratona_calango; i++){
            int leitor;
            System.out.println("\nDigite 1 para Andar\n2 Para comer\n3 Para fazer o deadLango se Acidentar\n4 Para ele se regenerar\n5 Para ele Nadar");
            leitor = lendo.nextInt();
                if(leitor == 1)
                    deadlango.andar();
                else if(leitor == 2)
                    deadlango.comer(1);
                else if(leitor == 3)
                    deadlango.acidentar();
                else if(leitor == 4)
                    deadlango.regenerar();
                else if(leitor == 5){
                    System.out.println("Percuso aquatico para o Deadlango nadar\n");
                    deadlango.nadando();
                }
            if(deadlango.aux == 1)
                break;
            System.out.println("DeadLango andou mais 1 km\n");
        }
        if(deadlango.aux == 0)
            System.out.println("Dead lango saiu vivo da maratona!");
        
        System.out.println("Estado do DeadLango:");
        System.out.println(deadlango);
    }
}


