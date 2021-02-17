import java.util.ArrayList;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

class Crianca {
    String nome;
    int idade;

    public Crianca(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String toString() {
        return nome + ":" + idade;
    }
}

class PulaPula {
    ArrayList<Crianca> esperando;
    ArrayList<Crianca> brincando;

    public PulaPula() {
        this.esperando = new ArrayList<>();
        this.brincando = new ArrayList<>();
    }

    public void chegar(Crianca crianca) {
        if (crianca.idade <= 14)
            esperando.add(0, crianca);

        else if (crianca.idade > 14)
            System.out.println("Você nem é criança");
    }

    // tira da fila de espera e coloca na fila brincando
    public void entrar() {
        if (esperando.isEmpty()) {
            System.out.println("Nenhuma criança na fila de espera");
            return;
        }
        // obtive a crianca
        Crianca primeira = esperando.get(esperando.size() - 1);
        // retirei do vetor esperando
        esperando.remove(esperando.size() - 1);
        // adicionei na primeira posicao do vetor brincando
        brincando.add(0, primeira);
    }

    // tira da fila de brincando e coloca na fila de espera
    public void sair() {
        if (brincando.isEmpty()) {
            throw new NullPointerException("Não foi encontrado cara");
        }
        Crianca primeiraAbrincar = brincando.get(brincando.size() - 1);
        brincando.remove(brincando.size() - 1);
        esperando.add(0, primeiraAbrincar);

    }

    public Crianca remover(String nome) {
        for (Crianca obj : esperando) {
            if (obj.nome.equals(nome)) {
                Crianca sair = obj;
                esperando.remove(obj);
                System.out.println("Criança encontrada, estava na fila de espera, agora ela vai pra casa");
                return sair;
            }
        }
        for (Crianca objeto : brincando) {
            if (objeto.nome.equals(nome)) {
                Crianca sair = objeto;
                brincando.remove(objeto);
                System.out.println("Criança encontrada, estava brincando, agora ela vai pra casa");
                return sair;
            }
        }
        System.out.println("A criança não foi encontrada");
        return null;
    }

    public void procurar(int index) {
        System.out.println(
                "Digite 'espera' ou 'brincando' para remover a criança da posição que você digitou respectivamente");
        Scanner lerr = new Scanner(System.in);
        while (true) {
            String opp = lerr.next();
            if (opp.equals("espera")) {
                if (esperando.size() >= index) {
                    System.out.println("Criança encontrada, agora ela vai pra casa");
                    esperando.remove(index);
                    return;
                }

                System.out.println("Criança não foi encontrada com essa posição na fila");
                return;
            } else if (opp.equals("brincando")) {
                if (brincando.size() >= index) {
                    System.out.println("Criança encontrada, agora ela vai pra casa");
                    brincando.remove(index);
                    break;
                }

                System.out.println("Criança não foi encontrada com essa posição de entrada no Pula-Pula");
                return;
            } else
                System.out.println("Opção inexistente");

            System.out.println("");
        }
    }

    public void fechar() {
        System.out.println("O parquinho está fechando por hoje!\nTodas Crianças da lista Espera e Brincando sairam!");
        brincando.removeAll(brincando);
        esperando.removeAll(esperando);
    }

    public String toString() {
        return "=>" + esperando + " => " + brincando;
    }
}