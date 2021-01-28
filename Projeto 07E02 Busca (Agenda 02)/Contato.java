import java.util.ArrayList;

public class Contato {
    private String name;
    private ArrayList<Fone> fones;

    public Contato(String nome) {
        this.name = nome;
        this.fones = new ArrayList<>();
    }

    public void addFone(String id, String number) {
        if (!Fone.validateNumber(number)) {
            System.out.println("Número invalido");
            return;
        }
        fones.add(new Fone(id, number));
    }

    public void addFones(ArrayList<Fone> fones) {
        for (Fone fone : fones) {
            addFone(fone.id, fone.number);
        }
    }

    public boolean rmFone(int index) {
        if (index > fones.size() || index < 0) {
            System.out.println("Index invalido");
            return false;
        }
        this.fones.remove(index);
        return true;
    }

    public ArrayList<Fone> getFones() {
        return fones;
    }

    public String getName() {
        return name;
    }
}