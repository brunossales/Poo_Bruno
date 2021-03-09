import java.util.ArrayList;

public class Cliente {
    protected String idCliente;
    protected ArrayList<Conta> contas = new ArrayList<>();

    Cliente(String id) {
        this.idCliente = id;
    }

    public void deposita(int index, float value) {
        contas.get(index).saldo += value;
    }

    public String toString() {
        StringBuilder saida = new StringBuilder();
        saida.append(idCliente).append("\n\t");
        saida.append(contas);
        return saida.toString();
    }
}
