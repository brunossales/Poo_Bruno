import java.security.KeyStore.SecretKeyEntry;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

interface Pessoa {
    String getNome();

    int poder();
}

interface PessoaCivil {
    String getNome();

}

class Cidadao implements PessoaCivil, Pessoa {
    String nome;

    public Cidadao(String nome) {
        this.nome = nome;
    }

    void chamarHeroi(int vezes) {
        for (int i = 0; i < vezes; i++) {
            System.out.println("Venha me salvar heroiii");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public int poder() {
        return 0;
    }

    public String getNome() {
        return nome;
    }
}

class Herois implements Pessoa {
    String nome;
    int poder;

    public Herois(String nome, int poder) {
        this.nome = nome;
        this.poder = poder;
    }

    public void luta(Herois heroii, Herois her) {
        Random gerar = new Random(2);
        int sorte = gerar.nextInt(2);
        if (heroii.poder > her.poder) {
            if (sorte == 0) {
                System.out.println("Acertou a pancada");
                System.out.println(heroii.nome + " Diminiou o poder do cara man, corree");
                return;
            }
            throw new IndexOutOfBoundsException("Errou o golpe man");
        } else if (her.poder > heroii.poder) {
            if (sorte == 0) {
                System.out.println("Acertou a pancada");
                System.out.println(heroii.nome + " Diminuiu o podr cara man, corre");
                return;
            }
            throw new IndexOutOfBoundsException("Errou o golpe man, pois e");
        }
    }

    public int poder() {
        return poder;
    }

    public int setPoder(int poderAux) {
        this.poder = poderAux;
        return this.poder;
    }

    public String getNome() {
        return nome;
    }
}

class PowerRange {
    public static void main(String[] args) {
        ArrayList<Pessoa> pes = new ArrayList<>();
        Scanner ler = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Digite 'sair' Para encerrar a execução\n"
                        + "Digite 'Heroi', junto com o nome e o poder do PowerRange para fazer um novo\n"
                        + "Digite 'Cidadao' junto com o nome do cidadão comum para fazer um novo\n"
                        + "Digite 'luta' e o nome do heroi aliado com o poder, junto com o nome do heroi inimigo com o poder\n"
                        + "Digite 'poder' junto com o nome, para ver o seu poder\n"
                        + "Digite mudarPoder, junto com o index do heroi e o valor em inteiro para mudar o seu poder\n"
                        + "Digite 'chamar' junto com o nome do cidadao e o valor em inteiro de quantas vezes quer chamar\n");
                String op = ler.nextLine();
                String[] brok = op.split(" ");
                if (brok[0].equalsIgnoreCase("sair"))
                    break;

                else if (brok[0].equalsIgnoreCase("Heroi")) {
                    pes.add(new Herois(brok[1], Integer.parseInt(brok[2])));
                }

                else if (brok[0].equalsIgnoreCase("cidadao")) {
                    pes.add(new Cidadao(brok[1]));
                }

                else if (brok[0].equalsIgnoreCase("luta")) {
                    System.out.println("Espere alguns segundos por essa luta incrivelll");
                    try {
                        Thread.sleep(6000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Herois aux = new Herois("Heroi que vai ver a luta", 8);
                    aux.luta(new Herois(brok[1], Integer.parseInt(brok[2])),
                            new Herois(brok[3], Integer.parseInt(brok[4])));
                    if (Integer.parseInt(brok[2]) > Integer.parseInt(brok[4])) {
                        pes.add(new Herois(brok[1], Integer.parseInt(brok[2])));
                        System.out.println(brok[3] + " Morreu na luta");
                    } else if (Integer.parseInt(brok[2]) < Integer.parseInt(brok[4])) {
                        pes.add(new Herois(brok[3], Integer.parseInt(brok[4])));
                        System.out.println(brok[1] + " Morreu na luta man");
                    }
                } else if (brok[0].equalsIgnoreCase("poder")) {
                    for (Pessoa h : pes) {
                        if (h instanceof Herois) {
                            System.out.println("Nome do heroi: " + h.getNome() + " poder " + h.poder());
                        }
                    }
                } else if (brok[0].equalsIgnoreCase("mudarPoder")) {
                    if (Integer.parseInt(brok[1]) < pes.size()) {
                        pes.set(Integer.parseInt(brok[1]), new Herois(brok[2], Integer.parseInt(brok[3])));
                    } else
                        throw new IndexOutOfBoundsException("Nao foi encontrado o que voce queria");
                } else if (brok[0].equalsIgnoreCase("chamar")) {
                    Cidadao pessoa = new Cidadao(brok[1]);
                    pessoa.chamarHeroi(Integer.parseInt(brok[2]));
                } else if (brok[0].equalsIgnoreCase("mostrar")) {
                    for (Pessoa p : pes) {
                        System.out.println("Nome: " + p.getNome() + ", poder: " + p.poder());
                    }
                }
            } catch (ArrayIndexOutOfBoundsException z) {
                System.out.println("Erro nos arrays brow");
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.toString());
            }
        }
    }
}
