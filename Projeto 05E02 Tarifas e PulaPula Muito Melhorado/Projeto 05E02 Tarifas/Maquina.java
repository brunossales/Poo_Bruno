import java.util.ArrayList;
import java.util.Set;

public class Maquina {
    private float saldo;
    private float lucro;
    private int maxProdutos;
    private ArrayList<Espiral> espirais;
    public ArrayList<Espiral> getEspirais() {
        return espirais;
    }
    public float getLucro() {
        return lucro;
    }
    public int getMaxProdutos() {
        return maxProdutos;
    }
    public float getSaldo() {
        return saldo;
    }
    public boolean inserirDinheiro(float valor){
            this.saldo += valor;
            return true;
    }
    public float troco(){
        System.out.println("Você tinha: " + saldo);
        float aux = this.saldo;
        this.saldo = 0;
        return aux;
    }
    public boolean vender(int index){
        if(index > this.espirais.size()){
            System.out.println("Esse produto não está aqui");
            return false;
        }
        else if(this.espirais.get(index).qtd <= 0){
            System.out.println("sem estoque");
            return false;
        }
        else if(this.espirais.get(index).preco > this.saldo){
            System.out.println("Você não tem saldo o suficiente para comprar");
            return false;
        }
        this.espirais.get(index).qtd -= 1;
        this.lucro += this.espirais.get(index).preco;
        System.out.println("Você comprou: " + this.espirais.get(index).nome);
        return true;
    }
    public boolean alterarEspiral(int idex, String nome, int qtd, float preco){
        if(idex > this.espirais.size()){
            System.out.println("Não existe esse espiral");
            return false;
        }
        this.espirais.set(idex, new Espiral(nome, qtd, preco));
        if(this.espirais.get(idex).qtd > this.maxProdutos){
            System.out.println("Passou da quantidade maxima suportado, vai ficar em estoque até o valor suportado, apenas!");
            this.espirais.set(idex, new Espiral(nome, this.maxProdutos, preco));
        }
        
        System.out.println("Espiral alterado!");
        return true;
    }
    public void limparEspiral(int index){
        if(index > this.espirais.size()){
            System.out.println("Este Espiral não esta aqui");
            return ;
        }
        this.espirais.set(index, new Espiral("-", 0, 0f));
        System.out.println("Espiral vazio!");
    }
    public void encerrando(){
        System.out.println("Fechando a maquina por hoje! \nO lucro de vendar foi de: " + this.lucro);
        this.espirais.clear();
        System.out.println("Todos os espirais foram limpos");
    }
    public void trocar(){
        espirais.clear();
        System.out.println("Espirais tirados para um novo junkfood");
    }
    Maquina(int maxProdutos, int qtdEspirais){
        this.espirais = new ArrayList<>();
        for(int i = 0; i < qtdEspirais; i++){
            this.espirais.add(new Espiral("-", 0, .0f));
        }
        this.maxProdutos = maxProdutos;
    }
    public String toString(){
        StringBuilder saida = new StringBuilder();
        saida.append("Saldo: " + saldo + "\n");
        for(int i = 0; i < espirais.size(); i++)
            saida.append(i + " " + espirais.get(i) + "\n");
        
        return saida.toString();
    }

}
