import java.util.Scanner;
public class Codigointerativo{
public static void main(String[] args){
    Scanner lendo = new Scanner(System.in);
    Carro ferrari = new Carro();
    while(true){
        System.out.println("Digite 'abastecer' para abastecer e o quanto deseja abastecer \n'embarcar' Para embarcar e o numero de pessoas que vao ser embarcadas\n'desembarcar' e o numero de pessoas para desembarcar o numero de pessoas dado\n'go' e o valor em km que vai andar para meter o pe na estrada!");
        String line = lendo.nextLine();
        String[] queb = line.split(" ");
        if(queb[0].equals("abastecer")){
                ferrari.fuel(Float.parseFloat(queb[1]));
        
        }else if(queb[0].equals("embarcar")){
            ferrari.in(Integer.parseInt(queb[1]));
    
        }else if(queb[0].equals("desembarcar")){
            ferrari.out(Integer.parseInt(queb[1]));
        }
        else if(queb[0].equals("go")){
            ferrari.drive(Integer.parseInt(queb[1]));
        }
        if(ferrari.aux == 1){
            System.out.println(ferrari.show());
            break;
        }
        
        System.out.println("\n");
    }
    lendo.close();
    }
}
