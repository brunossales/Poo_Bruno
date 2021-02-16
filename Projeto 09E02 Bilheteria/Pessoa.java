public class Pessoa {
    private String nome;
    private boolean meia;

    public Pessoa(String nome, boolean pagMeia) {
        this.nome = nome;
        this.meia = pagMeia;
    }

    public String getNome() {
        return nome;
    }

    public boolean getMeia() {
        return meia;
    }

    public String toString() {
        StringBuilder saida = new StringBuilder();
        saida.append(nome).append(", ");
        if (this.meia == true) {
            saida.append("meia");
            return saida.toString();
        }
        saida.append("inteira");
        return saida.toString();
    }
}
