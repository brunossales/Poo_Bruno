import java.util.Scanner;
public class Calango {
    int bucho; //atributos
    int maxBucho;
    int nPatas;
    int aux = 0;

    //mesmo nome da classe = sombreamento de variavel
    Calango(int bucho, int maxBucho, int nPatas){ //parametros
        this.bucho = bucho;
        this.maxBucho = maxBucho;
        this.nPatas = nPatas;
    }

    void comer(int qtd){
        bucho += qtd;
        if(bucho > maxBucho){
            bucho = maxBucho;
            System.out.println("Comi até ficar saciado");
        }else{
            System.out.println("Tô cheio");
        }
    }

    void andar(){
        if(nPatas < 2){
            System.out.println("Estou impossibilitado de tal tarefa");
            
        }
        if(bucho > 0){
            bucho -= 1;
            System.out.println("Que passeio agradavel");
            
        }
        System.out.println("Estou muito cansado");
        
    }

    void acidentar(){
        if(nPatas > 0){
            nPatas -= 1;
            System.out.println("Ouch! Perdi uma pata");
        }else{
            System.out.println("Já virei cobra!!");
        }
    }

    void regenerar(){
        if(nPatas == 4){
            System.out.println("Estou perfeito");
        }else if (bucho > 0){
            nPatas += 1;
            bucho -= 1;
            System.out.println("Opa! Recuperei uma pata!");
        }else{
            System.out.println("Nao tenho energia suficiente para me recuperar");
        }
    }
    void nadando(){
        if(nPatas < 4){
            System.out.println("Morri afogado por não conseguir nadar!");
            aux = 1;
        }
        else if(bucho > 0){
            bucho -= 1;
            System.out.println("Estou me cansando!");
        }else{
            System.out.println("Morri de cansaço!");
            aux = 1;
        }
            
    }

    public String toString() {
        return "Bucho: " + bucho + "/" + maxBucho + " Patas: " + nPatas;
    }

    public static void main(String[] args) {
        //referencia      = criando objeto
        Scanner lendo = new Scanner(System.in);
        int maratona_calango;
        Calango deadlango = new Calango(0, 20, 4);
        System.out.println(deadlango);
        System.out.println("\n Digite quanos KM você quer que o calngo faça de maratona: ");
        maratona_calango = lendo.nextInt();

        
        for(int i = 0; i < maratona_calango; i++){
            deadlango.andar();
                if(i % 2 != 0)
                    deadlango.comer(1);
                if(i % 4 == 0){
                    deadlango.acidentar();
                }
                if(i > 2 && i < 10){
                    deadlango.regenerar();
                }
                if(i == 10 && i <= 15){
                    System.out.println("Percuso aquatico para o Deadlango nadar\n");
                    deadlango.nadando();
                }
            if(deadlango.aux == 1)
                break;
            
        }
        
    }
}


