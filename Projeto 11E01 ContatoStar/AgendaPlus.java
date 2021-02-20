import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class AgendaPlus extends Agenda {
    private Map<String, ContatoPlus> boookmarks;

    public AgendaPlus() {
        super();
        this.boookmarks = new TreeMap<>();
    }

    public Map<String, ContatoPlus> getBoookmarks() {
        return boookmarks;
    }

    @Override
    public void rmContato(String id) {
        super.rmContato(id);
        if (this.boookmarks.get(id) == null) {
            throw new NullPointerException("Contato não existe, é null");
        }
        if (this.boookmarks.containsKey(id)) {
            this.boookmarks.remove(id);
        }
    }

    public void bookmark(String id) {
        if (this.getContatos().containsKey(id)) {
            ContatoPlus c = new ContatoPlus(id, this.getContatos().get(id).getFones());
            this.boookmarks.put(id, c);
            this.boookmarks.get(id).setStarred(true);
        }
    }

    public void unbookmark(String id) {
        for (Map.Entry<String, ContatoPlus> con : boookmarks.entrySet()) {
            if (con.getKey().equalsIgnoreCase(id))
                this.boookmarks.remove(id);
        }
    }

    public Map<String, ContatoPlus> searchBookmark(String pattern) {
        Map<String, ContatoPlus> aux = new TreeMap<>();
        for (Map.Entry<String, ContatoPlus> con : boookmarks.entrySet()) {
            boolean achou = false;
            if (con.getKey().contains(pattern))
                achou = true;

            for (Fone fon : con.getValue().getFones()) {
                if (fon.getLabel().contains(pattern) || fon.getNumber().contains(pattern))
                    achou = true;
            }
            if (achou)
                aux.put(con.getKey(), con.getValue());
        }
        if (aux.isEmpty())
            throw new NullPointerException("Não achadooo");

        return aux;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (Map.Entry<String, Contato> cont : getContatos().entrySet()) {
            if (this.boookmarks.containsKey(cont.getKey())) {
                buffer.append("@ ").append(cont).append("\n");
                continue;
            }
            buffer.append("- ").append(cont).append("\n");
        }
        return super.toString();
    }
}
