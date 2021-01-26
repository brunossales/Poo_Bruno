import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o número maximo de produtos em cada espiral e o número de espirais");
        String inic = ler.nextLine();
        String[] brok = inic.split(" ");
        Maquina maq = new Maquina(Integer.parseInt(brok[0]), Integer.parseInt(brok[1]));
        System.out.println("Digite as seguintes opções para os seguintes comandos:");
        System.out.println("Digite inserir, junto com o valor que deseja ter de saldo");
        System.out.println("Troco, para você receber o seu troco que está na maquina");
        System.out.println("Comprar, junto com o index para comprar a comida escolhida");
        System.out.println("Adicionar, junto com o index, nome, quantidade e preco do produto");
        System.out.println("Limpar, junto com o index, para tirar o produto daquele espiral");
        System.out.println("Mostrar, para mostrar as opções de comida e seu saldo");
        System.out.println("Nova, junto com o número maximo de produtos e o numero de espirais para iniciar uma nova maquina");
        System.out.println("Fechar, para encerrar o processo e fechar a maquina");
        System.out.println("");
        while(true){
            String op = ler.nextLine();
            String[] queb = op.split(" ");
            if(queb[0].equalsIgnoreCase("Fechar")){
                maq.encerrando();
                break;
            }
            else if(queb[0].equalsIgnoreCase("Inserir"))
                maq.inserirDinheiro(Float.parseFloat(queb[1]));

            else if(queb[0].equalsIgnoreCase("Troco"))
                maq.troco();
            
            else if(queb[0].equalsIgnoreCase("Comprar"))
                maq.vender(Integer.parseInt(queb[1]));
            
            else if(queb[0].equalsIgnoreCase("Adicionar"))
                maq.alterarEspiral(Integer.parseInt(queb[1]), queb[2], Integer.parseInt(queb[3]), Float.parseFloat(queb[4]));
            
            else if(queb[0].equalsIgnoreCase("Limpar"))
                maq.limparEspiral(Integer.parseInt(queb[1]));

            else if(queb[0].equalsIgnoreCase("Mostrar"))
                System.out.println(maq);
            
            else if(queb[0].equalsIgnoreCase("Nova")){
                maq.trocar();
                maq = new Maquina(Integer.parseInt(queb[1]), Integer.parseInt(queb[2]));
            }

            else 
                System.out.println("Opção invalida");
            
            System.out.println("");
        }
        ler.close();
    }
}
