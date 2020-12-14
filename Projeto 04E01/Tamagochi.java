import java.util.Scanner;
class Pet{
    private int energiaMax;
    private int fomeMax;
    private int limpezaMax;
    private int limpeza;
    private int energia;
    private int fome;
    private int diamante;
    private int idade;
    private boolean vida = true;
    public void setenergia(int a){
        this.energia = a;
        if(this.energia > this.energiaMax)
            this.energia = this.energiaMax;

        if(this.energia < 0){
            this.vida = false;
            this.energia = 0;
            System.out.println("Matou o pet sem energia!");
        }
    }
    public void setfome(int a){
        this.fome = a;
        if(this.fome > this.fomeMax)
            this.fome = this.fomeMax;

        if(this.fome < 0){
            this.vida = false;
            this.fome = 0;
            System.out.println("Matou o pet sem energia!");
        }
    }
    public void setlimpeza(int a){
        this.limpeza = a;
        if(this.limpeza > this.limpezaMax)
            this.limpeza = this.limpezaMax;

        if(this.limpeza < 0){
            this.vida = false;
            this.limpeza = 0;
            System.out.println("Matou o pet de sujeira!");
        }
    }
    public void setidade(int a){
        this.idade = a;
    }
    public void setdiamante(int a){
        this.diamante = a;
    }
    public Pet(int enerMax, int fomMax, int limpMax){
        this.energiaMax = enerMax;
        this.fomeMax = fomMax;
        this.limpezaMax =  limpMax;

        this.energia = energiaMax;
        this.fome = fomeMax;
        this.limpeza = limpezaMax;
    }
    public int getdiamante() {
        return diamante;
    }
    public int getenergia() {
        return energia;
    }
    public int getenergiaMax() {
        return energiaMax;
    }
    public int getfome() {
        return fome;
    }
    public int getfomeMax() {
        return fomeMax;
    }
    public int getidade() {
        return idade;
    }
    public int getlimpeza() {
        return limpeza;
    }
    public int getlimpezaMax() {
        return limpezaMax;
    }
    public void brincar(){
        if(testaVida())
            return ;
        this.setenergia(getenergia() - 3);
        this.setfome(getfome() - 1);
        this.setlimpeza(getlimpeza() - 2);
        this.setdiamante(getdiamante() + 1);
        this.setidade(getidade() + 1); 
    }
    public void banho(){
        if(testaVida())
            return ;
        this.setenergia(getenergia() - 3);
        this.setfome(getfome() - 1);
        this.setlimpeza(this.limpezaMax);
        this.setidade(getidade() + 2);
    }
    public void comer(){
        if(testaVida())
            return ;
        this.setenergia(getenergia() - 1);
        this.setfome(getfome() + 4);
        this.setlimpeza(getlimpeza() - 2);
        this.setidade(getidade() + 2);
    }
    public void dormir(){
        if(testaVida())
            return ;
        if(this.energia < this.energiaMax){
            for(int i = 0; i < this.energiaMax; i++){
                this.setenergia(getenergia() + 1);
                this.setidade(getidade() + 1);
                if(this.energia == energiaMax)
                    break;
            }
            return ;
        }
        System.out.println("O pet não está com sono");
    }
    boolean testaVida(){
        if(!vida){
            System.out.println("Você não pode interagir com o seu pet, ele está morto!");
            return true;
        }
        return false;
    }
    public String toString(){
        return "E:" + energia + "/" + energiaMax + ", S:" +  fome + "/" + fomeMax + ", L:" + limpeza + "/" + limpezaMax + ", D:" + diamante + ", I:" + idade;
    }
}
public class Tamagochi {
    public static void main (String[] args) {
         Pet tamago = new Pet(20, 10, 15);
         while(true){
            System.out.println("Digite banhar, para dar banho no lazarento do pet");
            System.out.println("Digite brincar, para brincar com a peste do pet");    //Obs: É tudo brincandeira com o tamagochi. kkk
            System.out.println("Digite comer, para dar comida ao mizeravi do pet");
            System.out.println("Digite dormir, para deixar o pet dormir até suas energias ficaram cheias");
            System.out.println("Digite sair, para encerrar a brincadeira com o tamagochi");
            Scanner ler = new Scanner(System.in);
            String Escolha = ler.nextLine();
            if(Escolha.equals("banhar")){
                tamago.banho();
                System.out.println(tamago);
            }
            if(Escolha.equals("brincar")){
                tamago.brincar();
                System.out.println(tamago);
            }
            if(Escolha.equals("comer")){
                tamago.comer();
                System.out.println(tamago);
            }
            if(Escolha.equals("dormir")){
                tamago.dormir();
                System.out.println("Tamago Dormiu!");
                System.out.println(tamago);
            }
            if(Escolha.equals("sair")){
                System.out.println("Encerrando a execução! Estatus: ");
                System.out.println(tamago);
                break;
            }
            System.out.println("\n");
         }
         
    }
}
