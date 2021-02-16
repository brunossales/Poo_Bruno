public class Venda {
    private Pessoa cliente;
    private Evento evento;
    private Setor setor;
    private double valor;

    public Venda(Pessoa cliente, Evento evento, Setor setor) {
        this.cliente = cliente;
        this.evento = evento;
        this.setor = setor;
        if (this.cliente.getMeia())
            this.setor.setPreco();
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public Evento getEvento() {
        return evento;
    }

    public Setor getSetor() {
        return setor;
    }

    public double getValor() {
        return valor;
    }

    public String toString() {
        StringBuilder saida = new StringBuilder();
        saida.append(cliente.getNome()).append(", ").append(evento.getNome()).append(", ").append(setor.getNome());
        return saida.toString();
    }
}
