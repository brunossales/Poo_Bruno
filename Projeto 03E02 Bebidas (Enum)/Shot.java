import java.util.Random;
public class Shot {
    float valor = 0.0f;
    int resistencia=0; // resistencia a copos de bebidas
    int resistenciaMax;
    boolean estaBebado = false;
    
    Shot(int resistencia_alcool) {
        this.resistenciaMax = resistencia_alcool;
    }

    boolean TomarShot(Bebidas bebida){
        Random gerar = new Random();
        int i = gerar.nextInt(2);
        if(i == 0){
            System.out.println("Errou o copo da boca, Parece que ta ficando bebado...");
            return false;
        }
        if(this.estaBebado == true){
            System.out.println("Tu ja ta é bebo! È melhor ir para casa.");
            return false;
        }
        this.valor += bebida.getValor();
        this.resistencia += 1;
        testeAlcoolico();
        System.out.println("Acertou o copo em, tomou a dose de: " + bebida.toString());
        if(!estaBebado) return true;
        if(this.resistencia > this.resistenciaMax - 2)
            System.out.println("Você está perto de ficar bebado!");
        
        return true;
    }  
    boolean testeAlcoolico(){
       if(this.resistencia >= this.resistenciaMax){
        estaBebado = true;
        return true;
       }
       return false;
    }
    public String toString(){
        return "Divida no bar: " + valor;
    }
}
