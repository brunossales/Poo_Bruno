import java.util.ArrayList;

public class Agencia {
    protected ArrayList<Cliente> clientes = new ArrayList<>();
    protected ArrayList<Conta> contas = new ArrayList<>();
    protected int cont;

    public void adicionarCliente(String idCliente) {
        clientes.add(new Cliente(idCliente));
        clientes.get(cont).contas.add(new ContaCorrente(cont, idCliente));
        clientes.get(cont).contas.add(new ContaPoupanca(cont + 1, idCliente));
        contas.add(new ContaCorrente(cont, idCliente));
        contas.add(new ContaPoupanca(cont + 1, idCliente));
        cont += 2;
    }

    public void reaguste() {
        for (int i = 0; i < contas.size(); i++) {
            contas.get(i).atualizacaomensal();
        }
        for (int i = 0; i < clientes.size(); i++) {
            clientes.get(i).contas.get(i).atualizacaomensal();
            clientes.get(i).contas.get(i + 1).atualizacaomensal();
        }

    }

    public String toString() {
        StringBuilder saida = new StringBuilder();
        for (int i = 0; i < contas.size(); i++) {
            saida.append(contas.get(i)).append("\n");
        }
        return saida.toString();
    }
}
