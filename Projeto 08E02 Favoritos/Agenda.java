import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Agenda {
    private Map<String, Contato> contatos;

    public Agenda() {
        this.contatos = new TreeMap<>();
    }

    public void addContato(String name, ArrayList<Fone> fones) {
        if (fones.isEmpty())
            throw new NullPointerException("Digite algum fone");

        for (Fone fone : fones) {
            if (!Fone.validaNum(fone.getNumber())) {
                fones.remove(fones.indexOf(fone));
            }
        }

        if (contatos.containsKey(name)) {
            this.contatos.get(name).addFones(fones);
            return;
        }
        this.contatos.put(name, new Contato(name, fones));
    }

    public void bookmark(String id) {
        if (contatos.get(id) == null) {
            throw new NullPointerException("Contato não existe, é null point");
        }
        if (contatos.containsKey(id)) {
            contatos.get(id).setStarred(true);
        }
    }

    public void unstar(String id) {
        if (contatos.get(id) == null) {
            throw new NullPointerException("Contato não existe, é null viu");
        }
        if (contatos.containsKey(id)) {
            contatos.get(id).setStarred(false);
        }
    }

    public void rmContato(String id) {
        if (contatos.get(id) == null) {
            throw new NullPointerException("Contato não existe, é null");
        }
        if (contatos.containsKey(id)) {
            unstar(id);
            contatos.remove(id);
        }
    }

    public Map<String, Contato> getContatos() {
        return contatos;
    }

    public Map<String, Contato> getContatos(String id) {
        Map<String, Contato> aux = new TreeMap<>();
        if (contatos.get(id) == null) {
            throw new NullPointerException("Contato não existe, é null man");
        }
        for (Map.Entry<String, Contato> contato : contatos.entrySet()) {
            if (contato.getKey().equals(id)) {
                aux.put(id, new Contato(contatos.get(id).getName(), contatos.get(id).getFones()));
                return aux;
            }
        }
        return null;
    }

    public Map<String, Contato> procurarbookmark(String name) {
        if (contatos.get(name) == null) {
            throw new NullPointerException("Contato não existe, é null man");
        }
        Map<String, Contato> aux = new TreeMap<>();
        for (Map.Entry<String, Contato> contato : contatos.entrySet()) {
            if (contato.getValue().isStarred()) {
                aux.put(contato.getKey(), contato.getValue());
            }
        }
        return aux;
    }

    public void rmFoneC(String id, int index) {
        for (Map.Entry<String, Contato> contato : contatos.entrySet()) {
            if (contato.getKey().equals(id)) {
                contatos.get(id).rmFone(index);
            }
        }
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (Map.Entry<String, Contato> contato : contatos.entrySet()) {
            if (contato.getValue().isStarred()) {
                buffer.append("@ ").append(contato);
            }
            if (!contato.getValue().isStarred()) {
                buffer.append("- ").append(contato);
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
