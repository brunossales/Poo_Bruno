public class ContaPoupanca extends Conta {

    ContaPoupanca(int id, String idCliente) {
        super(id, idCliente);
        super.type = "CP";
    }

}
