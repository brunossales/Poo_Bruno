import javax.print.attribute.standard.MediaSize.Other;

public class Conta {
    protected int id;
    protected float saldo;
    protected String idCliente;
    protected String type;
    protected float rendimento;

    Conta(int id, String idCliente) {
        this.id = id;
        this.idCliente = idCliente;
    }

    public void sacar(float value) {
        if (saldo - value < 0) {
            throw new EceSaldo();
        }
        this.saldo -= value;
        if (this.saldo < 0)
            this.saldo = 0;
    }

    public void atualizacaomensal() {
        if (type.equals("CP")) {
            rendimento = saldo * 0.01f;
            saldo = saldo + rendimento;
        } else {
            rendimento -= 20f;
            saldo += rendimento;
            rendimento = 0;
        }

    }

    public void depositar(float value) {
        this.saldo += value;
    }

    public void transferir(Conta Other, float value) {
        if (this.saldo - value < 0)
            throw new EceSaldo();

        this.saldo -= value;
        Other.saldo += value;
    }

    public String toString() {
        StringBuilder saida = new StringBuilder();
        saida.append(id).append(":").append(idCliente).append(":").append(saldo).append(":").append(type);
        return saida.toString();
    }
}