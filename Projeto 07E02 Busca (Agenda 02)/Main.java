import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class Main {
    public static void main(String[] args) {
        Agenda ag = new Agenda();
        Scanner ler = new Scanner(System.in);
        while (true) {
            System.out.println("Escreva as seguintes opções para seguir:");
            System.out.println("Digite Sair, para encerrar a execução");
            System.out.println(
                    "Digite Add, junto com o nome e os Arrays de Fones para adicionar um novo contato ex:\n\tid:número, oi:8899");
            System.out.println("Digite rmfone, junto com o nome e o index do fone");
            System.out.println("Digite Rm, junto com o nome(chave) para remover um contato");
            System.out.println("Digite procurar, junto com a substring ou sobrenome para procurar nos arquivos");
            System.out.println("Digite mostrar, para mostrar a situação atual da sua agenda e busca");
            System.out.println("");
            String op = ler.nextLine();
            String[] brok = op.split(" ");
            if (brok[0].equalsIgnoreCase("sair"))
                break;

            else if (brok[0].equalsIgnoreCase("add")) {
                ArrayList<Fone> fonees = new ArrayList<>();
                for (int i = 1; i <= brok.length; i++) {
                    String value = brok[i].split(":")[0];
                    String number = brok[i].split(":")[1];
                    fonees.add(new Fone(value, number));
                }
                ag.addContato(brok[1], fonees);
            } else if (brok[0].equalsIgnoreCase("rmfone"))
                ag.rmFone(brok[1], Integer.parseInt(brok[2]));

            else if (brok[0].equalsIgnoreCase("rm"))
                ag.rmContato(brok[1]);

            else if (brok[0].equalsIgnoreCase("procurar"))
                ag.procurar(brok[1]);

            else if (brok[0].equalsIgnoreCase("mostrar"))
                ag.show(ag.getContatos());

            else
                System.out.println("Opção invalida");
        }
        ler.close();
    }
}
