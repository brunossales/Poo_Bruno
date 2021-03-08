public class ContaPoupanca extends Conta {
    protected float rendimento;

    ContaPoupanca(int id, String idCliente) {
        super(id, idCliente);
        super.type = "CP";
    }

    public void atualizacaomensal() {
        rendimento = rendimento + (super.saldo * 0.01f);
        super.saldo += rendimento;
    }

}
