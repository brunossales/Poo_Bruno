import java.util.ArrayList;

import javax.management.RuntimeErrorException;

public class Topic {
    ArrayList<Pessoa> cadeiras;
    ArrayList<Pessoa> cadeirasPref;

    public Topic(int qmax, int qpref) {
        cadeiras = new ArrayList<>();
        cadeirasPref = new ArrayList<>();
        for (int i = 0; i < qmax; i++) {
            if (i < qpref)
                cadeirasPref.add(null);

            else
                cadeiras.add(null);
        }
    }

    public boolean subir(Pessoa pessoa) {
        if (pessoa.getIdade() >= 80) {
            for (int i = 0; i < cadeirasPref.size(); i++) {
                if (cadeirasPref.get(i) == null) {
                    System.out.println("Tem vaga na prereferência, sente-se senhor");
                    cadeirasPref.set(i, pessoa);
                    return true;
                }
            }
        }
        for (int i = 0; i < cadeiras.size(); i++) {
            if (cadeiras.get(i) == null) {
                System.out.println("Tem vaga nas cadeiras normais, sente-se senhor");
                cadeiras.set(i, pessoa);
                return true;
            }
        }
        for (int i = 0; i < cadeirasPref.size(); i++) {
            if (cadeirasPref.get(i) == null) {
                System.out.println("Não tem vaga nas cadeiras normais, mas tem na preferencia, sente-se");
                cadeirasPref.set(i, pessoa);
                return true;
            }
        }
        throw new RuntimeException("#Erro# : Topic cheiaaaa");
        return false;
    }

    public Pessoa descer(String nome) {
        Pessoa pessoaAux;
        for (int i = 0; i < cadeiras.size(); i++) {
            if (cadeiras.get(i).getNome().equals(nome)) {
                System.out.println("Pessoa encontrada nas cadeiras normais");
                pessoaAux = cadeiras.get(i);
                cadeiras.remove(i);
                return pessoaAux;
            }
        }
        for (int i = 0; i < cadeirasPref.size(); i++) {
            if (cadeirasPref.get(i).getNome().equals(nome)) {
                System.out.println("Pessoa encontrada na fila preferencial");
                pessoaAux = cadeirasPref.get(i);
                cadeirasPref.remove(i);
                return pessoaAux;
            }
        }
        throw new RuntimeErrorException("#Erro# : Pessoa nao esta aquiii");
        pessoaAux = null;
        return pessoaAux;
    }

    public void encerrar() {
        System.out.println("Vamos encerrar por hoje!");
        cadeiras.removeAll(cadeiras);
        cadeirasPref.removeAll(cadeirasPref);
    }

    public String toString() {
        String saida = "[ ";
        for (Pessoa pessoa : cadeirasPref) {
            if (pessoa != null)
                saida += pessoa + " ";

            else
                saida += "@ ";
        }
        for (Pessoa pessoa : cadeiras) {
            if (pessoa != null)
                saida += pessoa + " ";
            else
                saida += "= ";
        }
        return saida + "]";
    }
}
