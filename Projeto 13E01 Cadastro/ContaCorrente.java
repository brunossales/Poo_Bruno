public class ContaCorrente extends Conta {
    protected float rendimento;

    ContaCorrente(int id, String idCliente) {
        super(id, idCliente);
        super.type = "CC";
    }

    public void atualizacaomensal() {
        rendimento -= 20f;
        super.saldo += rendimento;
    }
}
