import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class ComparatorContato implements Comparator<Contato> {
    @Override
    public int compare(Contato contato1, Contato contato2) {
        if (contato1 == null)
            return -1;
        if (contato2 == null)
            return -1;

        return contato1.getName().compareTo(contato2.getName());
    }
}

public class Agenda {
    private ArrayList<Contato> contatos;

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public Agenda() {
        this.contatos = new ArrayList<Contato>();
    }

    public int findContato(String name) {
        for (int i = 0; i < contatos.size(); i++) {
            if (contatos.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void addContato(String name, ArrayList<Fone> fones) {
        Contato contato = new Contato(name);
        if (fones.isEmpty()) {
            System.out.println("Digite alguma coisa para o contato!");
            return;
        }
        int idContato = findContato(name);
        if (idContato != -1) {
            System.out.println("O Contato ja existe!");
            contatos.get(idContato).addFones(fones);
            return;
        }
        for (Fone fonn : fones) {
            if (!Fone.validateNumber(fonn.number))
                fones.remove(fones.indexOf(fonn));
        }

        for (Fone fon : fones)
            contato.addFone(fon.id, fon.number);

        this.contatos.add(contato);
        Collections.sort(contatos, new ComparatorContato());
    }

    public boolean rmContato(String name) {
        if (findContato(name) == -1) {
            System.out.println("Contato não foi encontrado!");
            return false;
        }
        System.out.println("Contato encontrado: " + name);
        this.contatos.remove(findContato(name));
        return true;
    }

    public boolean rmFone(String name, int index) {
        int indexC = this.findContato(name);
        if (indexC == -1) {
            System.out.println("Contato/Chave nao encontrado");
            return false;
        }
        if (index > contatos.get(indexC).getFones().size()) {
            System.out.println("Index é muito grande!");
            return false;
        }
        contatos.get(indexC).getFones().remove(index);
        return true;
    }

    public ArrayList<Contato> procurar(String pattern) {
        ArrayList<Contato> encontrados = new ArrayList<>();
        for (Contato con : contatos) {
            if (con.getName().indexOf(pattern) != -1) {
                encontrados.add(con);
            }
        }
        if (!Fone.validateNumber(pattern))
            System.out.println("Número não está no padrão");

        else if (Fone.validateNumber(pattern)) {
            for (int i = 0; i < contatos.size(); i++) {
                for (Fone fon : contatos.get(i).getFones()) {
                    if (fon.number.indexOf(pattern) != -1) {
                        encontrados.add(contatos.get(i));
                    }
                }
            }
        }
        return encontrados;
    }

    public void show(ArrayList<Contato> listContatos) {
        Collections.sort(listContatos, new ComparatorContato());
        StringBuilder saida = new StringBuilder();
        for (Contato contato : listContatos) {
            saida.append(contato.getName());
            for (int i = 0; i < contato.getFones().size(); i++) {
                saida.append(" [" + contato.getFones().get(i) + "]");
            }
            saida.append("\n");
        }
        System.out.println(saida.toString());
    }

    public Contato getContato(String name) {
        if (findContato(name) == -1) {
            System.out.println("Esse contato não está na agenda");
            return null;
        }
        return contatos.get(findContato(name));
    }
}
