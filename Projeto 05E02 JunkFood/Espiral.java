public class Espiral{
    public String nome;
    public int qtd;
    public float preco;
        Espiral(String nome, int qtd, float preco){
            this.nome = nome;
            this.preco = preco;
            this.qtd = qtd;
        }
        public String toString(){
            return "[" + nome + " : " + qtd + " U :" + preco + " RS]";
        }
}