import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o nome do contato");
        String contact = ler.next();
        Contato contato = new Contato(contact);
        System.out.println("Digite 'adicionar' e a operado junto com o numero, para adicionar um numero a seu contato a execução");
        System.out.println("Digite 'remover' e o endereço do numero, para remover o numero do contato");
        System.out.println("Digite 'mostrar', para mostrar como esta o contato");
        System.out.println("Digite 'trocar' e o nome do novo contato");
        System.out.println("Digite 'sair', para encerrar a execução");
        while(true){
            String op = ler.nextLine();
            String[] brok = op.split(" ");
            if(brok[0].equals("sair"))
                break;
            else if(brok[0].equals("adicionar")){
                contato.addfone(brok[1], brok[2]);
            }
            else if(brok[0].equals("remover")){
                contato.rmfone(Integer.parseInt(brok[1]));
            }
            else if(brok[0].equals("mostrar")){
                contato.show();
            }
            else if(brok[0].equals("trocar")){
               contato = new Contato(brok[1]);
            }
        }

    }
}
