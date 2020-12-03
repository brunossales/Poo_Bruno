public class Carro {
    public float combustivel;
    public float combustivelMax = 200;
    public int nPessoas;
    public int nPessoasMax = 2;
    public float km;
    public int aux = 0;

    public int in(int num){
        if(this.nPessoas<this.nPessoasMax){
            this.nPessoas += num;
            System.out.println("\nPessoas embarcaram, total: " + this.nPessoas);
            
        }
        else{
            System.out.println("\nMáximo de pessoas ja atingido no carro! total: " + this.nPessoas);
        }
        return this.nPessoas;
        
    }
    public int out(int num){
        if(this.nPessoas>=0){
            this.nPessoas -= num;
            System.out.println("\nPessoas desembarcaram, total: " + this.nPessoas);
            
        }
        else{
            System.out.println("\nNumero minimo atingido, total: " + this.nPessoas);
        }
        return this.nPessoas;
    }
    public void fuel(float value){
        this.combustivel += value;
            if(this.combustivel > this.combustivelMax)
                this.combustivel = 200;
                
        System.out.println("\nAbasteceu: "  + value);
        System.out.println("Total: "  + this.combustivel);
    }
    
    public float drive(int distancia){
        
        for(int i = distancia; i>0; i--){
            if(this.combustivel <= 0){
                System.out.println("\nO Combustivel acabou!");
                this.aux = 1;
                break;
            }
            this.combustivel -= 1;
            this.km += 1;
        }
        
        if(this.combustivel > 0){
            System.out.println("\nAndou em Km: " + this.km);
        }
        return this.km;
    }
    public String show(){
        return "\nKilometragem andada: " + this.km;
    }
}
