import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        PulaPula criancinha = new PulaPula();
        Scanner ler;
        ler = new Scanner(System.in);
        while (true) {
            System.out.println("Digite 'chegar', depois o nome e a idade da criança que chegou na fila de espera");
            System.out.println(
                    "Digite 'entrar', para tirar a criaça que está a mais tempo na fila de espera e coloca-la para brincar no Pula-Pula");
            System.out.println(
                    "Digite 'sair', para tirar a criança que está brincando a mais tempo e coloca-la na fila de espera");
            System.out.println(
                    "Digite 'remover', depois o nome da criança para procurarmos uma criança com esse nome e tira-la do pula-Pula");
            System.out.println("Digite 'procurar', e o numero da Criança conforme ela chegou na fila ou no Pula-Pula");
            System.out.println("Digite 'show', para mostrar como está a fila de espera e as crianças brincando");
            System.out.println("Digite 'fechar', para fechar o parquinho e a execução encerrar");
            String op = ler.nextLine();
            String[] queb = op.split(" ");
            try {
                if (queb[0].equals("chegar"))
                    criancinha.chegar(new Crianca(queb[1], Integer.parseInt(queb[2])));

                else if (queb[0].equals("entrar"))
                    criancinha.entrar();

                else if (queb[0].equals("sair"))
                    criancinha.sair();

                else if (queb[0].equals("remover"))
                    criancinha.remover(queb[1]);

                else if (queb[0].equals("procurar"))
                    criancinha.procurar(Integer.parseInt(queb[1]));

                else if (queb[0].equals("show"))
                    System.out.println(criancinha);

                else if (queb[0].equals("fechar")) {
                    criancinha.fechar();
                    System.out.println(criancinha);
                    break;
                } else
                    System.out.println("Comando invalido meu bom!");

                System.out.println("");

            } catch (IndexOutOfBoundsException z) {
                System.out.println("Rapaz tu deve ter esquecido um parametro o man");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("");
        }

        ler.close();
    }
}