public enum Bebidas {
    PITU(2), MONTILA(10), SKOL(5), SLOVA(1), GIN(2);
    private double valor;

    Bebidas(float valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}