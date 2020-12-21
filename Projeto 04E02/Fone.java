import java.util.*;
public class Fone{
    private String operadora;
    private String number;
    public boolean validanumero(){
        String validos = "0123456789-.()";

        for(char aux : this.number.toCharArray()){
            if(validos.indexOf(aux) == -1)
                return false;
        }
        return true;    
    }
    public Fone(String label, String numero){
        this.operadora = label;
        this.number = numero;
    }
    public String getNumber() {
        return number;
    }
    public String getOperadora() {
        return operadora;
    }
    public String toString(){
        return  this.operadora + ":" + this.number;
    }
}