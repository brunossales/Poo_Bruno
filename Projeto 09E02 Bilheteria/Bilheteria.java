
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;

public class Bilheteria {
    private ArrayList<Venda> repVendas = new ArrayList<>();
    private Map<String, Pessoa> repPessoas = new TreeMap<>();
    private Map<String, Evento> repEvento = new TreeMap<>();
    private double caixa;

    public double getCaixa() {
        return caixa;
    }

    public void vender(String cliente, String evento, String setor) {
        if (repPessoas.get(cliente).getNome() == null)
            throw new NullPointerException("Não existe esse cliente");

        if (repEvento.get(evento).getNome() == null)
            throw new NullPointerException("Não existe esse evento");

        if (repEvento.get(evento).getRepSetores().get(setor).getNome() == null)
            throw new NullPointerException("Não existe esse setor");

        for (Venda venda : repVendas) {
            if (venda.getCliente().getNome().equalsIgnoreCase(cliente))
                throw new IndexOutOfBoundsException("Você já está em um show! sai fora");
        }

        this.repVendas.add(new Venda(repPessoas.get(cliente), repEvento.get(evento),
                repEvento.get(evento).getRepSetores().get(setor)));

        repEvento.get(evento).getRepSetores().get(setor).vender();

        this.caixa += repEvento.get(evento).getRepSetores().get(setor).getPreco();
    }

    public String showCaixa() {
        return "R$ " + caixa;
    }

    public String showVendas() {
        StringBuilder saida = new StringBuilder();
        for (Venda v : repVendas) {
            saida.append("[ ").append(v).append(" ]").append("\n");
        }
        saida.append("Caixa: ").append(caixa);
        return saida.toString();
    }

    public String showPessoas() {
        StringBuilder saida = new StringBuilder();
        for (Map.Entry<String, Pessoa> p : repPessoas.entrySet()) {
            saida.append("[ ").append(p.getValue()).append(" ]").append("\n");
        }
        return saida.toString();
    }

    public String showEventos() {
        StringBuilder saida = new StringBuilder();
        for (Map.Entry<String, Evento> e : repEvento.entrySet()) {
            saida.append(e.getValue()).append("\n");
        }
        return saida.toString();
    }

    public void addPessoa(String nome, boolean meia) {
        if (repPessoas.get(nome) != null)
            throw new IndexOutOfBoundsException("Essa pessoa ja está aqui!!");

        repPessoas.put(nome, new Pessoa(nome, meia));
    }

    public void addEvento(String idEvento) {
        if (repEvento.get(idEvento) != null)
            throw new IndexOutOfBoundsException("Este evento já existe!!");

        repEvento.put(idEvento, new Evento(idEvento));
    }

    public void addSetor(String idEvento, String idSetor, Double preco, int capacidade) {
        repEvento.get(idEvento).addSetor(new Setor(idSetor, preco, capacidade));
    }

}
