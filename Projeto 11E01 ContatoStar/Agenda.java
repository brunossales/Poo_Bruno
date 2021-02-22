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

    public void rmContato(String id) {
        if (contatos.get(id) == null) {
            throw new NullPointerException("Contato não existe, é null");
        }
        if (this.contatos.containsKey(id)) {
            this.contatos.remove(id);
        }
    }

    public Map<String, Contato> getContatos() {
        return contatos;
    }

    public Map<String, Contato> getContatos(String id) {
        Map<String, Contato> aux = new TreeMap<>();
        if (this.contatos.get(id).getName() == null) {
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

    boolean achou = false;

    public Map<String, Contato> search(String pattern) {
        Map<String, Contato> aux = new TreeMap<>();
        for (Map.Entry<String, Contato> con : contatos.entrySet()) {

            if (con.getKey().contains(pattern))
                this.achou = true;

            for (Fone fon : con.getValue().getFones()) {
                if (fon.getLabel().contains(pattern) || fon.getNumber().contains(pattern))
                    this.achou = true;
            }
            if (this.achou)
                aux.put(con.getKey(), con.getValue());
        }
        if (aux.isEmpty())
            throw new NullPointerException("Não achadooo");

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
            buffer.append("- ").append(contato);
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
