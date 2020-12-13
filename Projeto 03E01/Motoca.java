    import java.util.Scanner;
    class Pessoa{
        int idade;
        String nome;
        Pessoa(String nome, int idade){
            this.idade = idade;
            this.nome = nome;
     }
}
    
    class Moto{
        int potencia;
        int tempo;
        Pessoa pass;
        Moto(int potencia){
            this.potencia = potencia;
            this.tempo = 0;
        }
        void comprarTempo(int valor){
            this.tempo += valor;
            System.out.println("Acabou de comprar: " + valor);
        }
        void subir(Pessoa Pessoa){
            if(this.pass == null && Pessoa.idade < 10){
                this.pass = Pessoa;
                System.out.println(Pessoa.nome + " Subiu, idade: " + Pessoa.idade);
                return ;
            }
            if(this.pass == null && Pessoa.idade >= 10){
                System.out.println("Tu é muito grande pra andar de motinha, menino!");
                return ;
            }
            System.out.println("Já tem menino na moto!");
            
        }
        Pessoa descer(){
            Pessoa aux = this.pass;
            if(this.pass == null){
                System.out.println("A moto está vazia!");
                return aux;
            }
            System.out.println(this.pass.nome + " Desceu");
            this.pass = null;
            return aux;
        }
        void dirigir(int tempo){
            if(this.pass != null){
                for(int i=0; i<tempo; i++){
                    this.tempo -= 1;
                    if(this.tempo == -1){
                        System.out.println("Andou " + i + " e o tempo acabou");
                        return ;
                    }
                }
                System.out.println("Andou: " + tempo);
                return ;
            }
            System.out.println("Não tem nenhuma criança na motinha!");
        }
        void buzina(int buzina){
            if(this.pass != null){
                for(int i=0; i<buzina; i++){
                    if(i == 0)
                        System.out.println("P");
                    if(i == buzina-1)
                        System.out.println("M");
                    else
                        System.out.println("E");
                }
                return ;
            }
            System.out.println("A motinha está vazia");
        }
        public String toString(){
            if(this.pass == null){
                return "Potencia: " + potencia + " [Nenhuma criança na motinha]";
            }
            return "Potencia: " + potencia + " [Nome: " + pass.nome + " Idade: " + pass.idade + "]";
        }

}
public class Motoca{
    public static void main(String[] args) {
        Scanner lendo = new Scanner(System.in);
        System.out.println("Digite quanto você quer de potencia na motoca: ");
        int num = lendo.nextInt();
        while(true) {
            
            if(num == 0)
                System.out.println("A moto não vai sair do lugar com essa potencia! Digite de novo:");

            else if(num < 20){
                System.out.println("Agora sim a Potencia tá certa para uma criança!\n");
                break;
            }
            else
                System.out.println("Essa potencia esta muito alta para uma criança! Digite de novo: ");
            
                num = lendo.nextInt();
        }
        System.out.println("Digite 'subir' junto com o nome e a idade para alguem subir na moto");
        System.out.println("Digite 'comprar' junto com o quanto deseja pagar para comprar tempo");
        System.out.println("Digite 'descer' para a pessoa que esta descer");
        System.out.println("Digite 'dirigir' e o quanto de tempo deseja dirigir para dirigir na moto");
        System.out.println("Digite 'mostrar' para mostrar o status da motinha");
        System.out.println("Digite 'buzinar' e um numero inteiro, que é o tamanho da 'buzinada'");
        System.out.println("Digite 'end' para guardar a moto");
        Moto Moto = new Moto(num);
        Pessoa Pessoa = new Pessoa("A pessou que inciou", 3);
        Moto.descer();
        while(true){
            String linha = lendo.nextLine();
            String[] queb = linha.split(" ");
                if(queb[0].equals("subir")){
                    Moto.subir(new Pessoa(queb[1], Integer.parseInt(queb[2])));
                }
                else if(queb[0].equals("comprar")){
                    Moto.comprarTempo(Integer.parseInt(queb[1]));
                }
                else if(queb[0].equals("descer")){
                    Moto.descer();
                }
                else if(queb[0].equals("dirigir")){
                    Moto.dirigir(Integer.parseInt(queb[1]));
                }
                else if(queb[0].equals("mostrar")){
                    System.out.println(Moto);
                }
                else if(queb[0].equals("buzinar")){
                    Moto.buzina(Integer.parseInt(queb[1]));
                }
                else if(queb[0].equals("end")){
                    System.out.println("Motoca vai ser guardada, estatus: ");
                    System.out.println(Moto);
                    break;
                }
        }
        lendo.close();
    }
}
