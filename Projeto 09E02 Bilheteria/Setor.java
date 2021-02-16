public class Setor {
    private String nome;
    private double preco;
    private int qtd;
    private int capacidade;

    public void vender() {
        if (this.qtd >= this.capacidade) {
            throw new IndexOutOfBoundsException("Já atingiu o maximo, cara!!");
        }
        this.qtd++;
    }

    Setor(String nome, double preço, int capacidade) {
        this.nome = nome;
        this.preco = preço;
        this.capacidade = capacidade;
    }

    public void setPreco() {
        this.preco = this.preco / 2;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQtd() {
        return qtd;
    }

    public String toString() {
        StringBuilder saida = new StringBuilder();
        saida.append("    -[ Nome do Setor: ").append(nome).append("; Preço: ").append(preco)
                .append("; Quat. Pessoas: ").append(qtd).append("; Núm. máx.: ").append(capacidade);

        return saida.toString();
    }

}