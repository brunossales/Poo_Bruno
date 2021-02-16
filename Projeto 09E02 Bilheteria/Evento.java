import java.util.Map;
import java.util.TreeMap;

public class Evento {
    private String nome;
    private Map<String, Setor> repSetores = new TreeMap<>();

    public void addSetor(Setor setor) {
        this.repSetores.put(setor.getNome(), setor);
    }

    public String getNome() {
        return nome;
    }

    public Map<String, Setor> getRepSetores() {
        return repSetores;
    }

    Evento(String nome) {
        this.nome = nome;
    }

    public String toString() {
        StringBuilder saida = new StringBuilder();
        saida.append(nome).append("\n");
        for (Map.Entry<String, Setor> m : this.repSetores.entrySet()) {
            saida.append(m.getValue()).append("\n");
        }
        return saida.toString();
    }
}
