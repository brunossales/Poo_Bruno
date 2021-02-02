import java.util.ArrayList;

import javax.management.RuntimeErrorException;

public class Contato {
    private String name;
    private ArrayList<Fone> fones;
    private boolean starred;

    public Contato(String nome) {
        this.name = nome;
        this.fones = new ArrayList<>();
        this.starred = false;
    }

    public Contato(String nome, ArrayList<Fone> fonees) {
        this.name = nome;
        this.fones = fonees;
        this.starred = false;
    }

    public ArrayList<Fone> getFones() {
        return fones;
    }

    public String getName() {
        return name;
    }

    public boolean isStarred() {
        return starred;
    }

    public void addFone(String label, String number) {
        if (!Fone.validaNum(number)) {
            throw new IndexOutOfBoundsException("Número invalido");
        }
        this.fones.add(new Fone(label, number));
    }

    public void addFones(ArrayList<Fone> fonee) {
        for (Fone foness : fonee) {
            addFone(foness.getLabel(), foness.getNumber());
        }
    }

    public boolean rmFone(int index) {
        try {
            fones.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro, digite um index valido!");
        }

        return true;
    }

    public void setStarred(boolean star) {
        this.starred = star;
    }

    public String toString() {
        StringBuilder saida = new StringBuilder();
        for (int i = 0; i < fones.size(); i++) {
            saida.append("[").append(i).append(":").append(fones.get(i).getLabel()).append(":")
                    .append(fones.get(i).getNumber()).append("]");
        }
        return saida.toString();
    }
}
