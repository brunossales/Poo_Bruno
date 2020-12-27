import java.util.ArrayList;
import java.util.Arrays;
import java.util.jar.Attributes.Name;

public class Contato {
    private String name;
    ArrayList<Fone> fones = new ArrayList<>();
    public Contato(String nome){
        this.name = nome;
    }
    public void addfone(String label, String fone){
        Fone foneobject = new Fone(label, fone);
        if(foneobject.validanumero()){
            this.fones.add(foneobject);
        }
        else
            System.out.println("Número inválido");
        
    }
    public void rmfone(int index){
        this.fones.remove(index);
    }
    public void setName(String name) {
        this.name = name;
    }
    String getFonesString(){
        String result = "";
        for(int i = 0; i<this.fones.size(); i++){
            result += "[" + i + ":" + this.fones.get(i).toString() + "]   ";
        }
        return result;
    }
    public void show(){
        System.out.println(this);
    }
    public String toString() {
        return name + "\t" + getFonesString();
    }
}