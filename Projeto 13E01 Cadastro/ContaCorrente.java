public class ContaCorrente extends Conta {

    ContaCorrente(int id, String idCliente) {
        super(id, idCliente);
        super.type = "CC";
    }

}
