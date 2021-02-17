import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite a quantidade máxima da topic");
        int tam = ler.nextInt();
        System.out.println("Digite a quantidade de cadeiras preferenciais");
        int pref = ler.nextInt();
        Topic topic = new Topic(tam, pref);
        System.out.println("Digite subir junto com o nome e a idade do passageiro");
        System.out.println("Digite descer junto com o nome do passageiro para desce-lo se ele estiver na topic");
        while (true) {
            try {
                String op = ler.nextLine();
                String[] queb = op.split(" ");
                if (queb[0].equalsIgnoreCase("subir")) {
                    topic.subir(new Pessoa(Integer.parseInt(queb[1]), queb[2]));
                    System.out.println(topic);
                } else if (queb[0].equalsIgnoreCase("descer")) {
                    topic.descer(queb[1]);
                    System.out.println(topic);
                } else if (queb[0].equalsIgnoreCase("encerrar")) {
                    topic.encerrar();
                    System.out.println("\n" + topic);
                    break;
                }
                System.out.println("");
            } catch (RuntimeException a) {
                System.out.println(a.toString());
            }
        }
        ler.close();
    }
}
