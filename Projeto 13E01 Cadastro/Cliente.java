import java.util.ArrayList;

public class Cliente {
    protected String idCliente;
    protected ArrayList<Conta> contas = new ArrayList<>();

    Cliente(String id) {
        this.idCliente = id;
    }
}
